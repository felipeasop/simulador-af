# Simulador de Autômatos Finitos

Ferramenta em Java para simular **Autômatos Finitos Determinísticos (AFD)**, **Autômatos Finitos Não Determinísticos (AFND)** e **Autômatos Finitos com ε-transições (AFNDe)**. A ferramenta lê a definição do autômato a partir de um arquivo JSON, testa múltiplas cadeias de entrada e gera um relatório com o resultado de aceitação e o tempo de execução.

---

## Funcionalidades

- **Simulação de Autômatos Finitos**: Suporte para AFD, AFND e AFNDe.
- **Entrada de Dados**: Aceita um arquivo JSON com a definição do autômato e um arquivo CSV com as cadeias de entrada para teste.
- **Relatório de Saída**: Gera um relatório com os resultados da aceitação das cadeias, o tempo de execução de cada teste e comparação com o resultado esperado.

---

## Exemplo de Funcionamento

A ferramenta funciona a partir de **dois arquivos**:

1. **Especificação do autômato** (arquivo `arquivo_do_automato.aut` em JSON)
2. **Entradas para teste** (arquivo `arquivo_de_testes.in` em CSV com o delimitador `;`)

---

### 1. Especificação da Máquina de Estados

**Formato do arquivo JSON** para definir o autômato (`arquivo_do_automato.aut`):

```json
{
  "initial": 0,
  "final" : [4,7],
  "transitions": [
    {"from": 0, "read": "a", "to": 1},
    {"from": 0, "read": "a", "to": 3},
    {"from": 2, "read": "a", "to": 3},
    {"from": 3, "read": "b", "to": 2},
    {"from": 4, "read": "a", "to": 4},
    {"from": 7, "read": "c", "to": 1},
    {"from": 4, "read": null, "to": 0}
  ]
}
initial: Estado inicial.

final: Lista de estados finais.

transitions: Lista de objetos que definem as transições, com os campos:

from: Estado de origem.

read: Símbolo lido (pode ser null para transições ε).

to: Estado de destino.

2. Entradas para Teste
Formato do arquivo CSV para definir as cadeias a serem testadas (arquivo_de_testes.in):

csv
Copiar
Editar
palavra_de_entrada;resultadoEsperado
aababababbbababa;1
bbababa;0
ababa;1
cabab;0
Cada linha contém:

palavra_de_entrada: Cadeia a ser testada no autômato.

resultadoEsperado: Resultado esperado (1 para aceitação, 0 para rejeição).

Execução
Compilação
Para compilar o projeto, execute o comando:

bash
Copiar
Editar
mvn clean install
Execução do Simulador
Execute o simulador com o seguinte comando genérico:

bash
Copiar
Editar
java -cp "target/classes:PATH_TO_GSON_JAR" \
  com.mycompany.simuladoraf.SimuladorAF \
  arquivo_do_automato.aut arquivo_de_testes.in
Observação: Substitua PATH_TO_GSON_JAR pelo caminho para o JAR do Gson (por exemplo, ~/.m2/repository/com/google/code/gson/gson/2.8.8/gson-2.8.8.jar).

Ou, você pode executar via Maven:

bash
Copiar
Editar
mvn exec:java \
  -Dexec.mainClass="com.mycompany.simuladoraf.SimuladorAF" \
  -Dexec.args="arquivo_do_automato.aut arquivo_de_testes.in"
Saída
Após a execução, o programa gera o arquivo arquivo_de_testes_saida.out, que contém os resultados de cada cadeia de entrada testada.

Formato do arquivo de saída (arquivo_de_testes_saida.out):

csv
Copiar
Editar
palavra_de_entrada;resultadoEsperado;resultadoObtido;tempoEmSegundos
aababababbbababa;1;1;0.013
bbababa;0;0;0.005
ababa;1;1;0.002
cabab;0;0;0.004
palavra_de_entrada: Cadeia testada.

resultadoEsperado: O resultado esperado (1 ou 0).

resultadoObtido: O resultado retornado pela simulação (1 ou 0).

tempoEmSegundos: Tempo gasto para processar a cadeia de entrada.

Dependências
Gson: Biblioteca necessária para manipulação de JSON. Você pode baixar o JAR do Gson em https://mvnrepository.com/artifact/com.google.code.gson/gson.

Adicione a dependência do Gson no pom.xml:

xml
Copiar
Editar
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version>
</dependency>
