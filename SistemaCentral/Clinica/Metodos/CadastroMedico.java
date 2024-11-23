package Clinica.Metodos;

import java.util.ArrayList;
import java.util.Scanner;

import Clinica.Class.Medico;
import Utils.Interfaces.IMedico;

public class CadastroMedico {
    private static ArrayList<Medico> medicos = new ArrayList<>();

    public static IMedico cadastrarMedico(Scanner leitor) {  // Alterado para retornar IMedico
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
}
