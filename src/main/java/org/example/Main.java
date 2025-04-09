package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GerenciadorMemoria gm = new GerenciadorMemoria(15);

        // Testes de alocação
        int b1 = gm.alocar(3); // Esperado: posição 0
        int b2 = gm.alocar(4); // Esperado: posição 3
        int b3 = gm.alocar(5); // Esperado: posição 7
        int b4 = gm.alocar(6); // Esperado: falha

        gm.imprimirEstado();

        // Liberação de um bloco
        gm.liberar(b2); // Libera bloco de tamanho 4 na posição 3

        // Tentar alocar 6 novamente
        b4 = gm.alocar(6); // Pode continuar falhando se não houver espaço contínuo

        gm.imprimirEstado();

        // Tentar alocar um bloco menor
        int b5 = gm.alocar(2); // Deve conseguir

        gm.imprimirEstado();
    }
}
