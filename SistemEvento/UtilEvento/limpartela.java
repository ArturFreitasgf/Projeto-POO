package SistemEvento.UtilEvento;

public class limpartela {
    public static void limparTela() {
        String sistema = System.getProperty("os.name").toLowerCase(); // Obtém o nome do sistema operacional

        try {
            if (sistema.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Para Windows
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor(); // Para Linux ou Mac
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar a tela: " + e.getMessage());
        }
    }  
}
