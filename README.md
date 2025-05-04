# Simulador de Autômatos Finitos

Este projeto implementa um simulador de autômatos finitos (AFD, AFND e AFNDe) em Java, usando o [Gson](https://github.com/google/gson) para carregar a definição do autômato a partir de um JSON e executar testes de cadeias de entrada.

---

## 📋 Funcionalidades

- **Leitura de autômato** em JSON com campos:
  - `initial`: estado inicial (inteiro)  
  - `final`  : conjunto de estados finais (lista de inteiros)  
  - `transitions`: lista de transições, cada qual com `from`, `read`, `to`  
- **Detecção automática** do tipo de autômato:
  - **AFD**  — determinístico  
  - **AFND** — não‑determinístico  
  - **AFNDe**— não‑determinístico com ε‑transições  
- **Execução de testes**:
  - Lê um arquivo `.in` onde cada linha é `palavra;esperado`  
  - Para cada linha, imprime no console e escreve em arquivo `_saida.out`:  
    ```
    palavra;esperado;obtido;tempo(s)
    ```

---

## 🚀 Pré‑requisitos

1. **Java JDK 11+**  
   - Baixe em https://adoptium.net ou https://jdk.java.net  
   - Instale e configure `JAVA_HOME` apontando para a pasta do JDK  
   - Adicione `%JAVA_HOME%\bin` ao `PATH`

2. **Apache Maven 3.6+**  
   - Baixe em https://maven.apache.org/download.cgi  
   - Descompacte, configure `MAVEN_HOME` e adicione `%MAVEN_HOME%\bin` ao `PATH`  
   - Teste com:
     ```bash
     mvn -v
     ```

3. **Git** (opcional, para clonar o repositório)  
   - Baixe em https://git-scm.com  
   - Teste com:
     ```bash
     git --version
     ```

---

## ⚙️ Instalação

1. **Clone o repositório**  
   ```bash
   git clone https://github.com/felipeasop/simulador-af.git
   cd simulador-af
Verifique a dependência do Gson no pom.xml

xml
Copiar
Editar
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.8</version>
</dependency>
🔨 Build
No diretório raiz do projeto (onde está o pom.xml), execute:

bash
Copiar
Editar
mvn clean install
clean: remove builds anteriores

install: compila, testa (se houver) e baixa dependências

Se tudo ocorrer bem, suas classes compiladas ficarão em target/classes.

▶️ Uso
1. Preparar arquivos de entrada
Arquivo de autômato (.aut) ex. ex1.aut:

json
Copiar
Editar
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
Arquivo de testes (.in) ex. ex1_input.in:

Copiar
Editar
aababababbbababa;1
bbababa;0
ababa;1
cabab;0
2. Executar via Maven
bash
Copiar
Editar
mvn exec:java \
  -Dexec.mainClass="com.mycompany.simuladoraf.SimuladorAF" \
  -Dexec.args="ex1.aut ex1_input.in"
3. Ou executar diretamente com java
No Windows, incluindo o JAR do Gson:

bat
Copiar
Editar
java -cp "target/classes;C:\Users\Felipe\.m2\repository\com\google\code\gson\gson\2.8.8\gson-2.8.8.jar" ^
  com.mycompany.simuladoraf.SimuladorAF ex1.aut ex1_input.in
Ajuste o caminho do JAR conforme sua instalação.

4. Saída
Console: cada linha no formato

scss
Copiar
Editar
palavra;esperado;obtido;tempo(s)
Arquivo: ex1_input_saida.out gerado ao lado de ex1_input.in com as mesmas linhas
