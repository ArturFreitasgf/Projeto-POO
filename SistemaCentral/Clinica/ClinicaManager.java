package Clinica;

import java.util.Scanner;
import Clinica.Gerenciamento.*;
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
            System.out.print("\n");
            System.out.println("////////////////////////////////////////////");
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Cancelar Consulta");
            System.out.println("3. Buscar Consulta");
            System.out.println("4. Buscar Paciente");
            System.out.println("5. Buscar médico");
            System.out.println("6. Listar médicos mais solicitados");
            System.out.println("7. Listar pacientes com mais consultas");
            System.out.println("8. Tornar Médico Disponível");
            System.out.println("9. Listar Especialidades Mais Demandadas");
            System.out.println("10. Sair");
            System.out.println("////////////////////////////////////////////");
            System.out.print("\n");
            System.out.print("Selecione uma das opções: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Consome o newline
    
            switch (opcao) {
                case 1:
                    LimparTela.limparTela();
                    GerenciamentoConsulta.agendarConsulta(leitor);
                    break;
                case 2:
                    LimparTela.limparTela();
                    GerenciamentoConsulta.cancelarConsulta(leitor);
                    break;
                case 3:
                    LimparTela.limparTela();
                    System.out.println("\n----------Buscar Consulta----------");
                    System.out.print("Digite o nome do médico para buscar suas consultas: ");
                    String nomeMedico = leitor.nextLine();
                    GerenciamentoClinica.listarConsultasPorMedico(nomeMedico);  // Chama o método que agora imprime as consultas
                    break;
                case 4:
                    LimparTela.limparTela();
                    System.out.println("\n----------Buscar Paciente----------");
                    System.out.print("Digite o nome do paciente: ");
                    String nomePaciente = leitor.nextLine();
                    GerenciamentoPaciente.buscarPaciente(nomePaciente);  
                    GerenciamentoPaciente.listarConsultasDoPaciente(nomePaciente);
                    break;
                
                case 5:
                    LimparTela.limparTela();
                    System.out.println("\n----------Buscar Médico----------");
                    System.out.print("Digite o nome do médico: ");
                    nomeMedico = leitor.nextLine();
                    GerenciamentoMedico.buscarMedico(nomeMedico);
                    break;
                case 6:
                    GerenciamentoClinica.listarMedicosMaisSolicitados();
                    break;
                case 7:
                    GerenciamentoClinica.listarPacientesMaisConsultas();
                    break;
                case 8:
                    LimparTela.limparTela();
                    System.out.println("\n----------Tornar Disponivel----------");
                    System.out.print("Digite o nome do médico para torná-lo disponível: ");
                    nomeMedico = leitor.nextLine();
                    GerenciamentoMedico.tornarDisponivel(nomeMedico);
                    break;
                case 9:
                    GerenciamentoClinica.listarEspecialidadesMaisDemandadas();
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 10);
    }
}
