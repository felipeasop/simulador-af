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
