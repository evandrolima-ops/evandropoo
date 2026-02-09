package br.ufpb.junior.amigosecreto;

public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente,
                              String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (anonima) {
            return "Mensagem para " + emailDestinatario +
                    ". Texto: " + texto;
        } else {
            return "Mensagem de " + email +
                    " para " + emailDestinatario +
                    ". Texto: " + texto;
        }
    }
}