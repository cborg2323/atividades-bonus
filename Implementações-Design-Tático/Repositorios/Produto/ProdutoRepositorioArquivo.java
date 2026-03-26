package Repositorios.Produto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoRepositorioArquivo implements ProdutoRepositorio {
    private final String caminhoArquivo;

    public ProdutoRepositorioArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        List<Produto> produtos = carregarProdutosDoArquivo();

        return produtos.stream()
                .filter(p -> p.getPreco() != null)
                .filter(p -> p.getPreco().compareTo(min) >= 0)
                .filter(p -> p.getPreco().compareTo(max) <= 0)
                .toList();
    }

    @SuppressWarnings("unchecked")
    private List<Produto> carregarProdutosDoArquivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<Produto>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao ler produtos do arquivo serializado", e);
        }
    }
}
