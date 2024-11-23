package Clinica.Gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

import Clinica.Class.Medico;
import Utils.Interfaces.IMedico;

public class GerenciamentoMedico {
    private static ArrayList<Medico> medicos = new ArrayList<>();

    public static IMedico adicionarMedico(Scanner leitor) {  // Alterado para retornar IMedico
        System.out.println("Digite o nome do médico:");
        String nome = leitor.nextLine();
        System.out.println("Digite o email do médico:");
        String email = leitor.nextLine();  // Novo parâmetro
        System.out.println("Digite o número de celular do médico:");
        String numeroCelular = leitor.nextLine();  // Novo parâmetro
        System.out.println("Digite a especialidade do médico:");
        String especialidade = leitor.nextLine();
        System.out.println("Digite o CRM do médico:");
        String crm = leitor.nextLine();
        System.out.println("O médico está disponível? (S/N)");
        boolean disponivel = leitor.nextLine().equalsIgnoreCase("S");

        // Usando IMedico para permitir qualquer implementação
        IMedico novoMedico = new Medico(nome, email, numeroCelular, especialidade, disponivel, crm);
        medicos.add((Medico) novoMedico);  // Cast necessário para adicionar na lista de Medico
        System.out.println("Médico adicionado com sucesso.");

        return novoMedico;
    }

    public static Medico buscarMedico(String nome) {
        for (IMedico medico : medicos) {
            if (medico.getNome().equalsIgnoreCase(nome)) {
                medico.toString();
                return (Medico) medico;
            }
        }
        System.out.println("Médico não encontrado.");
        return null;
    }

    public static Medico buscarMedicoPorCrm(String crm) {
        for (IMedico medico : medicos) {
            if (medico.getCrm().equalsIgnoreCase(crm)) {
                return (Medico) medico;
            }
        }
        System.out.println("Médico com CRM " + crm + " não encontrado.");
        return null;
    }

    public static void tornarDisponivel(String nomeMedico) {
        Medico medico = buscarMedico(nomeMedico);
        if (medico != null) {
            medico.setDisponivel(true);
            System.out.println("Médico " + medico.getNome() + " agora está disponível.");
        }
    }

    public static void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }
        System.out.println("Lista de médicos cadastrados:");
        for (Medico medico : medicos) {
            System.out.println(medico);
        }
    }
}
