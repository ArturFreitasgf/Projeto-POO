package Clinica.Class;

public class Medico {
    private String nome;
    private String especialidade;
    private boolean disponivel;
    private String crm;

    public Medico(String nome, String especialidade, boolean disponivel, String crm) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponivel = disponivel;
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
