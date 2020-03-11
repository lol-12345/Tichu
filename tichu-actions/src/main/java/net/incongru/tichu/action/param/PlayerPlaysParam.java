package net.incongru.tichu.action.param;

import net.incongru.tichu.action.ActionParam;
import net.incongru.tichu.model.Card;
import org.immutables.value.Value.Immutable;

import java.util.Set;

@Immutable
public interface PlayerPlaysParam extends ActionParam {
    String playerName();

    Set<Card> cards();
    // TODO jackson mapping?

    // Convenience ...
    static PlayerPlaysParam with(String playerName, Set<Card> cards) {
        return ImmutablePlayerPlaysParam.builder().playerName(playerName).cards(cards).build();
    }
}
