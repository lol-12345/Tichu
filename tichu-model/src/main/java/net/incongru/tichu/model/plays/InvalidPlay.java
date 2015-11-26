package net.incongru.tichu.model.plays;

import net.incongru.tichu.model.Card;
import net.incongru.tichu.model.Play;

import java.util.Set;

/**
 * Null-pattern implementation for plays that are not valid.
 */
public final class InvalidPlay implements Play {
    private final Set<Card> cards;

    public InvalidPlay(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public Set<Card> getCards() {
        return cards;
    }

    @Override
    public boolean canBePlayedAfter(Play other) {
        return false;
    }

    @Override
    public boolean isBomb() {
        return false;
    }

    @Override
    public String name() {
        return "Illegal";
    }

    @Override
    public String describe() {
        return "This does not correspond to any known trick: " + cards;
    }
}
