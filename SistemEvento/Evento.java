package SistemEvento;
public class Evento {
    private String nomeevento;
    private int diaevento;
    private int mesevento;
    private int anoevento;
    private int capacidade;
    private Local local;
    private int totalparticipantes;
    private Participante[] participantes;

    public Evento(String nomeevento, int diaevento, int mesevento, int anoevento, int capacidade, Local local) {
        this.nomeevento = nomeevento;
        this.diaevento = diaevento;
        this.mesevento = mesevento;
        this.anoevento = anoevento;
        this.capacidade = capacidade;
        this.local = local;
        this.totalparticipantes = 0;
        this.participantes = new Participante[capacidade];
    }

    public String getNomeevento() {
        return nomeevento;
    }

    public void setNomeevento(String nomeevento) {
        this.nomeevento = nomeevento;
    }

    public int getDiaevento() {
        return diaevento;
    }

    public void setDiaevento(int diaevento) {
        this.diaevento = diaevento;
    }

    public int getMesevento() {
        return mesevento;
    }

    public void setMesevento(int mesevento) {
        this.mesevento = mesevento;
    }

    public int getAnoevento() {
        return anoevento;
    }

    public void setAnoevento(int anoevento) {
        this.anoevento = anoevento;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int getTotalparticipantes() {
        return totalparticipantes;
    }

    public void setTotalparticipantes(int totalparticipantes) {
        this.totalparticipantes = totalparticipantes;
    }

    public Participante[] getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Participante[] participantes) {
        this.participantes = participantes;
    }

    public boolean adicionarParticipante(Participante participante){
        if (totalparticipantes < capacidade) {
            participantes[totalparticipantes] = participante;
            totalparticipantes++;
            return true;
        } else {
            return false;
        }
    }

    public void gerarRelatorio(){
        System.out.println("Evento: " + nomeevento);
        System.out.println("Data: " + diaevento + "/" + mesevento + "/" + anoevento);
        System.out.println("Local: " + local.getEndereco());
        System.out.println("Capacidade Máxima: " + capacidade);
        System.out.println("Total de Participantes: " + totalparticipantes);
        System.out.println("\n------------Lista de Participantes-------------");
        for (int i = 0; i < totalparticipantes; i++) {
            Participante p = participantes[i];
            System.out.println("Nome: " + p.getNome() + ", Email: " + p.getEmail() + ", Celular: " + p.getNumerocelular());
        }
    }

    public boolean estaLotado(){
        return totalparticipantes >= capacidade;
    }
}