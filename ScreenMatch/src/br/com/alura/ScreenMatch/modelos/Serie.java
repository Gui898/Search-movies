package br.com.alura.ScreenMatch.modelos;

public class Serie extends Titulo {

    private int temporada;
    private int epPorTemporada;
    private int minutosPorEp;
    private boolean ativa;

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public void setEpPorTemporada(int ep) {
        epPorTemporada = ep;
    }

    public void setMinPorEp(int min) {
        minutosPorEp = min;
    }

    public int getTemporada() {
        return temporada;
    }

    public int getMinutosPorEp() {
        return minutosPorEp;
    }

    public int getEpPorTemporada() {
        return epPorTemporada;
    }

    public boolean getAtiva() {
        return ativa;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporada * epPorTemporada * minutosPorEp;
    }

    @Override
    public String toString(){
        return "Série: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }

}