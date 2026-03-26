package Entidades;

public class LivroEntidade {
    private final String codigoISBN;
    private String titulo;
    private String autor;
    private int ano;

    public LivroEntidade(String codigoISBN, String titulo, String autor, int ano) {
        if (!codigoISBN.matches("\\d{11}")) {
            throw new IllegalArgumentException("Código ISBN deve conter exatamente 13 dígitos numéricos");
        }

        this.codigoISBN = codigoISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String citacaoABNT() {
        return this.autor + ". " + this.titulo + ". " + this.ano;
    }
    
}
