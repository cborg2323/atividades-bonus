package Entidades;

import java.util.UUID;

public class ReservaHotelEntidade {
    private final UUID identidade;
    private String status;

    public ReservaHotelEntidade() {
        this.identidade = UUID.randomUUID();
        this.status = "CRIADA";
    }

    public void fazerCheckIn() {
        if(!"CRIADA".equals(this.status)) {
            throw new IllegalStateException("Check-in só pode ser realizado para reservas com status CRIADA.");
        }
        this.status = "CHECKIN";
    }

    public void cancelarReserva() {
        if("CHECKIN".equals(this.status)) {
            throw new IllegalStateException("Reserva não pode ser cancelada após check-in.");
        }
        if("CANCELADA".equals(this.status)) {
            throw new IllegalStateException("Reserva já está cancelada.");
        }

        this.status = "CANCELADA";
    }

}
