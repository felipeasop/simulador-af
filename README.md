# Simulador de Autômatos Finitos

Simulador em Java para autômatos finitos. São aceitos **AFD**, **AFND** e **AFNDe**, com entrada em formato JSON e testes de palavras em arquivos `.in`. A saída informa se a palavra foi aceita e o tempo de execução.

---

## Funcionalidade das Classes

- **`Transicao`**
  Representa uma transição. Contém informações sobre a origem, o símbolo lido e o próximo estado.

- **`Automato`**
  Armazena os estados e transições do autômato, e identifica se ele é **AFD**, **AFND** ou **AFNDe**.

- **`Executar`**
  Implementa a lógica de simulação para cada tipo de autômato, verificando se a palavra é aceita ou rejeitada.

- **`Leitor`**
  Lê um arquivo de entrada com os dados do autômato no formato JSON, utilizando a biblioteca **Gson**, e inicializa o autômato.

- **`SimuladorAF`**
  Contém a classe principal. Recebe os inputs, faz a chamada para outras classes, executa os testes e gera a saída.

---

## Rodando o Simulador

### Requisitos

- **Java JDK**
- **Maven**
- Biblioteca **Gson** (já incluída no `pom.xml`)

---

### Instalação

Clone o repositório com o seguinte comando:

```bash
git clone https://github.com/felipeasop/simulador-af.git
cd simulador-af
```

---

### Compilação

Compile o projeto com Maven para gerar o JAR com as dependências:

```bash
mvn clean install
```

---

### Execução

A execução é feita por meio de um Uber-JAR (JAR com todas as dependências inclusas). Para rodar o simulador, siga as etapas abaixo:

1. **Prepare os arquivos de entrada:**
   Encontre a pasta que contém o arquivo `shaded.jar` gerado pelo Maven e coloque no mesmo diretório os arquivos de entrada:

   - Um arquivo `.aut` com a definição do autômato no formato JSON (ex: `entrada.aut`).
   - Um arquivo `.in` com as palavras de teste e os resultados esperados (ex: `testes.in`).

2. **Navegue até o diretório do JAR:**

   ```bash
   cd target
   ```

3. **Execute o simulador:**

   ```bash
   java -jar exemplo-shaded.jar exemplo.aut exemplo.in
   ```

   A saída será exibida no console e gravada em um arquivo `.out`, conforme a implementação do programa.

---;

## Formato dos Arquivos

### Arquivo `.aut` (JSON)

```json
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
```

### Arquivo `.in` (CSV)

```text
aababababbbababa;1
aababababbbababa;1
aababababbbababa;1
aababababbbababa;1
```

### Saída `.out` (CSV)

Gerado automaticamente com uma linha por teste:

```text
palavra;esperado;obtido;tempo(s)
```

Exemplo de resultado:

```text
aababababbbababa;1;1;0.007
aababababbbababa;1;1;0.013
aababababbbababa;1;1;0.023
aababababbbababa;1;1;0.150
```

---
