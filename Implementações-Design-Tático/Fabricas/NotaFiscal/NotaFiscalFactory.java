package Fabricas.NotaFiscal;

import java.util.List;

public class NotaFiscalFactory {

    public NotaFiscal criar(List<Item> itens) {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("A nota fiscal deve conter itens.");
        }

        double subtotal = calcularSubtotal(itens);
        double impostos = calcularImpostos(subtotal);
        double total = subtotal + impostos;

        return new NotaFiscal(itens, subtotal, impostos, total);
    }

    private double calcularSubtotal(List<Item> itens) {
        return itens.stream()
                .mapToDouble(Item::valorTotal)
                .sum();
    }

    private double calcularImpostos(double subtotal) {
        return subtotal * 0.12;
    }

}
