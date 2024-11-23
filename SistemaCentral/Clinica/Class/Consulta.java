package Clinica.Class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Utils.Classes.AgendamentoBase;
import Utils.Interfaces.IMedico;

public class Consulta extends AgendamentoBase {
    private IMedico medico;  // Alterado para usar IMedico
    private Paciente paciente;

    public Consulta(LocalDateTime dataHora, IMedico medico, Paciente paciente) {
        super(dataHora);  // Chamando o construtor da classe base
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
        return medico.isDisponivel();  // Verifica se o médico está disponível.
    }

    @Override
    public void agendar(LocalDateTime dataHora) {
        setDataHora(dataHora);  // Atribui a dataHora utilizando o método da classe base
        System.out.println("Consulta agendada para " + dataHora);
    }

    @Override
    public String toString() {
        // Usando DateTimeFormatter para formatar LocalDateTime
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Consulta [Paciente: " + paciente.getNome() + 
               ", Médico: " + medico.getNome() + 
               ", Data/Hora: " + getDataHora().format(formatoData) + "]";
    }
}
