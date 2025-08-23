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
// OPERADORES EM DART
// =============================================================================
// -----------------------------------------------------------------------------
// Autor...: Chauã Queirolo
// Data....: 22/08/2025
// -----------------------------------------------------------------------------

void main() {
  // ---------------------------------------------------------------------------
  // 1) Operadores Aritméticos
  // ---------------------------------------------------------------------------
  // - Usados em cálculos matemáticos.
  //    +   soma)
  //    -   subtração
  //    *   multiplicação
  //    /   divisão double
  //    ~/  divisão inteira
  //    %   resto da divisão

  int a = 12;
  int b = 5;

  print('a + b  = ${a + b}');
  print('a - b  = ${a - b}');
  print('a * b  = ${a * b}');
  print('a / b  = ${a / b}   // resultado double');
  print('a ~/ b = ${a ~/ b}  // divisão inteira');
  print('a % b  = ${a % b}   // resto da divisão');

  // ---------------------------------------------------------------------------
  // 2) Operadores Relacionais
  // ---------------------------------------------------------------------------
  // Comparam valores e retornam true/false
  //    ==  igual
  //    !=  diferente
  //    >   maior
  //    >=  maior ou igual
  //    <   menor
  //    <=  menor ou igual

  print('a == b -> ${a == b}');
  print('a != b -> ${a != b}');
  print('a >  b -> ${a > b}');
  print('a >= b -> ${a >= b}');
  print('a <  b -> ${a < b}');
  print('a <= b -> ${a <= b}');

  // ---------------------------------------------------------------------------
  // 3) Operadores Lógicos
  // ---------------------------------------------------------------------------
  // Usados em expressões booleanas
  //    &&  E
  //    ||  OU
  //    !   negação

  bool cond1 = a > 10;   // true
  bool cond2 = b.isOdd;  // true (5 é ímpar)

  print('cond1 && cond2 -> ${cond1 && cond2}');
  print('cond1 || cond2 -> ${cond1 || cond2}');
  print('!cond1         -> ${!cond1}');

  // ---------------------------------------------------------------------------
  // 4) Operadores de Atribuição Composta
  // ---------------------------------------------------------------------------
  // Permitem atualizar valores mais facilmente
  //    +=, -=, *=, /=, ~/=, %=

  int x = 10;
  double y = 4;

  x += 5;   // x = 15
  x -= 3;   // x = 12
  x *= 2;   // x = 24
  y /= 2;   // y = 2.0
  x ~/= 5;  // x = 4
  x %= 3;   // x = 1

  print('x = $x | y = $y');

  // ---------------------------------------------------------------------------
  // 5) Incremento e Decremento
  // ---------------------------------------------------------------------------
  // - ++i (pré-incremento), i++ (pós-incremento)
  // - --i (pré-decremento), i-- (pós-decremento)

  int i = 0;
  print('i   : $i');     // 0
  print('i++ : ${i++}'); // usa 0, depois vira 1
  print('++i : ${++i}'); // vira 2, depois usa
  print('--i : ${--i}'); // vira 1
  print('i-- : ${i--}'); // usa 1, depois vira 0
  print('i   : $i');     // 0

  // ---------------------------------------------------------------------------
  // ATIVIDADE
  // ---------------------------------------------------------------------------
  // 1) Crie duas variáveis inteiras (a, b).
  //    Imprima:
  //    - soma e produto
  //    - se a é múltiplo de b
  //    - se ambos são pares
  //
  // 2) Crie duas variáveis booleanas.
  //    Teste todas as combinações possíveis com os operadores lógicos.
}
