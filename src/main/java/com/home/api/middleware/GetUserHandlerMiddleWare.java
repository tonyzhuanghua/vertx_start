package com.home.api.middleware;

import com.home.api.utils.ReplyBuilder;
import com.jetdrone.vertx.yoke.Middleware;
import com.jetdrone.vertx.yoke.middleware.YokeRequest;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;

/**
 * Created by zhuanghua on 16/7/25.
 */
public class GetUserHandlerMiddleWare extends Middleware {
    @Inject
    private ReplyBuilder replyBuilder;

    @Override
    public void handle(YokeRequest yokeRequest, Handler<Object> handler) {
        JsonObject reply = new JsonObject();
        reply.put("test","good");

        replyBuilder.buildReply(yokeRequest,200,reply);
    }
}
