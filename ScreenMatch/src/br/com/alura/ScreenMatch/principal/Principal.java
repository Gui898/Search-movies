package br.com.alura.ScreenMatch.principal;
import br.com.alura.ScreenMatch.modelos.*;

import java.util.*;

import br.com.alura.ScreenMatch.calculos.CalculadoraDeTempo;
import br.com.alura.ScreenMatch.calculos.FiltroRecomendacao;

public class Principal {

    public static void main(String[] args) {

        System.out.println("***************Filmes***************");
        System.out.println();

        Filme filme1 = new Filme("Deadpool", 2018);

        filme1.setDuracaoEmMinutos(180);

        filme1.exibeFichaTecnica();

        filme1.avalia(8.7);
        filme1.avalia(9);
        filme1.avalia(7.5);


        Filme filme2 = new Filme("Homem-Aranha", 2002);

        filme2.setDuracaoEmMinutos(120);
        filme2.avalia(10);

        var filme3 = new Filme("Homem de Ferro", 2008);

        filme3.setDuracaoEmMinutos(126);
        filme3.avalia(10);

        ArrayList<Filme> listaDeFilme = new ArrayList<>();

        listaDeFilme.add(filme1);
        listaDeFilme.add(filme2);
        listaDeFilme.add(filme3);

        System.out.println("Tamanho da lista: " + listaDeFilme.size());
        System.out.println("Primeiro filme: " + listaDeFilme.get(0).getNome());
        System.out.println("Lista: " + listaDeFilme.toString());

        System.out.println();
        System.out.println("***************Series***************");
        System.out.println();

        System.out.println("Total de avaliações: " + filme1.getTotalDeAvaliacoes());
        System.out.println("Média das avaliações" + filme1.pegaMedia());

        Serie serie = new Serie("Cobra Kai", 2018);

        serie.setMinPorEp(50);
        serie.setTemporada(3);
        serie.setEpPorTemporada(6);

        System.out.println("Duração em minutos: " + serie.getDuracaoEmMinutos());

        System.out.println();
        System.out.println("****************Calc****************");
        System.out.println();

        CalculadoraDeTempo calc = new CalculadoraDeTempo();

        calc.inclui(filme1);
        calc.inclui(filme2);
        calc.inclui(serie);
        System.out.println(calc.getTempoTotal());



        System.out.println();
        System.out.println("*****************Ep*****************");
        System.out.println();

        Episodio ep = new Episodio();

        ep.setNumero(1);
        ep.setTotalVisualizacoes(300);
        ep.setSerie(serie);

        System.out.println();
        System.out.println("***************Filtro***************");
        System.out.println();

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme1);
        filtro.filtra(ep);
    }

}
