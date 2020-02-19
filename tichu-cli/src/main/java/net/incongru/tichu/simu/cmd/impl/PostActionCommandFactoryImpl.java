package net.incongru.tichu.simu.cmd.impl;

import net.incongru.tichu.simu.Simulation;
import net.incongru.tichu.simu.cmd.PostActionCommandFactory;

public class PostActionCommandFactoryImpl implements PostActionCommandFactory {
    @Override
    public Simulation.PostActionCommand expectSuccess() {
        return new ExpectSuccess();
    }

    @Override
    public Simulation.PostActionCommand expectInvalidPlay(String expectedError) {
        return new ExpectInvalidPlay(expectedError);
    }

    @Override
    public Simulation.PostActionCommand expectError(String expectedError) {
        return new ExpectError(expectedError);
    }

    @Override
    public Simulation.PostActionCommand expectPlay(TemporaryPlayNamesEnum play) {
        return new ExpectPlay(play);
    }

    @Override
    public Simulation.PostActionCommand expectWinTrick() {
        return new ExpectWinTrick();
    }

    @Override
    public Simulation.PostActionCommand expectEndOfRound() {
        return new ExpectEndOfRound();
    }

    @Override
    public Simulation.PostActionCommand expectRoundScore(String teamName, int expectedScore) {
        return new ExpectRoundScore(teamName, expectedScore);
    }

    @Override
    public Simulation.PostActionCommand debugPlayerHand(String playerName) {
        return new DebugPlayerHand(playerName);
    }
}
