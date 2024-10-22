package Clinica;

import java.util.Scanner;
import Clinica.Class.*;
import Utils.Cabecalhos;
import Utils.LimparTela;

public class ClinicaManager {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        menu(leitor);
    }

    public static void menu(Scanner leitor) {
        int opcao = 0;

        LimparTela.limparTela();
        do {
            Cabecalhos.cabecalhoClinica();
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Cancelar Consulta");
            System.out.println("3. Buscar Consulta");
            System.out.println("4. Buscar Paciente");
            System.out.println("5. Buscar médico");
            System.out.println("6. Sair");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Consome o newline

            switch (opcao) {
                case 1:
                    GerenciamentoConsulta.agendarConsulta(leitor);
                    break;
                case 2:
                    GerenciamentoConsulta.cancelarConsulta(leitor);
                    break;
                case 3:
                    System.out.println("Digite o nome do médico para buscar suas consultas:");
                    String nomeMedico = leitor.nextLine();
                    GerenciamentoConsulta.listarConsultasPorMedico(nomeMedico);
                    break;
                case 4:
                    System.out.println("Digite o nome do paciente:");
                    String nomePaciente = leitor.nextLine();
                    GerenciamentoPaciente.buscarPaciente(nomePaciente);
                    break;
                case 5:
                    System.out.println("Digite o nome do médico:");
                    nomeMedico = leitor.nextLine();
                    GerenciamentoMedico.buscarMedico(nomeMedico);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }
}
