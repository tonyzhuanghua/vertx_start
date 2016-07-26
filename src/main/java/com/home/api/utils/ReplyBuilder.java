package com.home.api.utils;

import com.jetdrone.vertx.yoke.middleware.YokeRequest;
import io.vertx.core.json.JsonObject;

public class ReplyBuilder {


    public void buildReply(final YokeRequest request, final Integer status, final JsonObject message) {
        request.response().setStatusCode(status);
        request.response().setContentType("application/json");
        request.response().end(message);

    }


}
