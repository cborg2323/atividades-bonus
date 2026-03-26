package Eventos.Hotel;
/* 
     identificação da reserva, do cliente, datas de
    entrada e saída, custo total;
*/

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservaConfirmada (
    UUID reservaId,
    UUID clienteId,
    LocalDateTime entrada,
    LocalDateTime saida,
    double custoTotal
) { }