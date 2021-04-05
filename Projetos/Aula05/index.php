<?php

// Importa o autoloader do composer para acessar as classes do Leaf
require __DIR__ . "/vendor/autoload.php";

// Inicializa o framework Leaf
$app = new Leaf\App;

// Inicializa o banco de dados
// - salvar credenciais no código-fonte: pouco seguro 
// - melhor abordagem: salvar dados como arquivo de ambientes
$app->db()->connect("db4free.net:3306", "usuario_049789", "minha_senha_secreta", "db_teste_049789");


// ===========================================================================
// Criação das rotas
// ===========================================================================

// ---------------------------------------------------------------------------
// EXEMPLO 01
// Implementa o retorno da rota raíz "/" para o método GET
// ---------------------------------------------------------------------------
$app->get('/', function () use ($app) {

  // Envia a mensagem de resposta
  $app->response()->json([
    "mensagem" => "Alô, mamãe!"
  ]);
});

// ---------------------------------------------------------------------------
// EXEMPLO 02
// Tratamento de parâmetros na forma: ?nome=super&sobrenome=man
// ---------------------------------------------------------------------------
$app->get('/usuarios', function () use ($app) {
  $nome = $app->request()->get("nome");
  $sobrenome = $app->request()->get("sobrenome");

  // Verifica se os campos foram informados
  if (!$nome) $app->response()->throwErr('Nome é obrigatório', 500);
  if (!$sobrenome) $app->response()->throwErr('Sobrenome é obrigatório', 500);

  // Envia a mensagem de resposta
  $app->response()->json([
    "dados" => [
      "nome" => $nome,
      "sobrenome" => $sobrenome
    ]
  ]);
});

// ---------------------------------------------------------------------------
// EXEMPLO 03
// Recuperando parâmetros via BODY
// ---------------------------------------------------------------------------
$app->post('/usuarios', function () use ($app) {
  $body = $app->request()->body();

  // Verifica se os campos foram informados
  if (!array_key_exists("nome", $body)) $app->response()->throwErr('Nome é obrigatório', 500);
  if (!array_key_exists("sobrenome", $body)) $app->response()->throwErr('Sobrenome é obrigatório', 500);

  // Envia a mensagem de resposta
  $app->response()->json([
    "dados" => $body
  ]);
});

// ---------------------------------------------------------------------------
// EXEMPLO 04
// Recuperando parâmetros via URL
// ---------------------------------------------------------------------------
$app->delete('/usuarios/{id}/{quem}', function ($id, $quem) use ($app) {
  // Envia a mensagem de resposta
  // Código 410: confirma que o objeto foi deletado
  $app->response()->json(["mensagem" => "Deletado usuário $quem (id = $id)"], 410);
});


// ---------------------------------------------------------------------------
// AUTORES
// Exemplo de CRUD na tabela autores
// ---------------------------------------------------------------------------

// ---------------------------------------------------------------------------
// GET TODOS
// ---------------------------------------------------------------------------
$app->get('/autores', function () use ($app) {
  $limit = $app->request()->get("limit");
  $offset = $app->request()->get("offset");

  $autores = $app->db()
    ->query("SELECT * FROM authors LIMIT ? OFFSET ?")
    ->bind($limit, $offset)
    ->all();

  $app->response()->json($autores);
});

// ---------------------------------------------------------------------------
// GET 
// ---------------------------------------------------------------------------
$app->get('/autores/{id}', function ($id) use ($app) {
  $autor = $app->db()
    ->query("SELECT * FROM authors WHERE id = ?")
    ->bind($id)
    ->first();

  $app->response()->json($autor);
});


// ---------------------------------------------------------------------------
// POST
// ---------------------------------------------------------------------------
$app->post('/autores', function () use ($app) {
  $body = $app->request()->body();

  // Valida se todos os campos foram enviados
  foreach (["nome", "sobrenome", "email", "aniversario"] as $campo) {
    if (!array_key_exists($campo, $body)) $app->response()->throwErr('$campo é obrigatório', 500);
  }
  
  // Insere os dados no banco
  $res = $app->db()
    ->insert("authors")
    ->params([
      "first_name" => $body['nome'],
      "last_name" => $body['sobrenome'],
      "email" => $body['email'],
      "birthdate" => $body['aniversario']
    ])
    ->execute();

  // Verifica se deu certo o insert
  if ($res === false) $app->response->throwErr($app->db()->errors());

  $app->response()->status(201);
});

// ---------------------------------------------------------------------------
// PUT
$app->put('/autores/{id}', function ($id) use ($app) {
  $body = $app->request()->body();

  // Valida se todos os campos foram enviados
  foreach (["nome", "sobrenome", "email", "aniversario"] as $campo) {
    if (!array_key_exists($campo, $body)) $app->response()->throwErr('$campo é obrigatório', 500);
  }

  // Atualiza todos os dados no banco
  $res = $app->db()
    ->update("authors")
    ->params([
      "first_name" => $body['nome'],
      "last_name" => $body['sobrenome'],
      "email" => $body['email'],
      "birthdate" => $body['aniversario']
    ])
    ->where("id", $id)
    ->execute();

  // Verifica se deu certo o update
  if ($res === false) $app->response->throwErr($app->db()->errors());

  $app->response()->status(200);
});

// ---------------------------------------------------------------------------
// PATCH
// ---------------------------------------------------------------------------
$app->patch('/autores/{id}', function ($id) use ($app) {
  $body = $app->request()->body();

  // Atualiza apenas os campos informados
  $params = [];
  if (array_key_exists("nome", $body)) $params["first_name"] = $body['nome'];
  if (array_key_exists("sobrenome", $body)) $params["last_name"] = $body['sobrenome'];
  if (array_key_exists("email", $body)) $params["email"] = $body['email'];
  if (array_key_exists("aniversario", $body)) $params["birthdate"] = $body['aniversario'];

  // Insere os dados no banco
  $res = $app->db()
    ->update("authors")
    ->params($params)
    ->where("id", $id)
    ->execute();

  // Verifica se deu certo o update
  if ($res === false) $app->response->throwErr($app->db()->errors());

  $app->response()->status(200);
});

// ---------------------------------------------------------------------------
// DELETE
// ---------------------------------------------------------------------------
$app->delete('/autores/{id}', function ($id) use ($app) {

  // Deleta um autor do banco
  $res = $app->db()
    ->delete("authors")
    ->where("id", $id)
    ->execute();

  // Verifica se deu certo o delete
  if ($res === false) $app->response->throwErr($app->db()->errors());

  $app->response()->status(200);
});





// Executa as rotas definidas
$app->run();
