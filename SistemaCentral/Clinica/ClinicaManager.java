package Clinica;

import java.util.Scanner;
import Clinica.Class.*;

import Utils.*;

public class ClinicaManager {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Cabecalhos.cabecalhoClinica();

        menu(leitor);
    }

    public static void menu(Scanner leitor) {
        int opcao = 0;
        do {
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Cancelar Consulta");
            System.out.println("3. Buscar Consulta");
            System.out.println("4. Buscar Paciente");
            System.out.println("5. Sair");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Consome o newline

            switch (opcao) {
                case 1:
                    GerenciamentoClinica.agendarConsulta(leitor);
                    break;
                case 2:
                    GerenciamentoClinica.cancelarConsulta(leitor);
                    break;
                case 3:
                    GerenciamentoClinica.buscarConsulta(leitor);
                    break;
                case 4:
                    GerenciamentoClinica.buscarPaciente(leitor);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }
}
