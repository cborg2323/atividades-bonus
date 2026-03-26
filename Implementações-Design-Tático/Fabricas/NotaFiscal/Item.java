package Fabricas.NotaFiscal;

public class Item {
    private double preco;
    private int quantidade;

    public double valorTotal() {
        return preco * quantidade;
    }
}
