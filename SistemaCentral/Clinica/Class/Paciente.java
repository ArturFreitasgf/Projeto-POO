package Clinica.Class;

import Utils.Classes.Pessoa;

public class Paciente extends Pessoa {
    private String cpf;

    public Paciente(String nome, String email, String numeroCelular, String cpf) {
        super(nome, email, numeroCelular);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Paciente [Nome: " + getNome() + ", CPF: " + cpf + "]";
    }
}
