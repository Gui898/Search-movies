package br.com.alura.ScreenMatch.principal;

import br.com.alura.ScreenMatch.excecao.ErroDeConvercaoExpection;
import br.com.alura.ScreenMatch.modelos.Titulo;
import br.com.alura.ScreenMatch.modelos.TituloOmdb;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);
        String filme = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!filme.equalsIgnoreCase("sair") ) {

            if(filme.equalsIgnoreCase("sair")){
                break;
            }

            System.out.println("Digite um filme");
            filme = scan.nextLine();

            String endereco = "https://www.omdbapi.com/?t=" + filme.replace(" ", "+") + "&apikey=dc476d66";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco)).build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb meuTituloOmbd = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmbd);

                Titulo meuTitulo = new Titulo(meuTituloOmbd);
                System.out.println("\nTítulo já convertido: ");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("\nAconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento foi inválido, verfique o endereço");
            } catch (ErroDeConvercaoExpection e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("\nO programa finalizou corretamente");

        scan.close();
    }

}
