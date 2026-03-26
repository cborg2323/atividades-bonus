package OVs;
/*
    1. Implemente um CPF como Value Object, considerando a estrutura clássica de classes Java:
    • Garantir que os atributos não sejam alterados após a criação do objeto;
    • Garantir que haja exatamente 11 digitos.
    
    2. Refaça o exemplo usando o recurso de "record".
*/

public final class CPFObjetoDeValor {
    private final String numero;

    public CPFObjetoDeValor(String n) {
        if (n == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo");
        }

        if(!n.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos");
        }

        this.numero = n;
    }
    
    public String getNumero() {
        return numero;
    }
}

record CPFRecord(String numero) {
    public CPFRecord{
        if (numero == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo");
        }
        if (!numero.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos");
        }
    }
}