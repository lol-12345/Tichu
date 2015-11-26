package net.incongru.tichu.model;

import com.google.common.collect.FluentIterable;
import org.junit.Test;

import static net.incongru.tichu.model.Card.Comparators.BY_SUIT;
import static net.incongru.tichu.model.DeckConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 */
public class CardTest {

    @Test
    public void cardNamesAreOkay() {
        assertEquals("Ace of Sword", new Card(Card.CardNumbers.Ace, Card.CardSuit.Sword).name());
        assertEquals("Queen of Star", new Card(Card.CardNumbers.Queen, Card.CardSuit.Star).name());
        assertEquals("7 of Pagoda", new Card(Card.CardNumbers.Seven, Card.CardSuit.Pagoda).name());
        assertEquals("Dragon", new Card(Card.CardSpecials.Dragon).name());
    }

    @Test
    public void suitComparatorPutsDogBeforeNumberedCards() {
        assertThat(BY_SUIT.compare(Dog, DeckConstants.B2)).isLessThan(0);
    }

    @Test
    public void suitComparatorDoesNotMessUpSpecialCards() {
        final Card[] array = {Dog, Dragon, MahJong, Phoenix};
        // We don't really care about the order that much, we just want to make sure the comparator is consistent with equals, i.e does not equal two cards which are not the same
        assertThat(FluentIterable.of(array).toSortedList(BY_SUIT)).containsOnly(array);
        assertThat(FluentIterable.of(array).toSortedSet(BY_SUIT)).containsOnly(array);
        assertThat(FluentIterable.from(new CardDeck().allRemaining()).toSortedList(BY_SUIT)).hasSize(56);
        assertThat(FluentIterable.from(new CardDeck().allRemaining()).toSortedSet(BY_SUIT)).hasSize(56);
    }

}
