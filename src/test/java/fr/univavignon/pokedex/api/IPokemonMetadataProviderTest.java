package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
    @Test
    public void testProvide() throws PokedexException {
        IPokemonMetadataProvider provider;

        provider = Mockito.mock(IPokemonMetadataProvider.class);
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
