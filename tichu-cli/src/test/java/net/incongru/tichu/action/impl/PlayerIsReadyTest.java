package net.incongru.tichu.action.impl;

import net.incongru.tichu.simu.SimulatedGameContext;
import org.junit.jupiter.api.Test;

import static net.incongru.tichu.assertj.Conditions.notReadyNorStarted;
import static net.incongru.tichu.assertj.Conditions.started;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerIsReadyTest {
    @Test
    void failsWithUnknownPlayer() {
        final SimulatedGameContext ctx = new SimulatedGameContext();
        new InitialiseGame().exec(ctx);
        new JoinTable("jamie", 0).exec(ctx);

        assertThatThrownBy(() -> new PlayerIsReady("ghost").exec(ctx))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ghost");
    }

    @Test
    void holdYourHorsesMarkingYourselfReadyOnceIsEnough() {
        final SimulatedGameContext ctx = new SimulatedGameContext();
        new InitialiseGame().exec(ctx);
        new JoinTable("jamie", 0).exec(ctx);
        new PlayerIsReady("jamie").exec(ctx);
        assertThat(ctx.player("jamie").isReady()).isTrue();

        assertThatThrownBy(() -> new PlayerIsReady("jamie").exec(ctx))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("jamie");
    }

    @Test
    void gameStartsWhenAllPlayersAreReady() {
        final SimulatedGameContext ctx = new SimulatedGameContext();
        new InitialiseGame().exec(ctx);
        new JoinTable("alex", 0).exec(ctx);
        new JoinTable("charlie", 0).exec(ctx);
        new JoinTable("jules", 1).exec(ctx);
        new JoinTable("quinn", 1).exec(ctx);

        assertThat(ctx.game()).describedAs("Nobody is ready").is(notReadyNorStarted);
        new PlayerIsReady("alex").exec(ctx);
        assertThat(ctx.game()).describedAs("Should still not be ready with just 1 ready player").is(notReadyNorStarted);
        new PlayerIsReady("charlie").exec(ctx);
        new PlayerIsReady("jules").exec(ctx);
        assertThat(ctx.game()).describedAs("Should still not be ready with just 3 ready players").is(notReadyNorStarted);
        new PlayerIsReady("quinn").exec(ctx);
        assertThat(ctx.game()).describedAs("Should now be ready with all 4 ready players")
                .is(started);
    }
}