package SistemEvento;
public class Local {
    private String endereco;
    private String cidade;
    private String tipoLocal;

    public Local(String endereco, String cidade, String tipoLocal){
        this.endereco = endereco;
        this.cidade = cidade;
        this.tipoLocal = tipoLocal;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getCidade(){
        return cidade;
    }

    public String getTipoLocal(){
        return tipoLocal;
    }
}
