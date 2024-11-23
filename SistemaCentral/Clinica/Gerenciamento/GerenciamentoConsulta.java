package Clinica.Gerenciamento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import Clinica.Class.Consulta;
import Clinica.Class.Medico;
import Clinica.Class.Paciente;
import Clinica.Metodos.CadastroPaciente;

public class GerenciamentoConsulta {
    private static ArrayList<Consulta> consultas = new ArrayList<>();

    public static ArrayList<Consulta> getConsultas() {
        return consultas;
    }    

    public static void agendarConsulta(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nomePaciente = leitor.nextLine();
        Paciente paciente = GerenciamentoPaciente.buscarPaciente(nomePaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado. Deseja cadastrar um novo? (S/N)");
            String resposta = leitor.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                paciente = CadastroPaciente.cadastrarPaciente(leitor);
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
                medico = GerenciamentoMedico.adicionarMedico(leitor);
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
            if (dataHora.before(new Date())) {
                System.out.println("A data e hora da consulta não podem ser no passado.");
                return;
            }
        } catch (ParseException e) {
            System.out.println("Formato de data e hora inválido.");
            return;
        }

        // Conversão de Date para LocalDateTime
        LocalDateTime dataHoraLocal = dataHora.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();

        Consulta consulta = new Consulta(dataHoraLocal, medico, paciente);
        consultas.add(consulta);
        medico.setDisponivel(false); // Atualiza a disponibilidade do médico
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
            Consulta consulta = consultas.get(indiceConsulta);
            consultas.remove(indiceConsulta);
            consulta.getMedico().setDisponivel(true); // Torna o médico disponível novamente
            System.out.println("Consulta cancelada com sucesso.");
        } else {
            System.out.println("Índice de consulta inválido.");
        }
    }
}