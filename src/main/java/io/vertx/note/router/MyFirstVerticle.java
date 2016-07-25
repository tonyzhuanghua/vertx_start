package io.vertx.note.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by zhuanghua on 16/7/25.
 */
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        vertx
                .createHttpServer()
                .requestHandler( r -> {
                    r.response().end("<h1>Hello from my first Vert.x 3 application</h1>");
                })
                .listen(8080, result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(fut.cause());
                    }
                });
    }
}
