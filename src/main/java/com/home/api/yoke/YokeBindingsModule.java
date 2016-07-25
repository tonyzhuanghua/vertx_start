package com.home.api.yoke;
import io.vertx.core.Verticle;
import com.google.inject.AbstractModule;
import com.jetdrone.vertx.yoke.Yoke;
import com.jetdrone.vertx.yoke.middleware.Router;


public class YokeBindingsModule extends AbstractModule {

    private Yoke yoke;

    private final Router router;

    public YokeBindingsModule(Verticle verticle) {
        this.yoke = new Yoke(verticle);
        this.router = new Router();
    }

    @Override
    public void configure() {
        bind(Yoke.class).toInstance(this.yoke);
        bind(Router.class).toInstance(this.router);
    }
}
