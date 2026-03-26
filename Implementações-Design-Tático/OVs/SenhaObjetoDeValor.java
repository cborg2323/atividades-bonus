package OVs;
public final class SenhaObjetoDeValor {
    private final int hashSenha;

    public SenhaObjetoDeValor (String senha) {
        if (senha == null) {
            throw new IllegalArgumentException("Senha não pode ser nula.");
        }

        if (senha.length() < 8) {
            throw new IllegalArgumentException("Senha deve ter no mínimo 8 caracteres.");
        }
        
        hashSenha = senha.hashCode();
    }

    public boolean matches(String senhaPlana) {
        return this.hashSenha == senhaPlana.hashCode();
    }
}
