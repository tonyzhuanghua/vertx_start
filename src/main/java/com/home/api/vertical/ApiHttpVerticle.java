package com.home.api.vertical;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.home.api.RouterConfigure;
import com.home.api.yoke.YokeBindingsModule;
import com.jetdrone.vertx.yoke.Yoke;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

/**
 * Created by zhuanghua on 16/7/25.
 */
public class ApiHttpVerticle extends AbstractVerticle {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public void start() {

        Injector injector = Guice.createInjector(new YokeBindingsModule(this));
        RouterConfigure routerConfigure = injector.getInstance(RouterConfigure.class);
        routerConfigure.configure();

        Yoke yoke = injector.getInstance(Yoke.class);
        yoke
                .use(routerConfigure.getRouter())
                .listen(8081, result -> {
                    if(result.booleanValue()){
                        logger.info("successfully running service on 8081");
                    }
                });

    }

}
