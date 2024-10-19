package SistemEvento.Classe;

public class Local {
    private String endereco;
    private String cidade;
    private String tipoLocal;

    public Local(String endereco, String cidade, String tipoLocal){
        this.endereco = endereco;
        this.cidade = cidade;
        this.tipoLocal = tipoLocal;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }
}
