package br.com.alura.ScreenMatch.principal;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import br.com.alura.ScreenMatch.modelos.*;

public class PrincipalComListas {

    public static void main(String[] args) {

        Filme filme1 = new Filme("Deadpool", 2016);
        filme1.avalia(7);
        Filme filme2 = new Filme("Homem Aranha", 2002);
        filme2.avalia(10);
        var filme3 = new Filme("Homem de Ferro", 2008);
        filme3.avalia(8);
        Serie serie = new Serie("Cobra Kai", 2018);

        List<Titulo> lista = new LinkedList<>();

        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie);

        for(Titulo item : lista) {
            System.out.println(item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        System.out.println();
        System.out.println("Separado por Título");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));

        System.out.println();
        System.out.println("Separado por ano");
        System.out.println(lista);

    }

}