# 🧠 Gerenciador de Memória em Java — Best Fit com Lista Encadeada

Este projeto implementa um **gerenciador de memória** em Java, utilizando **lista encadeada** para controlar os blocos livres e aplicando o algoritmo de alocação **Best Fit**.

## 🎯 Objetivo

Simular um sistema de gerenciamento de memória semelhante ao descrito no livro **"Sistemas Operacionais Modernos"** de **Tanenbaum**, Seção **3.2.3**, Capítulo 3. A aplicação busca:

- 📌 Utilizar uma **lista encadeada** para manter os blocos livres de memória.
- 📌 Implementar o algoritmo **Best Fit**, escolhendo o menor bloco adequado para alocação.
- 📌 Permitir **alocação** e **liberação de memória**.
- 📌 Realizar **compactação automática** após a liberação de blocos.
- 📌 Incluir testes práticos de alocação.

## 🧪 Exemplo de Uso

Suponha que a memória tenha tamanho total de 15 unidades.

Operações:

- Alocar blocos de tamanho: `3`, `4`, `5`, `6`.
- Verificar o estado da memória.
- Desalocar algum bloco (ex: tamanho `4`).
- Tentar novamente alocar o bloco de tamanho `6`, que antes não cabia.

## 📁 Estrutura dos Arquivos

- `BlocoMemoria.java` – Representa cada bloco de memória livre.
- `GerenciadorMemoria.java` – Contém a lógica de alocação, liberação e compactação.
- `Main.java` – Contém o `main()` com testes.

## ▶️ Como Executar com Maven

```bash
# Compilar o projeto
mvn compile

# Executar o programa principal
mvn exec:java -Dexec.mainClass="Main"
