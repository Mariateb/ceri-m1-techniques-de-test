package fr.univavignon.pokedex.api;

import java.util.concurrent.TransferQueue;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {

        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());

        return new PokemonTrainer(name, team, pokedex);
    }
}
