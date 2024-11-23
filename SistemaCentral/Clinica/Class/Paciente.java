package Clinica.Class;

import Utils.Classes.Pessoa;

public class Paciente extends Pessoa {
    private String cpf;

    // Construtor original com 4 parâmetros
    public Paciente(String nome, String email, String numeroCelular, String cpf) {
        super(nome, email, numeroCelular);
        this.cpf = cpf;
    }

    // Novo construtor com 3 parâmetros, com valor padrão para o email
    public Paciente(String nome, String cpf, String telefone) {
        super(nome, "nãoinformado@exemplo.com", telefone);  // Atribuindo um valor padrão para o email
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return getNumeroCelular(); // Usando o getter da classe mãe
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Paciente [Nome: " + getNome() + ", CPF: " + cpf + "]";
    }
}
