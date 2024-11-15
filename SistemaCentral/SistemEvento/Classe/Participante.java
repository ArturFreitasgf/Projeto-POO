package SistemEvento.Classe;

import Estrutura.Clases.Pessoa;

public class Participante extends Pessoa {
    private String email;
    private String numeroCelular;

    public Participante(String nome, String email, String numeroCelular) {
        super(nome); 
        this.email = email;
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}
