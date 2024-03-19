package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private IPokemonMetadataProvider metadataProvider;

    private PokemonFactory pokemonFactory;

    @Before
    public void before() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testPokedexCreation() {

        PokedexFactory factory = new PokedexFactory();

        Pokedex actual = (Pokedex) factory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(actual);
    }
}
