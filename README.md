# Simulador de Autômatos Finitos

Simulador em Java para autômatos do tipo AFD, AFND e AFNDe, com entrada em formato JSON e testes de palavras em `.in`. A saída informa se a palavra foi aceita e o tempo de execução.

---

## Funcionalidades (resumo por classe)

* **`Transicao`**
  Representa uma transição: origem, símbolo lido e destino.

* **`Automato`**
  Armazena os estados e transições, e identifica se o autômato é AFD, AFND ou AFNDe.

* **`Executar`**
  Implementa a lógica de simulação para cada tipo de autômato.

* **`Leitor`**
  Lê um arquivo `.aut` em JSON e constrói o objeto `Automato`.

* **`SimuladorAF`**
  Coordena a execução: lê os arquivos, identifica o tipo de autômato, executa os testes e gera a saída.

---

## Requisitos

* Java JDK 11 ou superior
* Maven 3.6 ou superior
* Biblioteca `gson` (já incluída no `pom.xml` se usar Maven)

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
  "final": [1, 3],
  "transitions": [
    {"from": 0, "read": "a", "to": 1},
    {"from": 1, "read": null, "to": 3}
  ]
}
```

### Arquivo `.in` (teste de palavras)

```text
a;1
b;0
ab;1
```

### Saída `.out`

Gerado automaticamente com uma linha por teste:

```text
palavra;esperado;obtido;tempo(s)
```

Exemplo:

```text
a;1;1;0.002
b;0;0;0.001
ab;1;0;0.003
```

---
