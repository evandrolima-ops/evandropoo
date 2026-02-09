package br.ufpb.junior.amigosecreto;

public abstract class Mensagem {

    protected String texto;
    protected String email;
    protected boolean anonima;

    public Mensagem(String texto, String email, boolean anonima) {
        this.texto = texto;
        this.email = email;
        this.anonima = anonima;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean ehAnonima() {
        return anonima;
    }

    public abstract String getTextoCompletoAExibir();
}
