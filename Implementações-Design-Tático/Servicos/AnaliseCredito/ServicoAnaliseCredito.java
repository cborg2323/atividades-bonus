package Servicos.AnaliseCredito;

public class ServicoAnaliseCredito {
    
    public boolean clienteAptoParaEmprestimo(Cliente cliente, double valorEmprestimo) {

        if(valorEmprestimo > cliente.historicoDeCompras() * 2) {
            return false;
        }

        if(cliente.possuiDividasAtivas()) {
            return false;
        }

        if(valorEmprestimo > cliente.salario() * 5) {
            return false;
        }

        return true;
    }

}
