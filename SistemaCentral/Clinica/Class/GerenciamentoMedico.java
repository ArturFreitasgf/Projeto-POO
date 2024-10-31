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
        for (Medico medico : medicos) {
            if (medico.getNome().equalsIgnoreCase(nome)) {
                // Médico encontrado, imprimir as informações
                System.out.println("Dr. " + medico.getNome());
                System.out.println("Especialidade: " + medico.getEspecialidade());
                System.out.println("CRM: " + medico.getCrm());
                System.out.println("Disponibilidade: " + (medico.isDisponivel() ? "Disponível" : "Indisponível"));
                return medico; // Retorna o médico encontrado
            }
        }
        System.out.println("Médico não encontrado.");
        return null;
    }

    public static Medico buscarMedicoPorCrm(String crm){
        for(Medico medico: medicos) {
            if(medico.getCrm().equalsIgnoreCase(crm)){
                return medico;
            }
        }
        return null;
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
