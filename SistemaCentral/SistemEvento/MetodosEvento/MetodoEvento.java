package SistemEvento.MetodosEvento;

import SistemEvento.Classe.Evento;
import SistemEvento.Classe.Local;
import SistemEvento.Classe.Participante;

import java.util.Scanner;

public class MetodoEvento {

    public static Local cadastrarLocal(Scanner scan) {
        System.out.println("\n----------Cadastro do Local do Evento----------");
        System.out.print("Endereço do Local: ");
        String enderecoLocal = scan.nextLine();
        System.out.print("Cidade do Local: ");
        String cidadeLocal = scan.nextLine();
        System.out.print("Tipo do Local: ");
        String tipoLocal = scan.nextLine();
        return new Local(enderecoLocal, cidadeLocal, tipoLocal);
    }

    public static Evento cadastrarEvento(Scanner scan, Local local) {
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
        scan.nextLine(); // Consumir a nova linha

        return new Evento(nomeevento, diaevento, mesevento, anoevento, capacidade, local);
    }

    public static Participante coletarInformacoesParticipante(Scanner scan) {
        System.out.println("\n----------Registro de Participantes----------");
        System.out.print("Nome do Participante: ");
        String nomeParticipante = scan.nextLine();
        System.out.print("Email do Participante: ");
        String emailParticipante = scan.nextLine();
        System.out.print("Número de Celular do Participante: ");
        String numeroCelularParticipante = scan.nextLine();

        return new Participante(nomeParticipante, emailParticipante, numeroCelularParticipante);
    }

    public static void gerarRelatorio(Evento evento) {
        System.out.println("Evento: " + evento.getNomeevento());
        System.out.println("Data: " + evento.getDiaevento() + "/" + evento.getMesevento() + "/" + evento.getAnoevento());
        System.out.println("Local: " + evento.getLocal().getEndereco());
        System.out.println("Capacidade Máxima: " + evento.getCapacidade());
        System.out.println("Total de Participantes: " + evento.getTotalparticipantes());
        System.out.println("\n------------Lista de Participantes-------------");
        for (int i = 0; i < evento.getTotalparticipantes(); i++) {
            Participante p = evento.getParticipantes()[i];
            System.out.println("Nome: " + p.getNome() + ", Email: " + p.getEmail() + ", Celular: " + p.getNumerocelular());
        }
    }

    public static boolean adicionarParticipante(Evento evento, Participante participante) {
        if (evento.getTotalparticipantes() < evento.getCapacidade()) {
            evento.getParticipantes()[evento.getTotalparticipantes()] = participante;
            evento.setTotalparticipantes(evento.getTotalparticipantes() + 1);
            return true;
        } else {
            return false;
        }
    }
}
