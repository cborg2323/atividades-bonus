package Agregados;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
    1. Implemente um agregado para o contexto de um sistema de reserva de passagens,
    considerando elementos como Reserva, Voo, Passageiro.
    2. Garanta que a reserva de um passageiro só pode ser confirmada se o voo não estiver lotado.
*/

public class ReservaPassagensAgregado {
    private final UUID idReserva;
    private Voo voo;
    private List<Passageiro> listaDePassageiros;

    private class Voo {
        private final UUID identificadorDeVoo;
        private final String origemEDestino;
        private final String dataEHorarioPartida;
        private final int capacidadeMax;


        public Voo(String origemEDestino, String dataEHorarioPartida, int capacidadeMax) {
            this.identificadorDeVoo = UUID.randomUUID();
            this.origemEDestino = origemEDestino;
            this.dataEHorarioPartida = dataEHorarioPartida;
            this.capacidadeMax = capacidadeMax;
        }
    }

    private class Passageiro {
        private final String CPF;
        private final String nome;

        public Passageiro(String CPF, String nome) {
            this.CPF = CPF;
            this.nome = nome;
        }
    }

    public ReservaPassagensAgregado() {
        this.idReserva = UUID.randomUUID();
        this.voo = new Voo(
            "Uberlândia-São Paulo",
            "16abr-16:00",
            100
        );
        this.listaDePassageiros = new ArrayList<>();
    }

    public String obterInformacaoDoVoo(UUID idReserva) {
        if(this.idReserva != idReserva) {
            throw new IllegalArgumentException("Id de reserva incorreto!");
        }
        return this.voo.origemEDestino + "\n" + this.voo.dataEHorarioPartida;
    }

    public void reservaPassagem(Passageiro passageiro) {
        if(this.voo.capacidadeMax >= this.listaDePassageiros.size()) {
            throw new IllegalStateException("O vôo está lotado.");
        }
        this.listaDePassageiros.add(passageiro);
    }
    
}
