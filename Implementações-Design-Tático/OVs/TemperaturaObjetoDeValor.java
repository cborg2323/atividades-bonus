package OVs;
public record TemperaturaObjetoDeValor(double celsius) {

    public TemperaturaObjetoDeValor {
        if (celsius < -273.15) {
            throw new IllegalArgumentException(
                "Temperatura inválida: não pode ser menor que -273.15°C."
            );
        }
    }

    public double toFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }
}