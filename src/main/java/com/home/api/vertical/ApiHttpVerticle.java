package com.home.api.vertical;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.JsonObject;

/**
 * Created by zhuanghua on 16/7/25.
 */
public class ApiHttpVerticle extends AbstractVerticle {
    public void start(final Future<Void> fut) {

        final JsonObject config = context.config();


        vertx.createHttpServer().requestHandler(httpServerRequest -> {
            httpServerRequest.response().end("Hello smartjava");
        }).listen(8080, result -> {
            if (result.succeeded()) {
                fut.complete();
            } else {
                fut.fail(fut.cause());
            }
        });

    }

}
