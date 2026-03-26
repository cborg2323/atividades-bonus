package Agregados;

import java.util.UUID;

public class ContaBancariaAgregado {
    private final UUID identificadorConta;
    private double saldo;

    public ContaBancariaAgregado(double saldo) {
        if(saldo < 0) {
            throw new IllegalArgumentException("O saldo nunca pode ser negativo.");
        }
        this.identificadorConta = UUID.randomUUID();
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if(valor < 0) {
            throw new IllegalArgumentException("O valor a ser depositado deve ser positivo.");
        }
        this.saldo += saldo;
    }

    public void sacar(double valor) {
        if (valor > this.saldo) {
            throw new IllegalArgumentException("O valor a ser sacado é maior que o saldo em conta.");
        }
        this.saldo -= saldo;
    }
}
