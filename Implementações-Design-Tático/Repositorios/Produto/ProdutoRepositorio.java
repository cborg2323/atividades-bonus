package Repositorios.Produto;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepositorio {
    List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max);
}
