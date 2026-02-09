package br.ufpb.junior.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

    private List<Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigo() {
        amigos = new ArrayList<>();
        mensagens = new ArrayList<>();
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();

        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                mensagensAnonimas.add(m);
            }
        }

        return mensagensAnonimas;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa,
                                        String emailAmigoSorteado)
            throws AmigoInexistenteException {

        for (Amigo a : amigos) {
            if (a.getEmail().equals(emailDaPessoa)) {
                a.setEmailAmigoSecreto(emailAmigoSorteado);
                return;
            }
        }

        throw new AmigoInexistenteException(
                "Amigo não encontrado: " + emailDaPessoa);
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(mensagens);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {

        for (Amigo a : amigos) {
            if (a.getEmail().equals(emailDaPessoa)) {

                if (a.getEmailAmigoSecreto() == null) {
                    throw new AmigoNaoSorteadoException(
                            "Amigo secreto ainda não foi sorteado.");
                }

                return a.getEmailAmigoSecreto();
            }
        }

        throw new AmigoInexistenteException(
                "Amigo não encontrado: " + emailDaPessoa);
    }
    public void cadastraAmigo(String nome, String email){
        Amigo amigo = new Amigo (nome, email);
        amigos.add(amigo);
    }

    public void MensagemParaAlguem(String s, String mail, String mail1, boolean b) {
    }

    public void enviarMensagemParaTodos(String s, String mail, boolean b) {
    }
}

