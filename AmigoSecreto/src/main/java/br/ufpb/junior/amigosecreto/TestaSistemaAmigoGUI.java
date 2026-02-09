package br.ufpb.junior.amigosecreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {

    public static void main(String[] args) {

        SistemaAmigo sistema = new SistemaAmigo();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Quantidade de amigos: ");
            int qtd = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < qtd; i++) {
                System.out.println("Amigo " + (i + 1));

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("E-mail: ");
                String email = sc.nextLine();

                sistema.cadastraAmigo(nome, email);
            }

            System.out.println("\n--- Sorteio do Amigo Secreto ---");
            for (int i = 0; i < qtd; i++) {
                System.out.print("E-mail da pessoa: ");
                String emailPessoa = sc.nextLine();

                System.out.print("E-mail do amigo sorteado: ");
                String emailSorteado = sc.nextLine();

                sistema.configuraAmigoSecretoDe(emailPessoa, emailSorteado);
            }

            System.out.println("\n--- Enviar Mensagem Para Todos ---");

            System.out.print("E-mail do remetente: ");
            String remetente = sc.nextLine();

            System.out.print("Texto da mensagem: ");
            String texto = sc.nextLine();

            System.out.print("Mensagem anônima? (true/false): ");
            boolean anonima = Boolean.parseBoolean(sc.nextLine());

            sistema.enviarMensagemParaTodos(texto, remetente, anonima);

            System.out.println("\nMensagem enviada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
