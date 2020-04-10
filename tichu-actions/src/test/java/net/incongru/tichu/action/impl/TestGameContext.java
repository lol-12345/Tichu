package net.incongru.tichu.action.impl;

import net.incongru.tichu.action.AbstractGameContext;
import net.incongru.tichu.action.GameContext;
import net.incongru.tichu.action.param.CheatDealParam;
import net.incongru.tichu.action.param.InitialiseGameParam;
import net.incongru.tichu.action.param.JoinTableParam;
import net.incongru.tichu.action.param.PlayerIsReadyParam;
import net.incongru.tichu.model.Card;
import net.incongru.tichu.model.Game;
import net.incongru.tichu.model.Player;

import java.util.Set;

class TestGameContext extends AbstractGameContext {
    TestGameContext initialised() {
        new InitialiseGame().exec(this, InitialiseGameParam.with());
        return this;
    }

    TestGameContext withSamplePlayers() {
        // play order would be alex jules charlie quinn
        new JoinTable().exec(this, JoinTableParam.with("alex", 0)); // player 1 (team 1)
        new JoinTable().exec(this, JoinTableParam.with("charlie", 0));  // player 3 (team 1)
        new JoinTable().exec(this, JoinTableParam.with("jules", 1));  // player 2 (team 2)
        new JoinTable().exec(this, JoinTableParam.with("quinn", 1)); // player 4 (team 2)
        return this;
    }

    // ideally shouldn't be able to call this if haven't set sample players...
    TestGameContext withCards(Set<Card> forAlex, Set<Card> forCharlie, Set<Card> forJules, Set<Card> forQuinn) {
        new CheatDeal().exec(this, CheatDealParam.with("alex", forAlex));
        new CheatDeal().exec(this, CheatDealParam.with("charlie", forCharlie));
        new CheatDeal().exec(this, CheatDealParam.with("jules", forJules));
        new CheatDeal().exec(this, CheatDealParam.with("quinn", forQuinn));
        return this;
    }

    // ideally shouldn't be able to call this if haven't set sample players...
    TestGameContext allReady() {
        new PlayerIsReady().exec(this, PlayerIsReadyParam.with("alex"));
        new PlayerIsReady().exec(this, PlayerIsReadyParam.with("charlie"));
        new PlayerIsReady().exec(this, PlayerIsReadyParam.with("jules"));
        new PlayerIsReady().exec(this, PlayerIsReadyParam.with("quinn"));
        return this;
    }

    TestGameContext() {
    }

    @Override
    public void log(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

}
