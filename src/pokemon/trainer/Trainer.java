package pokemon.trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public boolean checkForElement(String element) {
        boolean haveThisElement = false;

        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)){
                haveThisElement = true;
                break;
            }
        }
        return haveThisElement;
    }

    public void plusOneBadge() {
        this.badges ++;
    }

    public void lossHealth() {
        for (Pokemon pokemon : pokemons) {
            pokemon.lossHealth();
        }
    }

    public void checkForDead() {
        pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

    public String getName() {
        return this.name;
    }

    public int getBadges() {
        return this.badges;
    }
}
