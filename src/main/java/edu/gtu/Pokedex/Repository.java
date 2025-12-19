package edu.gtu.Pokedex;

import edu.gtu.Pokedex.domain.Pokemon;
import edu.gtu.Pokedex.parser.pokemonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Repository {

    private static final HttpClient client = HttpClient.newHttpClient();


    public Pokemon getPokemonById(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + id + "/"))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e){
            throw new RuntimeException();
        }

       return pokemonParser.parsePokemonJson(response.body());

    }

}
