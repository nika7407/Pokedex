package edu.gtu.Pokedex.domain;

public class PokemonType {
    private int slot;
    private TypeInfo type;

    public PokemonType() {
    }

    public PokemonType(int slot, TypeInfo type) {
        this.slot = slot;
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public TypeInfo getType() {
        return type;
    }

    public void setType(TypeInfo type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type != null ? type.getName() : "Unknown";
    }
}

class TypeInfo {
    private String name;
    private String url;

    public TypeInfo() {
    }

    public TypeInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return name;
    }
}