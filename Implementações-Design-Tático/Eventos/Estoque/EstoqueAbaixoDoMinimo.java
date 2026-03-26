package Eventos.Estoque;

import java.util.UUID;

public record EstoqueAbaixoDoMinimo (
    UUID produtoId,
    int quantidadeAtual,
    int quantidadeMinima
) { }
