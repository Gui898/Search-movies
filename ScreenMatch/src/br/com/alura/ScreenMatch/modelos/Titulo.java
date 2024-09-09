package br.com.alura.ScreenMatch.modelos;

import br.com.alura.ScreenMatch.excecao.ErroDeConvercaoExpection;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int anoDeLancamento;

    private boolean incluidoNoPlano;
    private double somaAvaliacao;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmbd) {
        this.nome = meuTituloOmbd.title();

        if(meuTituloOmbd.year().length() > 4){
            throw new ErroDeConvercaoExpection("Não consegui converter o ano porque " +
                    "tem mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmbd.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmbd.runtime().substring(0, 3));
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int ano) {
        anoDeLancamento = ano;
    }

    public void setDuracaoEmMinutos(int duracao) {
        duracaoEmMinutos = duracao;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public boolean getIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota) {
        somaAvaliacao += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaAvaliacao / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString(){
        return  "(nome = " + this.getNome() + ", " +
                "anoDeLançamento = " + this.getAnoDeLancamento() + ", " +
                "duraçãoEmMin = " + this.getDuracaoEmMinutos() + ")";
    }

}
