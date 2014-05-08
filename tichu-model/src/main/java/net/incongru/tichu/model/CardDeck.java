package net.incongru.tichu.model;

import java.util.HashSet;
import java.util.Set;

/**
 * All cards.
 */
public class CardDeck {
    private Set<Card> cards;
    public CardDeck() {
        cards = new HashSet<>();
        for (Card.CardNumbers cardNumbers : Card.CardNumbers.values()) {
            for (Card.CardSuit color : Card.CardSuit.values()) {
                cards.add(new Card(cardNumbers, color));
            }
        }
        // Arrays.asList(Card.CardSpecials.values()).forEach(s -> {new Card(s,null);});
        for (Card.CardSpecials cardSpecials : Card.CardSpecials.values()) {
            cards.add(new Card(cardSpecials, null));
        }
    }

    public Set<Card> getCards() {
        return cards;
    }
}
