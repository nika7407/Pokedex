package edu.gtu.Pokedex.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;
    private String front_image;
    private String back_image;
    private List<PokemonType> types;

    @JsonCreator
    public Pokemon(@JsonProperty("id") int id,
                   @JsonProperty("name") String name,
                   @JsonProperty("height") int height,
                   @JsonProperty("weight") int weight,
                   @JsonProperty("sprites") JsonNode imageNode,
                   @JsonProperty("types") List<PokemonType> types) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = types;
        this.front_image = imageNode.get("front_default").asText();
        this.back_image = imageNode.get("back_default").asText();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



    public List<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }

    public String getFront_image() {
        return front_image;
    }

    public void setFront_image(String front_image) {
        this.front_image = front_image;
    }

    public String getBack_image() {
        return back_image;
    }

    public void setBack_image(String back_image) {
        this.back_image = back_image;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(capitalize(name)).append("\n");
        sb.append("Height: ").append(height).append(" dm\n");
        sb.append("Weight: ").append(weight).append(" hg\n");
        sb.append("Types: ");
        for (int i = 0; i < types.size(); i++) {
            sb.append(capitalize(types.get(i).getType().getName()));
            if (i < types.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    private String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Pokemon pokemon = (Pokemon) object;
        return id == pokemon.id && height == pokemon.height && weight == pokemon.weight && Objects.equals(name, pokemon.name) && Objects.equals(front_image, pokemon.front_image) && Objects.equals(back_image, pokemon.back_image) && Objects.equals(types, pokemon.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, height, weight, front_image, back_image, types);
    }
}
