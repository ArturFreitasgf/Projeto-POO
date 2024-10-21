import java.util.Scanner;

import Clinica.ClinicaManager;
import Restaurante.RestaurantManager;
import SistemEvento.SistemaManager;

public class SistemaCentral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        limparTela();

        cabecalhhocentral();

        System.out.print("\n");
        System.out.println("////////////////////////////////////////////");
        System.out.println("1) - Sistema Clinica");
        System.out.println("2) - Sistema Restaurante");
        System.out.println("3) - Sistema Evento");
        System.out.println("4) - Análise");
        System.out.println("5) - Sair");
        System.out.println("///////////////////////////////////////////");
        System.out.print("\n");
        System.out.print("Selecione uma das opções: ");

        int sistema = scanner.nextInt();  

        switch (sistema) {
            case 1:
                ClinicaManager.main(new String[]{});  // Chama o método main da Clínica
                break;
            case 2:
                RestaurantManager.main(new String[]{});  // Chama o método main do Restaurante
                break;
            case 3:
                SistemaManager.main(new String[]{});  // Chama o método main do Evento
                break;
            case 4:
                System.out.println("1 - ");
                System.out.println("2 - ");
                System.out.println("3 - ");
                System.out.println("4 - Quais eventos têm maior taxa de participação de convidados?");
                System.out.println("5 - ");
                break;
            case 5:
            System.out.println("Encerrando o sistema...");
            break;
            
            default:
                System.out.println("Opção inválida.");
                break;
        }
        scanner.close();
    }

    private static void cabecalhhocentral() {
        System.out.println(" ______________________________________________");
        System.out.println("|  ____  __  ____  ____  ____  _  _   __       |");
        System.out.println("| / ___)(  )/ ___)(_  _)(  __)( \\/ ) / _\\      |");
        System.out.println("| \\___ \\ )( \\___ \\  )(   ) _) / \\/ \\/    \\     |");
        System.out.println("| (____/(__)(____/ (__) (____)\\_)(_\\/\\_/\\_/    |");
        System.out.println("|   ___  ____  __ _  ____  ____   __   __      |");
        System.out.println("|  / __)(  __)(  ( \\(_  _)(  _ \\ / _\\ (  )     |");
        System.out.println("| ( (__  ) _) /    /  )(   )   //    \\/ (_/\\   |");
        System.out.println("|  \\___)(____)\\_)__) (__) (__\\_)\\_/\\_/\\____/   |");
        System.out.println("|______________________________________________|");
    }
    
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