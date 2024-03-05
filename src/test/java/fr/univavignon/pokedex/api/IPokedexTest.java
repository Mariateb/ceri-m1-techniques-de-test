package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    @Mock
    IPokedex pokedex;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testPokedex() throws PokedexException {

        int expected;
        int actualSize = pokedex.size();
        assertEquals(0, actualSize);

        Pokemon aquali = new Pokemon(
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
        Pokemon bulbizarre = new Pokemon(
                1,
                "Bulbizarre",
                126,
                126,
                90,
                613,
                64,
                4000,
                4,
                56
        );
        expected = 0;

        when(pokedex.addPokemon(bulbizarre)).thenReturn(expected);
        assertEquals(expected, pokedex.addPokemon(bulbizarre));

        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        assertEquals(bulbizarre, pokedex.getPokemon(0));

        expected = 1;
        when(pokedex.addPokemon(aquali)).thenReturn(expected);
        assertEquals(expected, pokedex.addPokemon(aquali));

        when(pokedex.getPokemon(1)).thenReturn(aquali);
        assertEquals(aquali, pokedex.getPokemon(1));

        List<Pokemon> expectedList = List.of(new Pokemon[]{bulbizarre, aquali});
        when(pokedex.getPokemons()).thenReturn(expectedList);
        assertEquals(expectedList, pokedex.getPokemons());

        Comparator<Pokemon> comp = new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon o1, Pokemon o2) {
                return o1.getAttack() - o2.getAttack();
            }
        };

        expectedList = List.of(new Pokemon[]{aquali, bulbizarre});
        when(pokedex.getPokemons(comp)).thenReturn(expectedList);
        assertEquals(expectedList, pokedex.getPokemons(comp));
    }

}
