package SistemEvento.Classe;

import Utils.Classes.Pessoa;

public class Participante extends Pessoa {
    private String tipoIngresso;

    // Construtor com 4 parâmetros (já existente)
    public Participante(String nome, String email, String numeroCelular, String tipoIngresso) {
        super(nome, email, numeroCelular);
        this.tipoIngresso = tipoIngresso;
    }

    // Construtor com 3 parâmetros, definindo um tipo de ingresso padrão
    public Participante(String nome, String email, String numeroCelular) {
        super(nome, email, numeroCelular);
        this.tipoIngresso = "Não especificado"; // Ou outro valor padrão
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo de Ingresso: " + tipoIngresso);
    }
}
