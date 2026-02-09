package br.ufpb.junior.amigosecreto;

public class AmigoInexistenteException extends Exception {

    public AmigoInexistenteException() {
        super();
    }

    public AmigoInexistenteException(String mensagem) {
        super(mensagem);
    }
}

