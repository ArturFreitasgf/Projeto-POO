package Clinica.Class;

public class Medico {
    private String nome;
    private String especialidade;
    private boolean disponivel;

    public Medico(String nome, String especialidade, boolean disponivel) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponivel = disponivel;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
