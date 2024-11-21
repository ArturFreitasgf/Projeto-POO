package SistemEvento.Classe;

import Utils.Classes.Pessoa;

public class Participante extends Pessoa {
    private String tipoIngresso; // Por exemplo, VIP ou Comum

    public Participante(String nome, String email, String numeroCelular, String tipoIngresso) {
        super(nome, email, numeroCelular);
        this.tipoIngresso = tipoIngresso;
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
