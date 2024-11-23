package Utils.Interfaces;

import java.time.LocalDateTime;

public interface Agendavel {
    void agendar(LocalDateTime dataHora); // Método para agendar
    void cancelar();                      // Método para cancelar o agendamento
    boolean verificarDisponibilidade();  // Método para verificar disponibilidade
}
