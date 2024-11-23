package Utils.Interfaces;

public interface IMedico {
    String getEspecialidade();
    boolean isDisponivel();
    void setDisponivel(boolean disponivel);
    String getCrm();
    String getNome();
}
