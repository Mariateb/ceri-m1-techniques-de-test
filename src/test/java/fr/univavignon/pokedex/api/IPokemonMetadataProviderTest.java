package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonMetadataProviderTest {

    PokemonMetadataProvider provider;

    @Before
    public void before() {
        provider = new PokemonMetadataProvider();
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
        PokemonMetadata actual = provider.getPokemonMetadata(aqualiIndex);

        assertEquals(expected.getIndex(), actual.getIndex());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAttack(), actual.getAttack());
        assertEquals(expected.getDefense(), actual.getDefense());
        assertEquals(expected.getStamina(), actual.getStamina());
    }
}
