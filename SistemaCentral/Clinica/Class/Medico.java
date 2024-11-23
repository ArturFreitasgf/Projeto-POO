package Clinica.Class;

import Utils.Classes.Pessoa;
import Utils.Interfaces.IMedico;

public class Medico extends Pessoa implements IMedico {
    private String especialidade;
    private boolean disponivel;
    private String crm;

    public Medico(String nome, String email, String numeroCelular, String especialidade, boolean disponivel, String crm) {
        super(nome, email, numeroCelular);
        this.especialidade = especialidade;
        this.disponivel = disponivel;
        this.crm = crm;
    }

    @Override
    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Médico [Nome: " + getNome() + ", Especialidade: " + especialidade + ", CRM: " + crm + "]";
    }
}
