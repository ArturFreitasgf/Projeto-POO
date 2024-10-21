package Clinica.Class;

public class Consulta {
    private int id;
    private String paciente;
    private String medico;
    private String data;
    private String Motivo;

    public Consulta(int id, String paciente, String medico, String data, String descricao) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.Motivo = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String descricao) {
        this.Motivo = descricao;
    }
}