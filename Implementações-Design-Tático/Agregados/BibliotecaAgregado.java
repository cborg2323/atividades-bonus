package Agregados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BibliotecaAgregado {
    private final UUID idEmprestimo;
    private Cliente cliente;
    private List<Livro> listaDeLivros;
    private String status;

    public BibliotecaAgregado(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalStateException("Cliente nao informado");
        }

        this.idEmprestimo = UUID.randomUUID();
        this.listaDeLivros = new ArrayList<>();
        this.status = "CRIADO";
        this.cliente = cliente;
    }

    public void adicionarLivro(String isbn, String titulo, String autor, int ano) {

        if (listaDeLivros.size() >= 3) {
            throw new IllegalStateException("Limite de 3 livros por emprestimo");
        }

        if (buscarLivro(isbn) != null) {
            throw new IllegalArgumentException("Livro ja adicionado ao emprestimo");
        }

        listaDeLivros.add(new Livro(isbn, titulo, autor, ano));
    }

    public void finalizarEmprestimo() {

        if (listaDeLivros.isEmpty()) {
            throw new IllegalStateException("Nao é possivel finalizar sem livros");
        }

        if (!"CRIADO".equals(this.status)) {
            throw new IllegalStateException("Não é possível finalizar com status diferente de 'CRIADO'.");
        }

        this.status = "REALIZADO";
    }

    public void devolverLivros() {
        
        if (!"REALIZADO".equals(this.status)) {
            throw new IllegalStateException("Não é possível devolver os livros de um empréstimo com status diferente de 'REALIZADO'.");
        }

        this.status = "DEVOLVIDO";
    }

    private Livro buscarLivro(String isbn) {
        for (Livro livro : listaDeLivros) {
            if (livro.isbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    private final record ISBN(String numero) {
        public ISBN {
            if (numero == null) {
                throw new IllegalArgumentException("ISBN não pode ser nulo");
            }
            if (!numero.matches("\\d{13}")) {
                throw new IllegalArgumentException("ISBN deve conter exatamente 13 dígitos numéricos");
            }
        }
    }

    private class Livro {
        private final ISBN isbn;
        private final String titulo;
        private final String autor;
        private final int ano;

        public Livro(String isbn, String titulo, String autor, int ano) {
            this.isbn = new ISBN(isbn);
            this.titulo = titulo;
            this.autor = autor;
            this.ano = ano;
        }

        public String isbn() {
            return isbn.numero();
        }
    }

    private class Cliente {
        private final UUID idCliente;
        private final String nome;

        public Cliente(String nome) {
            this.idCliente = UUID.randomUUID();
            this.nome = nome;
        }
    }
}
