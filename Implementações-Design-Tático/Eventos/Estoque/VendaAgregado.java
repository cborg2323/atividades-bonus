package Eventos.Estoque;

import java.util.ArrayList;
import java.util.List;

public class VendaAgregado {
    private final List<Object> eventos = new ArrayList<>();
    
    public void concluirVenda(Produto produto, Estoque estoque) {
        // ...
        estoque.atualizarEstoqueProduto(produto.UUID());

        if(estoque.estoqueDoProduto(produto.UUID()) < estoque.quantidadeMinimaProduto(produto.UUID())) {
            EstoqueAbaixoDoMinimo evento = new EstoqueAbaixoDoMinimo(
                produto.UUID(),
                estoque.estoqueDoProduto(produto.UUID()),
                estoque.quantidadeMinimaProduto(produto.UUID())
            );

            eventos.add(evento);
        }
    }

}
