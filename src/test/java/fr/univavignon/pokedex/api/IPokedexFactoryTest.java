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

    @Mock
    private IPokedexFactory factory;

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    @Mock
    private IPokedex pokedex;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testPokedexCreation() {

        when(factory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
        IPokedex actual = factory.createPokedex(metadataProvider, pokemonFactory);
        assertEquals(pokedex, actual);
    }
}
