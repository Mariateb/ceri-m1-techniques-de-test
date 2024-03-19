package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static fr.univavignon.pokedex.api.Team.INSTINCT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private Pokedex pokedex;

    private PokedexFactory pokedexFactory;

    private PokemonTrainerFactory factory;

    @Before
    public void before() {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();

        pokedexFactory = new PokedexFactory();
        factory = new PokemonTrainerFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testTrainerCreation() {

        PokemonTrainer expected = new PokemonTrainer(
                "John",
                INSTINCT,
                pokedex
        );

        PokemonTrainer actual = factory.createTrainer("John", INSTINCT, pokedexFactory);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getTeam(), actual.getTeam());
        assertNotNull(actual.getPokedex());
    }
}
