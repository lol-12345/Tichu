package net.incongru.tichu.action.impl;

import net.incongru.tichu.action.Action;
import net.incongru.tichu.action.ActionParam;
import net.incongru.tichu.action.ActionResponse;
import net.incongru.tichu.action.GameContext;
import net.incongru.tichu.action.param.NewTrickParam;
import net.incongru.tichu.model.Trick;

class NewTrick implements Action<NewTrickParam> {

    @Override
    public ActionResponse exec(GameContext ctx, ActionParam.WithActor<NewTrickParam> param) {
        final Trick trick = ctx.game().currentRound().newTrick();
        ctx.log("New trick! %s", trick);
        return new SimpleActionResponse(param.actor(), ActionType.newTrick, NewTrickResult.OK);
    }

    enum NewTrickResult implements ActionResponse.Result {
        OK;
    }
}
