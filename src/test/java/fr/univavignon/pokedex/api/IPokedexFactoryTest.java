package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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

    @Test
    public void testPokedexCreation() {
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);

        factory = Mockito.mock(IPokedexFactory.class);

        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}
