package Clinica;

import java.util.Scanner;

import Clinica.Class.Consulta;

public class ClinicaManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o Nome do Paciente: ");
        String paciente = sc.nextLine();

        System.out.println("Digite o nome do medico: ");
        String medico = sc.nextLine();

        System.out.println("Digite a data (DD-MM-AAAA)");
        String data = sc.nextLine();

        System.out.println("Digite o Motivo: ");
        String motivo = sc.nextLine();


        Consulta consulta = new Consulta(id, paciente, medico, data, motivo);

        System.out.println("ID: " + consulta.getId());
        System.out.println("Paciente: " + consulta.getPaciente());
        System.out.println("Médico: " + consulta.getMedico());
        System.out.println("Data: " + consulta.getData());
        System.out.println("Motivo: " + consulta.getMotivo());

        sc.close();
    }

}