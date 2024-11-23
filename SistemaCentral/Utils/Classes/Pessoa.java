package Utils.Classes;

public class Pessoa {
    private String nome;
    private String email;
    private String numeroCelular;

    // Construtor original
    public Pessoa(String nome, String email, String numeroCelular) {
        this.nome = nome;
        this.email = email;
        this.numeroCelular = numeroCelular;
    }

    // Novo construtor sem parâmetros para apenas nome
    public Pessoa(String nome) {
        this.nome = nome;
        this.email = "Email não informado";  // Valor padrão
        this.numeroCelular = "Número não informado";  // Valor padrão
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
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Celular: " + numeroCelular);
    }
}
