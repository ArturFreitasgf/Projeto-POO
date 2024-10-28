package SistemEvento.Classe;

public class Participante {
    private String nome;
    private String email;
    private String numerocelular;

    public Participante(String nome, String email, String numeroCelular) {
        this.nome = nome;
        this.email = email;
        this.numerocelular = numeroCelular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCelular() {
        return numerocelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numerocelular = numeroCelular;
    }
}
