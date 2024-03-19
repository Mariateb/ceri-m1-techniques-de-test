package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private Pokedex pokedex;

    @Before
    public void before() {
        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
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

        assertEquals(expected, pokedex.addPokemon(bulbizarre));
        assertEquals(bulbizarre, pokedex.getPokemon(0));

        expected = 1;

        assertEquals(expected, pokedex.addPokemon(aquali));
        assertEquals(aquali, pokedex.getPokemon(1));

        List<Pokemon> expectedList = List.of(new Pokemon[]{bulbizarre, aquali});

        assertEquals(expectedList, pokedex.getPokemons());

        Comparator<Pokemon> comp = Comparator.comparing(Pokemon::getAttack);
        comp = comp.reversed();

        expectedList = List.of(new Pokemon[]{aquali, bulbizarre});

        assertEquals(expectedList, pokedex.getPokemons(comp));
    }

}
