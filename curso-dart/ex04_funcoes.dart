// MIT License
//
// Copyright (c) 2025 Chauã Queirolo
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

// =============================================================================
// FUNÇÕES EM DART
// =============================================================================
// -----------------------------------------------------------------------------
// Autor...: Chauã Queirolo
// Data....: 22/08/2025
// -----------------------------------------------------------------------------

// -----------------------------------------------------------------------------
// 1) Funções sem retorno (void)
// -----------------------------------------------------------------------------
// - Uma função void não retorna valor.
// - Usada para executar ações, como imprimir no console.

void saudacao() {
  print('Olá, seja bem-vindo!');
}


// -----------------------------------------------------------------------------
// 2) Funções com retorno
// -----------------------------------------------------------------------------
// - Uma função pode retornar valores (nesse caso, int).
// - A arrow function (=>) é útil para expressões curtas.

int somar(int a, int b) {
  return a + b;
}

// Versão simplificada (arrow function)
int multiplicar(int a, int b) => a * b;

// Ela é equivalente a:
// int multiplicar(int a, int b) {
//   return a * b;
// }

// -----------------------------------------------------------------------------
// 3) Parâmetros posicionais
// -----------------------------------------------------------------------------
// - Parâmetros são obrigatórios e devem ser passados na ordem correta.
//      - Útil para funções com poucos parâmetros.
//      - Exemplo: somar(a, b) e multiplicar(a, b) acima.
// - Parâmetros opcionais são declarados entre [].

// A chamada pode ser:
//      potencia(3);        - calcula 3^2 (padrão)
//      potencia(3, 4);     - calcula 3^4
int potencia(int base, [int expoente = 2]) {
  int resultado = 1;
  for (int i = 0; i < expoente; i++) {
    resultado *= base;
  }
  return resultado;
}

// -----------------------------------------------------------------------------
// 4) Parâmetros nomeados e opcionais
// -----------------------------------------------------------------------------
// - Parâmetros nomeados são declarados entre {}.
//      - Permitem passar argumentos em qualquer ordem.
//      - Nome do parâmetro é obrigatório na chamada.
//      - Útil para funções com muitos parâmetros.
//      - Torna o código mais legível.
//
// - Tipos de paraâmetros nomeados:
//    required       → obriga a passagem do parâmetro.
//    (opcionais)    → definidos como {param = valor}.

// A chamada deve ser:
//    calcularIMC(peso: 70, altura: 1.75);
double calcularIMC({required double peso, required double altura}) {
  return peso / (altura * altura);
}

// A chamada pode ser:
//    formatarPreco(19.9);                - calcula com R$
//    formatarPreco(19.9, moeda: 'US$');  - calcula com US$
String formatarPreco({required double valor, String moeda = 'R\$'}) {
  return '$moeda valor';
}

// -----------------------------------------------------------------------------
// 5) Parâmetros posicionais e nomeados
// -----------------------------------------------------------------------------
// - Podemos misturar parâmetros posicionais e nomeados.
// - Parâmetros posicionais devem vir primeiro.
// - Útil para funções que têm alguns parâmetros obrigatórios e outros opcionais.

void cadastrarUsuario(String nome, {required int idade, String cidade = 'Desconhecida'}) {
  print('Nome: $nome, Idade: $idade, Cidade: $cidade');
}

// -----------------------------------------------------------------------------
// 6) Funções de alta ordem (recebem funções como parâmetro)
// -----------------------------------------------------------------------------
// - Em Dart, funções são "cidadãos de primeira classe".
//      - Podemos passá-las como parâmetro ou armazená-las em variáveis.
//      - Permitem passar comportamento para outras funções.
// - Usado em callbacks, filtros, mapeamentos, etc.

int aplicarOperacao(int a, int b, Function operacao) {
  return operacao(a, b);
}

// =============================================================================
// -----------------------------------------------------------------------------
// PROGRAMA PRINCIPAL
// -----------------------------------------------------------------------------
// =============================================================================
void main() {
  // Funções sem retorno
  saudacao();

  // Funções com retorno
  int s = somar(10, 20);
  int p = multiplicar(6, 7);
  print('Somar......: $s');
  print('Multiplicar: $p');

  // Parâmetros posicionais
  int pot = potencia(3);        // usa expoente padrão 2
  print('3^2 = $pot');

  pot = potencia(2, 5);         // calcula 2^5
  print('2^5 = $pot');

  // Parâmetros nomeados
  double imc = calcularIMC(peso: 72, altura: 1.74);
  print('IMC = $imc');

  imc = calcularIMC(altura: 1.80, peso: 90); // ordem não importa
  print('IMC = $imc');

  // Parâmetros opcionais
  print(formatarPreco(valor: 19.9));
  print(formatarPreco(valor: 19.9, moeda: 'US\$'));

  // Parâmetros posicionais e nomeados
  cadastrarUsuario('Batman', idade: 30);
  cadastrarUsuario('Monica', idade: 25, cidade: 'São Paulo');

  // Funções de alta ordem
  // - Passando funções como parâmetro
  var x1 = aplicarOperacao(10, 20, somar);        // usa a função somar
  var x2 = aplicarOperacao(10, 20, multiplicar);  // usa a função multiplicar

  print('x1 = $x1 | x2 = $x2');

  // Função anônima (lambda) como parâmetro
  // - Não tem nome, usada apenas uma vez.
  // - Útil para passar comportamento rapidamente.
  //      Sintaxe: (parametros) => expressão
  //      Exemplo: (x, y) => x + y
  int soma = aplicarOperacao(3, 4, (x, y) => x + y);
  int mult = aplicarOperacao(3, 4, (x, y) => x * y);
  int maximo = aplicarOperacao(3, 4, (x, y) => (x > y) ? x : y);

  print('Soma  via lambda: $soma');
  print('Mult  via lambda: $mult');
  print('Maior via lambda: $maximo');

  // ---------------------------------------------------------------------------
  // ATIVIDADES
  // ---------------------------------------------------------------------------
  // 1) Crie uma função que receba uma String e retorne ela em "Uppercase"
  //
  // 2) Crie uma função que receba dois números e retorne o maior entre eles.
  //    - Use parâmetros nomeados.
  //    - Use arrow function.
  //
  // 3) Crie uma função que receba a altura e uma caractere (opcional, padrão '*')
  //    e imprima uma pirâmide com a altura e o caractere.
  //    - Use parâmetros posicionais e nomeados.
  //
  //    Exemplo: altura=3, caractere='#'
  //       #
  //      # #
  //     # # #

}
