package co.iagomp;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    Scanner scanner = new Scanner(System.in);
    List<Paciente> pacientesCadastrados = new ArrayList<>(); // Lista de clientes cadastrados.
    List<Agendamentos> consultasAgendadas = new ArrayList<>(); // Lista de consultas marcadas.

    public void cadastrarPacientes() { //Método de cadastro de pacientes.

        System.out.println(" Olá, seja bem vindo ao cadastros de pacientes! ");
        scanner.nextLine();

        // Armazenamos a interação do usuário em uma variável.
        System.out.println(" Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.println(" Agora digite o número de contato: ");
        long contato = scanner.nextLong();

        // Declaramos o objeto paciente e passamos por parâmetro as variáveis da interação, ja que são as mesmas variáveis dos atributos.
        Paciente paciente = new Paciente(nome, contato);
        if (pacientesCadastrados.contains(paciente)) { // .contains verifica se já possui um paciente cadastrado com esses mesmos dados.
            System.out.println(" Paciente já possui cadastro no nosso sistema! ");

        } else {
            pacientesCadastrados.add(paciente);
            System.out.println(" Paciente cadastrado com sucesso! ");


        }
        System.out.println("Aperte enter para retornar ao menu: ");
        scanner.nextLine();
        scanner.nextLine();
    }

    public void agendarConsulta() { //metodo para agendamento de consulta.
        if (pacientesCadastrados.isEmpty()) { //Verifica se possui dados na lista.
            System.out.println("Não há pacientes cadastrados.");
        } else {
            boolean sair = false;

            while (!sair) {
                System.out.println("Lista de pacientes cadastrados:");

                // loop que percorre a lista de pacientes cadastrados.
                for (int i = 0; i < pacientesCadastrados.size(); i++) {

                    // Para cada interação do loop, um paciente é recuperado da lista de pacientes cadastrados.
                    Paciente paciente = pacientesCadastrados.get(i);

                    // As informações dos pacientes são impressas na tela
                    System.out.println((i + 1) + ". " + paciente.getNome() + "\n" + " Contato: " + paciente.getContato());
                }

                System.out.println(" Selecione o paciente para agendar uma consulta (ou 0 para voltar):");
                int escolha = scanner.nextInt();
                scanner.nextLine();

                if (escolha >= 1 && escolha <= pacientesCadastrados.size()) {
                    Paciente paciente = pacientesCadastrados.get(escolha - 1);
                    System.out.println("Paciente selecionado: " + paciente.getNome());

                    System.out.println("Digite a data e hora da consulta: (No formato dd/mm/yyyy  HH:mm ");

                    DateTimeFormatter date = DateTimeFormatter.ofPattern(scanner.nextLine());


                    System.out.println("Agora, digite qual especialidade você deseja: ");
                    String especialidade = scanner.nextLine();


                    Agendamentos consulta = new Agendamentos(date, especialidade);
                    if (consultasAgendadas.contains(consulta)) { // .contains verifica se já possui uma consulta agendada nessa mesma data e horário.
                        System.out.println("  Horário indisponível. Tente marcar outro horário. ");
                        System.out.println("Aperte enter para retornar ao menu. ");
                        scanner.nextLine();
                    } else {
                        consultasAgendadas.add(consulta);
                        System.out.println("Consulta agendada com sucesso!");
                    }

                } else if (escolha == 0) {
                    sair = true;

                } else {
                    System.out.println("Opção inválida.");
                }
            }
        }
        scanner.nextLine();
        Menu();
    }

    public void mostrarPacientesCadastrados() {
        for (int i = 0; i < pacientesCadastrados.size(); i++) {
            Paciente paciente = pacientesCadastrados.get(i);
            System.out.println((i + 1) + ". " + paciente.getNome() + " " + paciente.getContato());

        }

        scanner.nextLine();
        Menu();

    }

    public void mostrarConsultasAgendadas() {
        for (int i = 0; i < consultasAgendadas.size(); i++) {
            Agendamentos consulta = consultasAgendadas.get(i);

            System.out.println((i + 1) + ". Data: " + consulta.getData() + " " + " Especialidade: " + consulta.getEspecialidade());
        }
        scanner.nextLine();
        Menu();
    }

    public void cancelarConsulta() {
        if (consultasAgendadas.isEmpty()) {
            System.out.println(" Não há consultas agendadas. ");
        } else {
            boolean sair = false;

            while (!sair) {
                System.out.println(" Lista de consultas agendadas: ");
                for (int i = 0; i < consultasAgendadas.size(); i++) {
                    Agendamentos consulta = consultasAgendadas.get(i);
                    System.out.println((i + 1) + ". " + (consulta.getData()) + consulta.getEspecialidade());
                }
                System.out.println(" Selecione a consulta que gostaria de cancelar: ");
                int escolha = scanner.nextInt();

                if (escolha >= 1 && escolha <= consultasAgendadas.size()) {
                    Agendamentos consultaSelecionada = consultasAgendadas.get(escolha - 1);
                    System.out.println("Consulta selecionada: " + consultaSelecionada.getData() + consultaSelecionada.getEspecialidade());

                    consultasAgendadas.remove(consultaSelecionada);

                    System.out.println("Consulta cancelada!");
                    Menu();


                } else if (escolha == 0) {
                    sair = true;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        }
        scanner.nextLine();
        Menu();
    }

    public void Menu() {

        boolean sair = false;

        while (!sair) {

            System.out.println("================ MENU ================");
            System.out.println("1. Cadastrar pacientes ");
            System.out.println("2. Agendar consultas ");
            System.out.println("3. Pacientes cadastrados ");
            System.out.println("4. Consultas agendadas ");
            System.out.println("5. Cancelar consultas");
            System.out.println("6. Sair ");
            System.out.println("======================================");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    cadastrarPacientes();
                    break;
                case 2:
                    agendarConsulta();
                    break;
                case 3:
                    mostrarPacientesCadastrados();
                    break;
                case 4:
                    mostrarConsultasAgendadas();
                    break;
                case 5:
                    cancelarConsulta();
                    break;
                case 6:
                    sair = true;
                    System.out.println(" Programa encerrado! ");
                    break;
                default:
                    System.out.println(" Opção inválida! ");
            }
        }
    }


}



