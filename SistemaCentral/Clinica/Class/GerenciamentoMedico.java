package Clinica.Class;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoMedico {
    private static ArrayList<Medico> medicos = new ArrayList<>();

    public static Medico adicionarMedico(Scanner leitor) {
        System.out.println("Digite o nome do médico:");
        String nome = leitor.nextLine();
        System.out.println("Digite a especialidade do médico:");
        String especialidade = leitor.nextLine();
        System.out.println("Digite o CRM do médico:");
        String crm = leitor.nextLine();
        System.out.println("O médico está disponível? (S/N)");
        boolean disponivel = leitor.nextLine().equalsIgnoreCase("S");

        Medico novoMedico = new Medico(nome, especialidade, disponivel, crm);
        medicos.add(novoMedico);
        System.out.println("Médico adicionado com sucesso.");

        return novoMedico;
    }

    public static Medico buscarMedico(String nome) {
        return medicos.stream()
                .filter(medico -> medico.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Médico não encontrado.");
                    return null;
                });
    }

    public static Medico buscarMedicoPorCrm(String crm) {
        return medicos.stream()
                .filter(medico -> medico.getCrm().equalsIgnoreCase(crm))
                .findFirst()
                .orElse(null);
    }

    public static void tornarDisponivel(String nomeMedico) {
        Medico medico = buscarMedico(nomeMedico);
        if (medico != null) {
            medico.setDisponivel(true);
            System.out.println("Médico " + medico.getNome() + " agora está disponível.");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
}
