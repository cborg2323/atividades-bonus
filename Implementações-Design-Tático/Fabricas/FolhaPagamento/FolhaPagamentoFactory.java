package Fabricas.FolhaPagamento;

public class FolhaPagamentoFactory {
    
    public FolhaPagamento criar(Funcionario funcionario, double horasTrabalhadas) {
        double salarioBase = funcionario.getSalarioBase();
        double horasExtras = calcularHorasExtras(funcionario, horasTrabalhadas);
        double bruto = calcularBruto(salarioBase, horasTrabalhadas, horasExtras);
        double impostos = calcularImpostos(funcionario, bruto);
        double liquido = bruto - impostos;

        return new FolhaPagamento(funcionario, horasTrabalhadas, bruto, impostos, liquido);
    }

    private double calcularHorasExtras(Funcionario funcionario, double horasTrabalhadas) {
        // regra de negócio
        return 0.0;
    }

    private double calcularBruto(double salarioBase, double horasTrabalhadas, double horasExtras) {
        // regra de negócio
        return salarioBase + horasExtras;
    }

    private double calcularImpostos(Funcionario funcionario, double bruto) {
        // regra de negócio
        return bruto * 0.10;
    }

}
