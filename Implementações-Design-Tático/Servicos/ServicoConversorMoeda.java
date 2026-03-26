package Servicos;

public class ServicoConversorMoeda {
    
    public double converterMoeda(Double valorOriginal, double taxaDaMoedaDestino) {
        return valorOriginal * taxaDaMoedaDestino;
    }

}
