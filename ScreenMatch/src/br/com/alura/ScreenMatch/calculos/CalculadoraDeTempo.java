package br.com.alura.ScreenMatch.calculos;
import br.com.alura.ScreenMatch.modelos.Titulo;
public class CalculadoraDeTempo {
    private int tempoTotal = 0;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Titulo t) {
        tempoTotal += t.getDuracaoEmMinutos();
    }
}
