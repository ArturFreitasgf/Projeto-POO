package Clinica.Class;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoMedico {
    private static ArrayList<Medico> medicos = new ArrayList<>();

    public static void adicionarMedico(Scanner leitor) {
        System.out.println("Digite o nome do médico:");
        String nome = leitor.nextLine();
        System.out.println("Digite a especialidade do médico:");
        String especialidade = leitor.nextLine();
        System.out.println("O médico está disponível? (S/N)");
        String disponivelStr = leitor.nextLine();
        boolean disponivel = disponivelStr.equalsIgnoreCase("S");

        Medico novoMedico = new Medico(nome, especialidade, disponivel);
        medicos.add(novoMedico);
        System.out.println("Médico adicionado com sucesso.");
    }


    public static Medico buscarMedico(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equalsIgnoreCase(nome)) {
                return medico;
            }
        }
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
