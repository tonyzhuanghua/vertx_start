package com.home.api.middleware;

import com.home.api.utils.ReplyBuilder;
import com.jetdrone.vertx.yoke.Middleware;
import com.jetdrone.vertx.yoke.middleware.YokeRequest;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import javax.inject.Inject;

/**
 * Created by zhuanghua on 16/7/25.
 */
public class CreateOrUpdateUserHandlerMiddleWare extends Middleware {
    @Inject
    private ReplyBuilder replyBuilder;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Override
    public void handle(YokeRequest yokeRequest, Handler<Object> handler) {
        logger.info(yokeRequest.contentLength()+"");
        yokeRequest.getFormAttribute("abc");
        JsonObject reply = new JsonObject();
        reply.put("test","good");
        yokeRequest.isEnded();


        replyBuilder.buildReply(yokeRequest,201,reply);
    }
}
