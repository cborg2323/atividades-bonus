package OVs;
public record EmailObjetoDeValor(String valor) {

    private static final String REGEX = "^[A-Za-z0-9._]+@[A-Za-z0-9._]+$";

    public EmailObjetoDeValor {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("E-mail não pode ser nulo ou vazio.");
        }

        if (!valor.contains("@")) {
            throw new IllegalArgumentException("E-mail deve conter '@'.");
        }

        if (!valor.matches(REGEX)) {
            throw new IllegalArgumentException(
                "E-mail deve seguir o formato usuario@dominio e conter apenas letras, números, ponto e sublinhado."
            );
        }

        String[] partes = valor.split("@");
        if (partes.length != 2 || partes[0].isBlank() || partes[1].isBlank()) {
            throw new IllegalArgumentException("E-mail deve seguir o formato usuario@dominio.");
        }
    }
}