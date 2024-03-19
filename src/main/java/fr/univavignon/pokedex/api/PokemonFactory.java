package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonMetadata metadata;

        try {
            metadata = metadataProvider.getPokemonMetadata(index);
        } catch (PokedexException e) {
            return null;
        }

        Random random = new Random();

        return new Pokemon(
                index,
                metadata.getName(),
                metadata.getAttack(),
                metadata.getDefense(),
                metadata.getStamina(),
                cp,
                hp,
                dust,
                candy,
                random.nextInt(32)
        );
    }
}
