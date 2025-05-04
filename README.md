# Simulador de Autômatos Finitos

Este projeto implementa um simulador de autômatos finitos (AFD, AFND e AFNDe) em Java, usando a biblioteca [Gson](https://github.com/google/gson) para carregar a definição do autômato a partir de um JSON e executar testes com cadeias de entrada.

---

## Funcionalidades

- Leitura de autômato em JSON com os campos:
  - `initial`: estado inicial (inteiro)
  - `final`: conjunto de estados finais (lista de inteiros)
  - `transitions`: lista de transições com `from`, `read`, `to`
- Detecção automática do tipo de autômato:
  - AFD — determinístico  
  - AFND — não determinístico  
  - AFNDe — não determinístico com transições ε
- Execução de testes:
  - Lê um arquivo `.in` onde cada linha é `palavra;esperado`  
  - Gera saída no console e em arquivo `.out` no formato:

```text
palavra;esperado;obtido;tempo(s)
```

---

## Requisitos

- Java JDK 11 ou superior  
- Apache Maven 3.6 ou superior  
- Git (opcional, para clonar o repositório)

Verifique as instalações com:

```bash
java -version
mvn -v
git --version
```

---

## Instalação

Clone o repositório:

```bash
git clone https://github.com/usuario/simulador-af.git
cd simulador-af
```

O `pom.xml` já inclui a dependência do Gson:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.8</version>
</dependency>
```

Para compilar:

```bash
mvn clean install
```

---

## Uso

### 1. Arquivos de entrada

**Autômato (.aut):**

```json
{
  "initial": 0,
  "final": [4,7],
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
```

**Testes (.in):**

```text
aababababbbababa;1
bbababa;0
ababa;1
cabab;0
```

---

### 2. Executar com Maven

```bash
mvn exec:java \
  -Dexec.mainClass="com.mycompany.simuladoraf.SimuladorAF" \
  -Dexec.args="ex1.aut ex1_input.in"
```

---

### 3. Executar diretamente com Java

```bat
java -cp "target/classes;C:\Users\SeuUsuario\.m2\repository\com\google\code\gson\gson\2.8.8\gson-2.8.8.jar" ^
  com.mycompany.simuladoraf.SimuladorAF ex1.aut ex1_input.in
```

Ajuste o caminho do JAR conforme necessário.

---

### 4. Saída

Console e arquivo `.out` com as linhas:

```text
palavra;esperado;obtido;tempo(s)
```
