package br.ufpb.junior.amigosecreto;

import java.util.List;

public class SistemaAmigoTesteMap {

    public static void main(String[] args) {

        SistemaAmigoMap sistema = new SistemaAmigoMap();

        try {
            sistema.cadastraAmigo("José", "jose@email.com");
            sistema.cadastraAmigo("Maria", "maria@email.com");

            sistema.configuraAmigoSecretoDe(
                    "jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecretoDe(
                    "maria@email.com", "jose@email.com");

            sistema.enviarMensagemParaAlguem(
                    "Olá José!",
                    "maria@email.com",
                    "jose@email.com",
                    true
            );

            sistema.enviarMensagemParaTodos(
                    "Boa sorte a todos!",
                    "maria@email.com",
                    true
            );

            List<Mensagem> mensagensAnonimas =
                    sistema.pesquisaMensagensAnonimas();

            System.out.println("Mensagens anônimas:");
            for (Mensagem m : mensagensAnonimas) {
                System.out.println(m.getTextoCompletoAExibir());
            }

            String amigoSecretoJose =
                    sistema.pesquisaAmigoSecretoDe("jose@email.com");

            if (amigoSecretoJose.equals("maria@email.com")) {
                System.out.println("Ok");
            } else {
                System.out.println("Erro no sorteio");
            }

        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
