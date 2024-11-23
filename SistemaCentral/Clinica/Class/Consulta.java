package Clinica.Class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Utils.Classes.AgendamentoBase;
import Utils.Interfaces.IMedico;

public class Consulta extends AgendamentoBase {
    private IMedico medico;
    private Paciente paciente;

    public Consulta(LocalDateTime dataHora, IMedico medico, Paciente paciente) {
        super(dataHora);
        this.medico = medico;
        this.paciente = paciente;
    }

    public IMedico getMedico() {
        return medico;
    }

    public void setMedico(IMedico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean verificarDisponibilidade() {
        return medico.isDisponivel();
    }

    @Override
    public void agendar(LocalDateTime dataHora) {
        setDataHora(dataHora);
        System.out.println("Consulta agendada para " + dataHora);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Consulta [Paciente: " + paciente.getNome() +
               ", Médico: " + medico.getNome() +
               ", Data/Hora: " + getDataHora().format(formatoData) + "]";
    }
}
