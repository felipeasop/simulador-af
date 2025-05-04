# 🚩 Objetivo da Ferramenta

Este projeto tem como objetivo simular autômatos finitos (AFD, AFND e AFNDε) a partir de arquivos fornecidos pelo usuário. A ferramenta é implementada em Java e funciona totalmente via linha de comando.

Ela recebe dois arquivos principais: um arquivo `.aut` contendo a descrição do autômato no formato JSON e um arquivo `.in` com palavras de teste e os resultados esperados. Após o processamento, ela gera um arquivo de saída com os resultados das simulações e o tempo de execução de cada uma.

---

## ⚙️ Como Funciona

A execução da ferramenta ocorre em três etapas principais:

1. **Leitura do autômato**: O arquivo `.aut` é um JSON que define o estado inicial, os estados finais e uma lista de transições. Cada transição é um objeto com três campos: `from`, `read`, e `to`.

2. **Leitura das entradas de teste**: O arquivo `.in` é um CSV em que cada linha contém uma palavra de entrada e o resultado esperado (1 para aceitação, 0 para rejeição).

3. **Simulação e geração da saída**: Para cada palavra, a ferramenta simula o comportamento do autômato, determina se ela é aceita ou rejeitada, mede o tempo de execução e salva o resultado em um arquivo `.out`.

---

## 📥 Formato dos Arquivos

### Arquivo `.aut`

Este arquivo contém a definição do autômato no formato JSON. Um exemplo de conteúdo seria:

{
  "initial": 0,
  "final": [4, 7],
  "transitions": [
    { "from": 0, "read": "a", "to": 1 },
    { "from": 0, "read": "a", "to": 3 },
    { "from": 2, "read": "a", "to": 3 },
    { "from": 3, "read": "b", "to": 2 },
    { "from": 4, "read": "a", "to": 4 },
    { "from": 7, "read": "c", "to": 1 },
    { "from": 4, "read": null, "to": 0 }
  ]
}
O campo read pode ser null, indicando uma transição ε (vazia). Isso caracteriza um AFNDε.

Arquivo .in
Este arquivo deve conter as palavras a serem testadas, seguidas pelo valor esperado (1 ou 0), separados por ponto e vírgula:

Copiar
Editar
aababababbbababa;1
ababa;1
babab;0
📤 Saída
A ferramenta gera um novo arquivo de saída com o mesmo nome do arquivo de entrada, acrescido de _saida.out. Cada linha contém a palavra testada, o resultado esperado, o resultado obtido (1 ou 0) e o tempo de execução em segundos, separados por ponto e vírgula.

Exemplo de saída:

Copiar
Editar
aababababbbababa;1;1;0.013
ababa;1;1;0.004
babab;0;0;0.006
🧠 Detecção do Tipo de Autômato
A ferramenta identifica automaticamente o tipo do autômato a partir das transições:

Se houver alguma transição com leitura nula (read = null), o autômato é um AFNDε.

Se houver múltiplas transições para o mesmo estado e símbolo, é um AFND.

Caso contrário, é um AFD.

🚀 Como Executar
Requisitos
Java 11 ou superior

Maven

Compilação
Abra o terminal na raiz do projeto e execute:

mvn clean install
Execução
Você pode executar a ferramenta com o seguinte comando:

bash
Copiar
Editar
mvn exec:java -Dexec.mainClass="com.mycompany.simuladoraf.SimuladorAF" -Dexec.args="automato.aut entrada.in"
Certifique-se de substituir os nomes dos arquivos pelos caminhos corretos dos seus arquivos .aut e .in.

📁 Organização do Projeto
O código-fonte da ferramenta está dentro da pasta src/main/java/com/mycompany/simuladoraf, contendo as classes responsáveis pela leitura dos arquivos, detecção do tipo de autômato e simulação.

📚 Exemplo Completo
Suponha que você tenha o arquivo exemplo.aut com a seguinte definição:

{
  "initial": 0,
  "final": [2],
  "transitions": [
    { "from": 0, "read": "a", "to": 1 },
    { "from": 1, "read": "b", "to": 2 }
  ]
}

E o arquivo exemplo.in com:
ab;1
a;0
abc;0

Ao executar a ferramenta com: mvn exec:java -Dexec.mainClass="com.mycompany.simuladoraf.SimuladorAF" -Dexec.args="exemplo.aut exemplo.in"
Será gerado o arquivo exemplo_saida.out com algo como:

ab;1;1;0.001
a;0;0;0.002
abc;0;0;0.001
