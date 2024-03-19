package fr.univavignon.pokedex.api;

import java.util.HashMap;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private HashMap<Integer, PokemonMetadata> dataBank = new HashMap<>();

    public PokemonMetadataProvider() {
        dataBank.put(1, new PokemonMetadata(1, "Bulbizarre", 126, 126, 90));
        dataBank.put(34, new PokemonMetadata(34, "Nidoking", 218, 112, 310));
        dataBank.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(!dataBank.containsKey(index)) {
            throw new PokedexException("Index invalide.");
        }
        return dataBank.get(index);
    }
}
