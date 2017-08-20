package net.incongru.tichu.model.plays;

import net.incongru.tichu.model.Card;
import net.incongru.tichu.model.CardDeck;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static net.incongru.tichu.model.DeckConstants.Pagoda_10;
import static net.incongru.tichu.model.DeckConstants.Pagoda_4;
import static net.incongru.tichu.model.DeckConstants.Pagoda_5;
import static net.incongru.tichu.model.DeckConstants.Pagoda_6;
import static net.incongru.tichu.model.DeckConstants.Pagoda_7;
import static net.incongru.tichu.model.DeckConstants.Pagoda_8;
import static net.incongru.tichu.model.DeckConstants.Pagoda_9;
import static net.incongru.tichu.model.DeckConstants.Sword_4;
import static org.assertj.core.api.Assertions.assertThat;

public class AbstractPlayTest {
    @Test
    public void collectionsDotMinWithComparatorByPlayOrderToFindLowestCard() {
        CardDeck d = new CardDeck();
        final List<Card> cards = Arrays.asList(Pagoda_9, Pagoda_7, Sword_4, Pagoda_5, Pagoda_6, Pagoda_4, Pagoda_8, Pagoda_10);
        final Card min = Collections.min(cards, Card.Comparators.BY_PLAY_ORDER);
        assertThat(min).isIn(Pagoda_4, Sword_4);

        // Just checking my assumptions about matchers below:
        assertThat(cards).contains(Pagoda_4, Pagoda_5, Pagoda_6, Pagoda_7,
                Pagoda_8, Pagoda_9, Pagoda_10, Sword_4);
    }


}
