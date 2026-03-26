package Servicos.EmprestimoBiblioteca;

/*
    implemente: um ServicoEmprestimo que utiliza Livro, Usuario e Emprestimo para
    efetuar a operação emprestarLivro.

    • Um livro só pode ser emprestado se estiver disponível.
    • O usuário deve estar em situação regular para realizar um empréstimo.
    • A data de devolução depende do tipo de usuário.
    • Exceções devem ser lançadas para tentativas de empréstimo com usuário
      irregular ou livro indisponível.
*/

public class ServicoEmprestimo {
    
    public void emprestarLivro(Livro livro, Usuario usuario, Emprestimo emprestimo) {
        
        if(!livro.livroEstaDisponivel()) {
            throw new IllegalStateException("O livro não está disponível");
        }

        if(!usuario.usuarioEstaRegular()) {
            throw new IllegalStateException("O usuário não está regularizado.");
        }

        if(usuario.tipoUsuario() == "N") {
            emprestimo.definirDataDevolucao("N");
        } else if(usuario.tipoUsuario() == "S") {
            emprestimo.definirDataDevolucao("S");
        }

        emprestimo.definirUsuario(usuario.idUsuario());
        emprestimo.adicionarLivro(livro.idLivro());

    }

}
