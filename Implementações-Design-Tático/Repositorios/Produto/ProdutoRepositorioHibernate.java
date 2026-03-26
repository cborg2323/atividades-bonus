package Repositorios.Produto;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProdutoRepositorioHibernate implements ProdutoRepositorio {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Produto> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        
        return em
            .createNamedQuery("Produto.buscarPorFaixaDePreco", Produto.class)
            .setParameter("min", min)
            .setParameter("max", max)
            .getResultList();
    }
    
}
