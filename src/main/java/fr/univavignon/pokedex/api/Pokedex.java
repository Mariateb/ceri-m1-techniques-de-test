package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private int size;

    private List<Pokemon> pokemonList;

    private IPokemonMetadataProvider metadataProvider;

    private IPokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.size = 0;
        this.pokemonList = new ArrayList<Pokemon>();
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        this.size += 1;
        this.pokemonList.add(pokemon);
        return this.size - 1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id >= this.size || id < 0)  {
            throw new PokedexException("Index invalide");
        }

        return this.pokemonList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemonList;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> list = new ArrayList<Pokemon>(pokemonList);
        list.sort(order);
        return list;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return this.metadataProvider.getPokemonMetadata(index);
    }
}
