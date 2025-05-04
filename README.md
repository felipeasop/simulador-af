# Simulador de Autômatos Finitos

Simulador em Java para autômatos finitos, são aceitos AFD, AFND e AFNDe, com entrada em formato JSON e testes de palavras em `.in`. A saída informa se a palavra foi aceita e o tempo de execução.

---

## Funcionalidade das classes:

* **`Transicao`**
  Representa uma transição, contém origem, símbolo lido e próximo símbolo.

* **`Automato`**
  Armazena os estados e transições, e identifica se o autômato é AFD, AFND ou AFNDe.

* **`Executar`**
  Implementa a lógica de simulação para cada tipo de autômato.

* **`Leitor`**
  Lê um arquivo de entrada com os dados do autômato `.aut` em Json utilizando Gson, inicializando o autômato.

* **`SimuladorAF`**
  Contém a classe principal, recebe os inputs, realiza a chamada para outras classes, executa os testes e gera a saída.

---

## Requisitos

* Java JDK
* Maven
* Biblioteca `gson` (já está incluída no `pom.xml`)

---

## Compilação

```bash
mvn clean install
```

---

## Execução

### Opção 1: Usando Maven

```bash
mvn exec:java \
  -Dexec.mainClass="com.mycompany.simuladoraf.SimuladorAF" \
  -Dexec.args="exemplo.aut exemplo.in"
```

### Opção 2: Linha de comando Java manual

```bash
java -cp "target/classes;[caminhos/jars/gson-e-outros]" \
     com.mycompany.simuladoraf.SimuladorAF \
     exemplo.aut exemplo.in
```

Substitua `[caminhos/jars/gson-e-outros]` pelos caminhos corretos das bibliotecas necessárias (como gson).

---

## Formato dos Arquivos

### Arquivo `.aut` (JSON)

```json
{
  "initial": 0,
  "final" : [4,7],
  "transitions": [
    {"from": 0, "read": "a", "to": 1 },
    {"from": 0, "read": "a", "to": 3 },
    {"from": 2, "read": "a", "to": 3 },
    {"from": 3, "read": "b", "to": 2 },
    {"from": 4, "read": "a", "to": 4 },
    {"from": 7, "read": "c", "to": 1 },
    {"from": 4, "read": null, "to": 0 }
  ]
}
```

### Arquivo `.in` (teste de palavras)

```text
aababababbbababa;1
aababababbbababa;1
aababababbbababa;1
aababababbbababa;1
```

### Saída `.out`

Gerado automaticamente com uma linha por teste:

```text
palavra;esperado;obtido;tempo(s)
```

Exemplo:

```text
aababababbbababa;1;1007
aababababbbababa;1;1;0.;0.013
aababababbbababa;1;1;0.023
aababababbbababa;1;1;0.150
```

---
