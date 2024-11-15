package Clinica.Class;

import Estrutura.Clases.Pessoa;

public class Medico extends Pessoa {
    private String especialidade;
    private boolean disponivel;
    private String crm;

    public Medico(String nome, String especialidade, boolean disponivel, String crm) {
        super(nome);
        this.especialidade = especialidade;
        this.disponivel = disponivel;
        this.crm = crm;
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
