package SistemaEvento;
public class Participante{
    private String nome;
    private String email;
    private String numerocelular;

    public Participante(String nome, String email, String numeroCelular){
        this.nome = nome;
        this.email = email;
        this.numerocelular = numeroCelular;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String getNumeroCelular(){
        return numerocelular;
    }
}
