package Clinica.Class;

import Estrutura.Clases.Pessoa;

public class Paciente extends Pessoa{
    private String cpf;
    private String telefone;

    public Paciente(String nome, String cpf, String telefone) {
        super(nome);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
