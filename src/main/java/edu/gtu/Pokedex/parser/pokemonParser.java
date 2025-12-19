package edu.gtu.Pokedex.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.gtu.Pokedex.domain.Pokemon;

public class pokemonParser {

    public static Pokemon parsePokemonJson(String pokemonJsonBody) {
        ObjectMapper mapper = new ObjectMapper();
        Pokemon pokemon = null;
        try {
             pokemon = mapper.readValue(pokemonJsonBody, Pokemon.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e + "json proccesing erorr ");
        }
        return pokemon;
    }
}
