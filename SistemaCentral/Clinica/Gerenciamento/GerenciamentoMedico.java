package Clinica.Gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;
import Clinica.Class.Medico;
import Clinica.Metodos.CadastroMedico;

public class GerenciamentoMedico {
    private static ArrayList<Medico> medicos = new ArrayList<>();

<<<<<<< HEAD:SistemaCentral/Clinica/Class/GerenciamentoMedico.java
    public static Medico adicionarMedico(Scanner leitor) {
        System.out.println("Digite o nome do médico:");
        String nome = leitor.nextLine();
        System.out.println("Digite o email do médico:");
        String email = leitor.nextLine();
        System.out.println("Digite o telefone do médico:");
        String telefone = leitor.nextLine();
        System.out.println("Digite a especialidade do médico:");
        String especialidade = leitor.nextLine();
        System.out.println("Digite o CRM do médico:");
        String crm = leitor.nextLine();
        System.out.println("O médico está disponível? (S/N)");
        boolean disponivel = leitor.nextLine().equalsIgnoreCase("S");

        Medico novoMedico = new Medico(nome, email, telefone, especialidade, disponivel, crm);

        medicos.add(novoMedico);
=======
    public static void adicionarMedico(Scanner leitor) {
        Medico medico = CadastroMedico.cadastrarMedico(leitor);
        medicos.add(medico);
>>>>>>> 7d389f3 (Clinica Finalizada):SistemaCentral/Clinica/Gerenciamento/GerenciamentoMedico.java
        System.out.println("Médico adicionado com sucesso.");
    }

    public static Medico buscarMedico(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equalsIgnoreCase(nome)) {
                // Exibe as informações do médico através do método toString()
                System.out.println(medico);  // Usando o método toString() para exibir as informações
                return medico;
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
        }
    }
}
