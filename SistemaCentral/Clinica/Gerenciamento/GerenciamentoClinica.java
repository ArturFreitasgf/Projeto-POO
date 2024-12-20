package Clinica.Gerenciamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Clinica.Class.Consulta;
import Clinica.Class.Paciente;
import Utils.Interfaces.IMedico;

public class GerenciamentoClinica {
    private static ArrayList<Consulta> consultas = new ArrayList<>();

    public static ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public static void listarConsultasPorMedico(String nomeMedico) {
        IMedico medico = GerenciamentoMedico.buscarMedico(nomeMedico);
    
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }
    
        // Verifica se a lista de consultas não está vazia
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
    
        System.out.println("Consultas do médico " + medico.getNome() + ":");
    
        boolean encontrouConsulta = false;
        // Percorre as consultas para encontrar as que pertencem ao médico especificado
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().getCrm().equalsIgnoreCase(medico.getCrm())) {
                System.out.println(consulta);
                encontrouConsulta = true;
            }
        }
    
        // Caso o médico não tenha consultas agendadas
        if (!encontrouConsulta) {
            System.out.println("Não há consultas agendadas para este médico.");
        }
    }

    public static void listarMedicosMaisSolicitados() {
        HashMap<IMedico, Integer> contagemConsultas = new HashMap<>();
    
        for (Consulta consulta : consultas) {
            IMedico medico = consulta.getMedico();
            contagemConsultas.put(medico, contagemConsultas.getOrDefault(medico, 0) + 1);
        }
    
        // Ordena os médicos pela quantidade de consultas
        List<Map.Entry<IMedico, Integer>> listaOrdenada = new ArrayList<>(contagemConsultas.entrySet());
        listaOrdenada.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
    
        // Exibe os médicos mais solicitados
        System.out.println("Médicos mais solicitados:");
        for (Map.Entry<IMedico, Integer> entry : listaOrdenada) {
            System.out.println(entry.getKey().getNome() + " - " + entry.getValue() + " consultas");
        }
    }

    public static void buscarConsulta(Scanner leitor) {
        System.out.println("Digite o nome do paciente: ");
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

    public static void listarPacientesMaisConsultas() {
        HashMap<Paciente, Integer> contagemConsultas = new HashMap<>();

        for (Consulta consulta : consultas) {
            Paciente paciente = consulta.getPaciente();
            contagemConsultas.put(paciente, contagemConsultas.getOrDefault(paciente, 0) + 1);
        }

        // Ordena os pacientes pela quantidade de consultas
        List<Map.Entry<Paciente, Integer>> listaOrdenada = new ArrayList<>(contagemConsultas.entrySet());
        listaOrdenada.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Exibe os pacientes com mais consultas
        System.out.println("Pacientes com mais consultas:");
        for (Map.Entry<Paciente, Integer> entry : listaOrdenada) {
            System.out.println(entry.getKey().getNome() + " - " + entry.getValue() + " consultas");
        }
    }

    public static void listarEspecialidadesMaisDemandadas() {
        HashMap<String, Integer> contagemEspecialidades = new HashMap<>();

        for (Consulta consulta : consultas) {
            String especialidade = consulta.getMedico().getEspecialidade();
            contagemEspecialidades.put(especialidade, contagemEspecialidades.getOrDefault(especialidade, 0) + 1);
        }

        // Ordena as especialidades pela quantidade de consultas
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(contagemEspecialidades.entrySet());
        listaOrdenada.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Exibe as especialidades mais demandadas
        System.out.println("Especialidades médicas mais demandadas:");
        for (Map.Entry<String, Integer> entry : listaOrdenada) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " consultas");
        }
    }
}
