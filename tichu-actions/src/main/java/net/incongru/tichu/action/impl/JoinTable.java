package net.incongru.tichu.action.impl;

import net.incongru.tichu.action.Action;
import net.incongru.tichu.action.ActionResult;
import net.incongru.tichu.action.ActionResult.Success;
import net.incongru.tichu.action.GameContext;
import net.incongru.tichu.action.param.JoinTableParam;
import net.incongru.tichu.model.Player;
import net.incongru.tichu.model.Players;
import net.incongru.tichu.model.Team;

class JoinTable implements Action<JoinTableParam> {

    JoinTable() {
    }

    @Override
    public Class paramType() {
        return JoinTableParam.class;
    }

    @Override
    public ActionResult exec(GameContext ctx, JoinTableParam param) {
        // TODO validating team number should be role of action/rules, but where does error bubble up if invalid ?
        final Players players = ctx.game().players();
        final Team team = players.getTeam(param.team());
        players.join(new Player(param.playerName()), team);
        return new Success() {
//                return playerName + " joined team " + team;
        };
    }

}
