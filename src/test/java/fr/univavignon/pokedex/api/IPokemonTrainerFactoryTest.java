package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mock;

import static fr.univavignon.pokedex.api.Team.INSTINCT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokedex pokedex;
    @Mock
    private IPokedexFactory pokedexFactory;

    @Test
    public void testTrainerCreation() {
        IPokemonTrainerFactory factory;

        pokedex = Mockito.mock(IPokedex.class);
        factory = Mockito.mock(IPokemonTrainerFactory.class);

        PokemonTrainer expected = new PokemonTrainer(
                "John",
                INSTINCT,
                pokedex
        );

        when(factory.createTrainer("John", INSTINCT, pokedexFactory)).thenReturn(expected);
        PokemonTrainer actual = factory.createTrainer("John", INSTINCT, pokedexFactory);
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getTeam(), actual.getTeam());
        assertNotNull(actual.getPokedex());
    }
}
