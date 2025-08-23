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
// ESTRUTURAS DE CONTROLE: DECISÃO E REPETIÇÃO
// =============================================================================
// -----------------------------------------------------------------------------
// Autor...: Chauã Queirolo
// Data....: 22/08/2025
// -----------------------------------------------------------------------------

void main() {
  // ---------------------------------------------------------------------------
  // 1) Estrutura condicional if / else if / else
  // ---------------------------------------------------------------------------
  // - if executa um bloco se a condição for verdadeira.
  // - else if testa outra condição caso a primeira falhe.
  // - else é o "plano B", executado se nenhum caso anterior for atendido.

  double nota = 7.3;

  if (nota >= 7) {
    print('Aprovado');
  } else if (nota >= 5) {
    print('Recuperação');
  } else {
    print('Reprovado');
  }

  // ---------------------------------------------------------------------------
  // 2) Operador ternário
  // ---------------------------------------------------------------------------
  // - Operador ternário é um "if compacto".
  // - Sintaxe: condição ? valor_se_verdadeiro : valor_se_falso.

  String situacao = (nota >= 7) ? 'OK' : 'ATENÇÃO';

  print('Situação: $situacao');

  // ---------------------------------------------------------------------------
  // 3) switch / case
  // ---------------------------------------------------------------------------
  // - switch escolhe o bloco a executar de acordo com o valor da variável.
  // - cada case representa um valor.
  // - break evita que continue executando os próximos cases.
  // - default é o "plano B" (opcional).

  int dia = 6; // 1=segunda, 7=domingo

  switch (dia) {
    case 1:
      print('Segunda-feira');
      break;
    case 2:
      print('Terça-feira');
      break;
    case 3:
      print('Quarta-feira');
      break;
    case 4:
      print('Quinta-feira');
      break;
    case 5:
      print('Sexta-feira');
      break;
    case 6:
    case 7:
      print('Final de semana');
      break;
    default:
      print('Dia inválido');
  }

  // ---------------------------------------------------------------------------
  // 4) Laço for (clássico)
  // ---------------------------------------------------------------------------
  // - for é usado quando sabemos quantas vezes queremos repetir.
  // - sintaxe: for(inicialização; condição; incremento).

  int soma = 0;

  for (int i = 1; i <= 5; i++) {
    soma += i;
  }

  print('Soma de 1 a 5 = $soma');

  // ---------------------------------------------------------------------------
  // 5) Laço while
  // ---------------------------------------------------------------------------
  // - while executa enquanto a condição for verdadeira.
  // - se a condição for falsa logo de início, não executa nenhuma vez.

  int cont = 3;

  while (cont > 0) {
    print('while -> $cont');
    cont--;
  }

  // ---------------------------------------------------------------------------
  // 6) Laço do-while
  // ---------------------------------------------------------------------------
  // - do-while garante que o bloco será executado pelo menos uma vez.
  // - depois da execução, a condição é verificada.

  int n = 0;

  do {
    print('do-while -> $n');
    n++;
  } while (n < 2);


  // ---------------------------------------------------------------------------
  // 8) break e continue
  // ---------------------------------------------------------------------------
  // - continue → pula apenas a iteração atual e volta para o teste de condição.
  //              no caso de for, executa o incremento antes de voltar.
  // - break    → encerra o loop por completo.

  for (int k = 1; k <= 5; k++) {
    if (k == 2) continue; // pula o 2
    if (k == 4) break;    // interrompe no 4
    print('k = $k');
  }

  // ---------------------------------------------------------------------------
  // ATIVIDADES
  // ---------------------------------------------------------------------------
  // 1) Pegue um número inteiro e diga se é par, ímpar ou zero.
  //
  // 2) Usando switch, imprima o mês do ano a partir de um número (1..12).
  //
  // 3) Usando switch, dado um mês do ano a partir de um número (1..12), imprima
  //    a estação do ano (verão, outono, inverno, primavera).
  //
  // 4) Use um laço for para somar os números de 1 a 100 e mostre o resultado.

}
