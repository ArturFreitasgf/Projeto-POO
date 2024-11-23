package Utils.Classes;

import Utils.Interfaces.Agendavel;
import java.time.LocalDateTime;

public abstract class AgendamentoBase implements Agendavel {
    private LocalDateTime dataHora;
    private boolean agendado;

    public AgendamentoBase(LocalDateTime dataHora) {
        this.dataHora = dataHora;
        this.agendado = true; // Por padrão, ao criar, considera-se agendado.
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isAgendado() {
        return agendado;
    }

    @Override
    public void cancelar() {
        if (agendado) {
            agendado = false;
            System.out.println("Agendamento cancelado com sucesso.");
        } else {
            System.out.println("Este agendamento já foi cancelado.");
        }
    }
}
