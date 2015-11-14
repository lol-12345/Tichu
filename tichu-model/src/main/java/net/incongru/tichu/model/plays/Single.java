package net.incongru.tichu.model.plays;

import static net.incongru.tichu.model.Card.CardSpecials.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import net.incongru.tichu.model.Card;

/**
 * @author gjoseph
 */
public class Single extends AbstractPlay<Single> {
    private final Card card;

    private Single(Set<Card> cards) {
        super(cards);
        this.card = cards.iterator().next();
        assert cards.size() == 1;
    }

    @Override
    public Set<Card> getCards() {
        return Collections.singleton(card);
    }

    @Override
    public String describe() {
        return name() + " " + card.name();
    }

    @Override
    protected boolean canBePlayedAfterTypeSafe(Single other) {
        if (card.getVal() == Dog || card.getVal() == MahJong) {
            return false;
        }

        final Card.CardValue otherCard = other.getCard().getVal();
        if (card.getVal() == Phoenix && otherCard != Dragon) {
            return true;
        } else {
            return card.getVal().playOrder() > otherCard.playOrder();
        }
    }

    public Card getCard() {
        return card;
    }

    public static class Factory implements PlayFactory<Single> {
        @Override
        public Single findIn(Set<Card> hand) {
            throw new IllegalStateException("not implemented yet"); // TODO
        }

        @Override
        public List<Single> findAllIn(Set<Card> hand) {
            throw new IllegalStateException("not implemented yet"); // TODO
        }

        @Override
        public Single is(Set<Card> cards) {
            if (cards.size() == 1) {
                return new Single(cards);
            }
            return null;
        }

    }
}
