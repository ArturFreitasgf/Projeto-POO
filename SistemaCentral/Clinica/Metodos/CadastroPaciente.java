package Clinica.Metodos;


import java.util.Scanner;
import Clinica.Class.Paciente;
import Clinica.Gerenciamento.GerenciamentoPaciente;


public class CadastroPaciente {
    public static Paciente cadastrarPaciente(Scanner leitor) {
        System.out.println("Digite o nome do paciente:");
        String nome = leitor.nextLine();
        
        System.out.println("Digite o CPF do paciente:");
        String cpf = leitor.nextLine();  // Altere para nextLine() para capturar o CPF como uma string
        
        System.out.println("Digite o telefone do paciente:");
        String telefone = leitor.nextLine();
        
        // Adicionando o nextLine() para limpar o buffer de linha após a captura do CPF
        leitor.nextLine();  // Consumindo a quebra de linha residual do nextLine()
        
        System.out.println("Digite o email do paciente:");
        String email = leitor.nextLine();  // Agora o e-mail será corretamente solicitado
        
        // Verifica se o CPF já está cadastrado
        if (GerenciamentoPaciente.buscarPacientePorCpf(cpf) != null) {
            System.out.println("Erro: Já existe um paciente com este CPF cadastrado.");
            return null;
        }
    
        // Cria e adiciona o novo paciente à lista
        Paciente novoPaciente = new Paciente(nome, email, telefone, cpf);
        System.out.println("Paciente cadastrado com sucesso!");
    
        return novoPaciente;
    }
}
