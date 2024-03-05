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

    @Mock
    private IPokedex pokedex;
    @Mock
    private IPokedexFactory pokedexFactory;
    @Mock
    private IPokemonTrainerFactory factory;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testTrainerCreation() {

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
