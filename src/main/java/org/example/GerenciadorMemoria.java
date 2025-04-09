package org.example;
import java.util.*;

public class GerenciadorMemoria {
    private BlocoMemoria livre;
    private Map<Integer, Integer> alocados;
    private int tamanhoTotal;

    public GerenciadorMemoria(int tamanho) {
        this.tamanhoTotal = tamanho;
        this.livre = new BlocoMemoria(0, tamanho);
        this.alocados = new HashMap<>();
    }

    public int alocar(int tamanho) {
        BlocoMemoria atual = livre, melhor = null, anterior = null, melhorAnterior = null;

        while (atual != null) {
            if (atual.tamanho >= tamanho) {
                if (melhor == null || atual.tamanho < melhor.tamanho) {
                    melhor = atual;
                    melhorAnterior = anterior;
                }
            }
            anterior = atual;
            atual = atual.proximo;
        }

        if (melhor == null) {
            System.out.println("❌ Falha na alocação: bloco de tamanho " + tamanho + " não encontrado.");
            return -1;
        }

        int endereco = melhor.inicio;
        alocados.put(endereco, tamanho);

        if (melhor.tamanho == tamanho) {
            if (melhorAnterior == null) {
                livre = melhor.proximo;
            } else {
                melhorAnterior.proximo = melhor.proximo;
            }
        } else {
            melhor.inicio += tamanho;
            melhor.tamanho -= tamanho;
        }

        System.out.println("✅ Alocado bloco de tamanho " + tamanho + " na posição " + endereco);
        return endereco;
    }

    public void liberar(int endereco) {
        Integer tamanho = alocados.remove(endereco);
        if (tamanho == null) {
            System.out.println("❌ Endereço inválido para liberação: " + endereco);
            return;
        }

        BlocoMemoria novo = new BlocoMemoria(endereco, tamanho);
        if (livre == null || endereco < livre.inicio) {
            novo.proximo = livre;
            livre = novo;
        } else {
            BlocoMemoria atual = livre;
            while (atual.proximo != null && atual.proximo.inicio < endereco) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }

        System.out.println("🔄 Liberado bloco na posição " + endereco + " de tamanho " + tamanho);
        compactar();
    }

    private void compactar() {
        if (livre == null) return;

        BlocoMemoria atual = livre;
        while (atual.proximo != null) {
            if (atual.inicio + atual.tamanho == atual.proximo.inicio) {
                atual.tamanho += atual.proximo.tamanho;
                atual.proximo = atual.proximo.proximo;
            } else {
                atual = atual.proximo;
            }
        }
    }

    public void imprimirEstado() {
        System.out.println("\n----------------------------------------------");
        System.out.println("Estado atual da memória:");
        System.out.println("Blocos alocados:");
        for (var e : alocados.entrySet()) {
            System.out.println("  Início: " + e.getKey() + ", Tamanho: " + e.getValue());
        }

        System.out.println("Blocos livres:");
        BlocoMemoria atual = livre;
        while (atual != null) {
            System.out.println("  Início: " + atual.inicio + ", Tamanho: " + atual.tamanho);
            atual = atual.proximo;
        }
        System.out.println();
    }
}