package Clinica.Class;

import java.util.ArrayList;

public class GerenciamentoMedico {
    private static ArrayList<Medico> medicos = new ArrayList<>();

    public static void adicionarMedico(Medico medico) {
        medicos.add(medico);
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
