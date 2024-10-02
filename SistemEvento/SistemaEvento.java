package SistemEvento;
import java.util.Scanner;

public class SistemaEvento{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // Cadastro de Local
        System.out.println("----------Cadastro do Local do Evento----------");
        System.out.print("Endereço do Local: ");
        String enderecoLocal = scan.nextLine();
        System.out.print("Cidade do Local: ");
        String cidadeLocal = scan.nextLine();
        System.out.print("Tipo do Local: ");
        String tipoLocal = scan.nextLine();
        Local local = new Local(enderecoLocal, cidadeLocal, tipoLocal);

        // Cadastro de Evento
        System.out.println("\n----------Cadastro do Evento----------");
        System.out.print("Nome do Evento: ");
        String nomeevento = scan.nextLine();
        System.out.print("Capacidade Máxima do Evento: ");
        int capacidade = scan.nextInt();

        // Cadastro da Data
        System.out.print("Dia do Evento: ");
        int diaevento = scan.nextInt();
        System.out.print("Mês do Evento: ");
        int mesevento = scan.nextInt();
        System.out.print("Ano do Evento: ");
        int anoevento = scan.nextInt();
        scan.nextLine(); 

        Evento evento = new Evento(nomeevento, diaevento, mesevento, anoevento, capacidade, local);

        System.out.println("\n----------Registro de Participantes----------");
        String continuar;
        do {
            if (evento.estaLotado()){  
                System.out.println("Limite de participantes atingido.");  
                break;  
            }

            // Coleta informações do participante
            System.out.print("Nome do Participante: ");
            String nomeParticipante = scan.nextLine();
            System.out.print("Email do Participante: ");
            String emailParticipante = scan.nextLine();
            System.out.print("Número de Celular do Participante: ");
            String numeroCelularParticipante = scan.nextLine(); 

            Participante participante = new Participante(nomeParticipante, emailParticipante, numeroCelularParticipante);
            if (evento.adicionarParticipante(participante)) {
                System.out.println("Participante registrado com sucesso.");
            }

            System.out.print("Deseja adicionar outro participante? (sim/nao): ");
            continuar = scan.nextLine();
        } while (continuar.equalsIgnoreCase("sim"));

        // Geração do Relatório
        System.out.println("\n----------Gerando Relatório do Evento----------");
        evento.gerarRelatorio();

        scan.close();
    }
}
