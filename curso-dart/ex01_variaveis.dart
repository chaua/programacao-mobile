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
// VARIÁVEIS, TIPOS E INTERPOLAÇÃO
// =============================================================================
// -----------------------------------------------------------------------------
// Autor...: Chauã Queirolo
// Data....: 22/08/2025
// -----------------------------------------------------------------------------

void main() {
  // ---------------------------------------------------------------------------
  // 1) Variáveis: explícitas e implícitas
  // ---------------------------------------------------------------------------
  // - Variáveis explícitas:
  // - Variáveis implícitas (var): o Dart "descobre" o tipo pelo valor atribuído.
  // - Nos dois casos, o tipo não pode mudar depois (ex.: int não vira String).

  // Variáveis explícitas
  // - o tipo vem antes do nome da variável
  int    x1 = 10;
  double x2 = 3.14;
  bool   x3 = false;
  String x4 = 'Olá, mundo 🗺️';

  print('x1 = $x1 | x2 = $x2 | x3 = $x3 | x4 = $x4');

  // Variáveis implícitas
  // - o tipo é definido pelo valor atribuído
  var y1 = 10;            // x1 é uma variável do tipo int
  var y2 = 3.14;          // x2 é uma variável do tipo double
  var y3 = true;          // x3 é uma variável do tipo bool
  var y4 = 'Olá, mundo!'; // x4 é uma variável do tipo String

  print('y1 = $y1 | y2 = $y2 | y3 = $y3 | y4 = $y4');

  // IMPORTANTE: Nos dois casos, o tipo não pode mudar depois
  //             Exemplo: int não vira String

  // ---------------------------------------------------------------------------
  // 2) Tipos básicos
  // ---------------------------------------------------------------------------
  // - int    → números inteiros
  // - double → números decimais
  // - String → textos
  // - bool   → valores lógicos (true/false)

  int inteiro = 42;
  double real = 3.1415;
  String texto = 'Programação Mobile 🦄';
  bool ehVisivel = true;

  print('inteiro   = $inteiro');
  print('real      = $real');
  print('texto     = $texto');
  print('ehVisivel = $ehVisivel');

  // ---------------------------------------------------------------------------
  // 3) final e const
  // ---------------------------------------------------------------------------

  // final: só pode receber um valor uma vez, mas esse valor pode vir em
  //        tempo de execução.
  //        Exemplo: DateTime.now() só é conhecido quando o programa roda.
  final agora = DateTime.now(); // valor em runtime

  // const: valor deve ser conhecido já no código, em tempo de compilação.
  //        Exemplo: pi = 3.14159.
  const pi = 3.14159; // valor fixo em compile-time

  print('agora (final): $agora');
  print('pi (const)...: $pi');

  // IMPORTANTE: final e const não podem mudar depois de atribuídos
  // agora = DateTime.now(); // ERRO!
  // pi    = 3.14;           // ERRO!

  // ---------------------------------------------------------------------------
  // 4) Interpolação de strings
  // ---------------------------------------------------------------------------
  // - Usar variáveis dentro de strings com $variavel ou ${expressao}.

  final cliente = 'João';
  final itens = 4;
  final valorUnitario = 12.5;
  final total = itens * valorUnitario;

  // No exemplo, calculamos o total e mostramos dentro da string.
  final recibo = 'Cliente: $cliente\nItens: $itens\nTotal: R\$ $total}';
  print(recibo);

  // ---------------------------------------------------------------------------
  // 5) ATIVIDADE
  // ---------------------------------------------------------------------------

  // 1) Crie um variáveis que representem um produto: nome, preco, quantidade
  //    e se está disponível no estoque.
  //
  //    Imprima uma frase interpolada apresentando esses dados.

}

