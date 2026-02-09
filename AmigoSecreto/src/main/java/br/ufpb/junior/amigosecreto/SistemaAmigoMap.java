package br.ufpb.junior.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap() {
        amigos = new HashMap<>();
        mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nome, String email) {
        Amigo amigo = new Amigo(nome, email);
        amigos.put(email, amigo);
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        Amigo amigo = amigos.get(email);

        if (amigo == null) {
            throw new AmigoInexistenteException(
                    "Amigo não encontrado: " + email);
        }

        return amigo;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa,
                                        String emailAmigoSorteado)
            throws AmigoInexistenteException {

        Amigo amigo = amigos.get(emailDaPessoa);

        if (amigo == null) {
            throw new AmigoInexistenteException(
                    "Amigo não encontrado: " + emailDaPessoa);
        }

        amigo.setEmailAmigoSecreto(emailAmigoSorteado);
    }

    public void enviarMensagemParaAlguem(String texto,
                                         String emailRemetente,
                                         String emailDestinatario,
                                         boolean anonima) {

        Mensagem msg = new MensagemParaAlguem(
                texto, emailRemetente, emailDestinatario, anonima);

        mensagens.add(msg);
    }

    public void enviarMensagemParaTodos(String texto,
                                        String emailRemetente,
                                        boolean anonima) {

        Mensagem msg = new MensagemParaTodos(
                texto, emailRemetente, anonima);

        mensagens.add(msg);
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(mensagens);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();

        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }

        return anonimas;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {

        Amigo amigo = amigos.get(emailDaPessoa);

        if (amigo == null) {
            throw new AmigoInexistenteException(
                    "Amigo não encontrado: " + emailDaPessoa);
        }

        if (amigo.getEmailAmigoSecreto() == null) {
            throw new AmigoNaoSorteadoException(
                    "Amigo secreto ainda não foi sorteado.");
        }

        return amigo.getEmailAmigoSecreto();
    }
}
