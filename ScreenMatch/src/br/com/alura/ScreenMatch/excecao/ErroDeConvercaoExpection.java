package br.com.alura.ScreenMatch.excecao;

public class ErroDeConvercaoExpection extends RuntimeException {

    private String mensagem;

    public ErroDeConvercaoExpection(String msg) {
        this.mensagem = msg;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
