package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    @Mock
    IPokemonFactory factory;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPokemonCreation() throws PokedexException {

        int aqualiIndex = 133;

        Pokemon expected = new Pokemon(
                133,
                "Aquali",
                186,
                168,
                260,
                2729,
                202,
                5000,
                4,
                100
        );

        when(factory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(expected);
        Pokemon actual = factory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals(expected.getIndex(), actual.getIndex());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAttack(), actual.getAttack());
        assertEquals(expected.getDefense(), actual.getDefense());
        assertEquals(expected.getStamina(), actual.getStamina());
        assertEquals(expected.getCp(), actual.getCp());
        assertEquals(expected.getHp(), actual.getHp());
        assertEquals(expected.getDust(), actual.getDust());
        assertEquals(expected.getCandy(), actual.getCandy());
    }
}
