package Clinica.Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GerenciamentoClinica {
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static ArrayList<Medico> medicos = new ArrayList<>();
    private static ArrayList<Consulta> consultas = new ArrayList<>();

    public static void agendarConsulta(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nomePaciente = leitor.nextLine();
        Paciente paciente = GerenciamentoPaciente.buscarPaciente(nomePaciente);
    
        if (paciente == null) {
            System.out.println("Paciente não encontrado. Deseja cadastrar um novo? (S/N)");
            String resposta = leitor.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                GerenciamentoPaciente.cadastrarPaciente(leitor);
                paciente = GerenciamentoPaciente.buscarPaciente(nomePaciente);
            } else {
                return;
            }
        }
    
        System.out.println("Digite o nome do médico:");
        String nomeMedico = leitor.nextLine();
        Medico medico = GerenciamentoMedico.buscarMedico(nomeMedico);
    
        if (medico == null) {
            System.out.println("Médico não encontrado. Deseja cadastrar um novo? (S/N)");
            String resposta = leitor.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                GerenciamentoMedico.adicionarMedico(leitor);
                medico = GerenciamentoMedico.buscarMedico(nomeMedico);
            } else {
                System.out.println("Consulta não pode ser agendada sem um médico.");
                return;
            }
        } else if (!medico.isDisponivel()) {
            System.out.println("Médico não disponível.");
            return;
        }
    
        System.out.println("Digite a data e hora da consulta (formato dd/MM/yyyy HH:mm):");
        String dataHoraInput = leitor.nextLine();
        Date dataHora;
    
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            dataHora = formato.parse(dataHoraInput);
        } catch (ParseException e) {
            System.out.println("Formato de data e hora inválido.");
            return;
        }
    
        Consulta consulta = new Consulta(paciente, medico, dataHora);
        consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso.");
    }
    

    public static void cancelarConsulta(Scanner leitor) {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
    
        System.out.println("Consultas agendadas:");
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            System.out.println(i + ". Paciente: " + consulta.getPaciente().getNome() +
                               ", Médico: " + consulta.getMedico().getNome() +
                               ", Data/Hora: " + consulta.getDataHora());
        }
    
        System.out.println("Digite o índice da consulta a ser cancelada:");
        int indiceConsulta = leitor.nextInt();
        leitor.nextLine(); // Consome o newline
    
        if (indiceConsulta >= 0 && indiceConsulta < consultas.size()) {
            consultas.remove(indiceConsulta);
            System.out.println("Consulta cancelada com sucesso.");
        } else {
            System.out.println("Índice de consulta inválido.");
        }
    }
    

    public static void buscarConsulta(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nomePaciente = leitor.nextLine();

        boolean encontrado = false;
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getNome().equalsIgnoreCase(nomePaciente)) {
                System.out.println("Consulta com Dr. " + consulta.getMedico().getNome() +
                                   " em " + consulta.getDataHora());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhuma consulta encontrada para este paciente.");
        }
    }
}
