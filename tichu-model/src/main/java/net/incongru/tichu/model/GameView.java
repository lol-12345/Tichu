package net.incongru.tichu.model;

import lombok.Value;

import java.util.Deque;
import java.util.Set;

/**
 * A view on a current game from a given player's perspective.
 */
@Value
public class GameView {
    private final Players.Player you;
    private final Players.Player teamMate;
    private final Players.Team opponents;
    /**
     * The cards in your hand.
     */
    private final Set<Card> hand;

    private final Deque<Play> plays;

    /**
     * Amount of cards collected by the team so far - do we even need this ? Shouldn't be allowed to look at it, but for the sake of showing a small or large pile or cards, maybe ...
     */
    private final int collectedCards;
}
