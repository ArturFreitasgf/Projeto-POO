package Clinica.Class;

import java.util.Date;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private Date dataHora;

    public Consulta(Paciente paciente, Medico medico, Date dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
