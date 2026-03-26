package Repositorios.ContaBancaria;

import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ContaBancariaRepositorioHibernate implements ContaBancariaRepositorio {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ContaBancaria> buscarContasSaldoNegativo() {
        return em.createQuery(
            "SELECT c FROM ContaBancaria c WHERE c.saldo < 0", ContaBancaria.class
        ).setParameter("saldo", 0.0)
        .getResultList();
    }
    
}
