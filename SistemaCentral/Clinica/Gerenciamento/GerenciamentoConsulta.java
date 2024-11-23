package Clinica.Gerenciamento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;

import Clinica.Class.Consulta;
import Clinica.Class.Paciente;
import Utils.Interfaces.IMedico;

public class GerenciamentoConsulta {
    private static ArrayList<Consulta> consultas = new ArrayList<>();

    public static ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public static void agendarConsulta(Scanner leitor) {
        System.out.println("\n----------Agendamento Consulta----------");
        System.out.print("Digite o nome do paciente: ");
        String nomePaciente = leitor.nextLine();
        Paciente paciente = GerenciamentoPaciente.buscarPaciente(nomePaciente);
    
        if (paciente == null) {
            System.out.print("Deseja cadastrar um novo? (S/N): ");
            String resposta = leitor.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                paciente = GerenciamentoPaciente.cadastrarPaciente(leitor);
            } else {
                return;
            }
        }
    
        System.out.println("\n----------Agendamento Consulta----------");
        System.out.print("Digite o nome do médico: ");
        String nomeMedico = leitor.nextLine();
        IMedico medico = GerenciamentoMedico.buscarMedico(nomeMedico);
    
        if (medico == null) {
            System.out.print("Médico não encontrado. Deseja cadastrar um novo? (S/N): ");
            String resposta = leitor.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                medico = GerenciamentoMedico.adicionarMedico(leitor);
            } else {
                System.out.println("Consulta não pode ser agendada sem um médico.");
                return;
            }
        } else if (!medico.isDisponivel()) {
            System.out.println("Médico não está disponível.");
            return;
        }
    
        System.out.println("\n----------Agendamento Consulta----------");
        System.out.print("Digite a data e hora da consulta (formato dd/MM/yyyy HH:mm): ");
        String dataHoraInput = leitor.nextLine();
        LocalDateTime dataHoraLocal;
    
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date dataHora = formato.parse(dataHoraInput);
    
            if (dataHora.before(new Date())) {
                System.out.println("A data e hora da consulta não podem ser no passado.");
                return;
            }
    
            dataHoraLocal = dataHora.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        } catch (ParseException e) {
            System.out.println("Formato de data e hora inválido.");
            return;
        }
    
        // Aqui adicionamos a consulta à lista centralizada
        Consulta consulta = new Consulta(dataHoraLocal, medico, paciente);
        GerenciamentoClinica.getConsultas().add(consulta);  // Alterado para adicionar à lista centralizada
    
        medico.setDisponivel(false); // Atualiza a disponibilidade do médico
        System.out.println("Consulta agendada com sucesso.");
    }

    public static void cancelarConsulta(Scanner leitor) {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }

        System.out.print("Consultas agendadas: ");
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            System.out.println(i + ". " + consulta);
        }

        System.out.print("Digite o índice da consulta a ser cancelada: ");
        int indiceConsulta = leitor.nextInt();
        leitor.nextLine(); // Consome o newline

        if (indiceConsulta >= 0 && indiceConsulta < consultas.size()) {
            Consulta consulta = consultas.get(indiceConsulta);
            consultas.remove(indiceConsulta);
            consulta.getMedico().setDisponivel(true); // Torna o médico disponível novamente
            System.out.println("Consulta cancelada com sucesso.");
        } else {
            System.out.println("Índice de consulta inválido.");
        }
    }

    public static void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }

        System.out.println("Consultas agendadas: ");
        for (Consulta consulta : consultas) {
            System.out.println(consulta);
        }
    }
}
