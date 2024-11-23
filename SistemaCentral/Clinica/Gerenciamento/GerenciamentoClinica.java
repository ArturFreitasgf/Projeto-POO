package Clinica.Gerenciamento;

import java.util.ArrayList;
import java.util.HashMap;import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Clinica.Class.Consulta;
import Clinica.Class.Medico;
import Clinica.Class.Paciente;

public class GerenciamentoClinica {
    private static ArrayList<Consulta> consultas = new ArrayList<>();

    public static ArrayList<Consulta> getConsultas() {
        return consultas;
    }    

    public static void listarConsultasPorMedico(String nomeMedico) {
        Medico medico = GerenciamentoMedico.buscarMedico(nomeMedico);

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.println("Consultas do médico " + medico.getNome() + ":");
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico)) {
                System.out.println(consulta);
            }
        }
    }

        public static void listarMedicosMaisSolicitados() {
        HashMap<Medico, Integer> contagemConsultas = new HashMap<>();
    
        for (Consulta consulta : consultas) {
            Medico medico = consulta.getMedico();
            contagemConsultas.put(medico, contagemConsultas.getOrDefault(medico, 0) + 1);
        }
    
        // Ordena os médicos pela quantidade de consultas
        List<Map.Entry<Medico, Integer>> listaOrdenada = new ArrayList<>(contagemConsultas.entrySet());
        listaOrdenada.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
    
        // Exibe os médicos mais solicitados
        System.out.println("Médicos mais solicitados:");
        for (Map.Entry<Medico, Integer> entry : listaOrdenada) {
            System.out.println(entry.getKey().getNome() + " - " + entry.getValue() + " consultas");
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
