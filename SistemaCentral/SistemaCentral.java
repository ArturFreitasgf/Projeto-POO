import java.util.Scanner;

import Restaurante.RestaurantManager;
import SistemEvento.SistemaManager;
import Clinica.ClinicaManager;

import Utils.*;

public class SistemaCentral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LimparTela.limparTela();

        int sistema;
        do{
            LimparTela.limparTela();
            
            Cabecalhos.cabecalhocentral();

            System.out.println("////////////////////////////////////////////");
            System.out.println("1 - Sistema Clinica");
            System.out.println("2 - Sistema Restaurante");
            System.out.println("3 - Sistema Evento");
            System.out.println("4 - Sair");
            System.out.println("///////////////////////////////////////////");
            System.out.print("\n");
            System.out.print("Selecione uma das opções: ");

            sistema = scanner.nextInt();
            switch (sistema) {
                case 1:
                    ClinicaManager.main(new String[]{});
                    break;
                case 2:
                    RestaurantManager.main(new String[]{});
                    break;
                case 3:
                    SistemaManager.main(new String[]{});
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while(sistema != 4);
        scanner.close();
    }
}
