package org.example;

class BlocoMemoria {
    int inicio;
    int tamanho;
    BlocoMemoria proximo;

    BlocoMemoria(int inicio, int tamanho) {
        this.inicio = inicio;
        this.tamanho = tamanho;
        this.proximo = null;
    }
}