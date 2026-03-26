package Eventos.Hotel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 *   Considere ainda um agregado representativo da reserva,
 *   contendo uma funcionalidade para gerar a confirmação de
 *   reserva
 */

public class ReservaAgregado {

    private UUID reservaID;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double custoTotal;

    private final List<Object> eventos = new ArrayList<>();

    public void confirmaReserva(Cliente cliente) {
        // ...
        ReservaConfirmada evento = new ReservaConfirmada(
            this.reservaID,
            cliente.UUID(),
            this.entrada,
            this.saida,
            this.custoTotal
        );

        eventos.add(evento);
    }
    
}
