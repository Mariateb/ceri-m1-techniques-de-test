package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonMetadataProviderTest {

    @Mock
    IPokemonMetadataProvider provider;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testProvide() throws PokedexException {

        int aqualiIndex = 133;

        PokemonMetadata expected = new PokemonMetadata(
                133,
                "Aquali",
                186,
                168,
                260
        );
        
        when(provider.getPokemonMetadata(aqualiIndex)).thenReturn(expected);
        assertEquals(expected, provider.getPokemonMetadata(aqualiIndex));
    }
}
