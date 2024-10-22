package Clinica.Class;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoMedico {
    private static ArrayList<Medico> medicos = new ArrayList<>();

    // Modifica o método para retornar o objeto Medico
    public static Medico adicionarMedico(Scanner leitor) {
        System.out.println("Digite o nome do médico:");
        String nome = leitor.nextLine();
        System.out.println("Digite a especialidade do médico:");
        String especialidade = leitor.nextLine();
        System.out.println("O médico está disponível? (S/N)");
        String disponivelStr = leitor.nextLine();
        boolean disponivel = disponivelStr.equalsIgnoreCase("S");

        Medico novoMedico = new Medico(nome, especialidade, disponivel);
        medicos.add(novoMedico); // Adiciona o médico à lista
        System.out.println("Médico adicionado com sucesso.");

        return novoMedico; // Retorna o médico adicionado
    }

    public static Medico buscarMedico(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equalsIgnoreCase(nome)) {
                // Médico encontrado, imprimir as informações
                System.out.println("Dr. " + medico.getNome() + ": Especialidade em " + medico.getEspecialidade());
                System.out.println("Disponibilidade: " + (medico.isDisponivel() ? "Disponível" : "Indisponível"));
                return medico; // Retorna o médico encontrado
            }
        }
        System.out.println("Médico não encontrado.");
        return null;
    }

    public static void verificarDisponibilidade(String nome) {
        Medico medico = buscarMedico(nome);
        if (medico != null) {
            System.out.println("O médico está " + (medico.isDisponivel() ? "disponível" : "indisponível"));
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
}
