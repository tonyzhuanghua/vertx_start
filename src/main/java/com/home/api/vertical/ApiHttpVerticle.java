package com.home.api.vertical;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.home.api.RouterConfigure;
import com.home.api.yoke.YokeBindingsModule;
import com.jetdrone.vertx.yoke.Yoke;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

/**
 * Created by zhuanghua on 16/7/25.
 */
public class ApiHttpVerticle extends AbstractVerticle {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public void start(final Future<Void> fut) {

        Injector injector = Guice.createInjector(

                new YokeBindingsModule(this)
        );

        injector.getInstance(RouterConfigure.class).configure();

        Yoke yoke = injector.getInstance(Yoke.class);

        yoke.listen(8080, handler -> {

            if (handler.booleanValue()) {
                logger.info("starting........OK");
                fut.complete();
            }

        });
//        vertx.createHttpServer().requestHandler(httpServerRequest -> {
//            httpServerRequest.response().end("Hello smartjava");
//        }).listen(8080, result -> {
//            if (result.succeeded()) {
//                fut.complete();
//            } else {
//                fut.fail(fut.cause());
//            }
//        });

    }

}
