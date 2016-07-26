package com.home.api;

import com.home.api.middleware.GetUserHandlerMiddleWare;
import com.jetdrone.vertx.yoke.middleware.Router;

import javax.inject.Inject;

/**
 * Created by zhuanghua on 16/7/25.
 */
public class RouterConfigure {
    @Inject
    private Router router;

    @Inject
    private GetUserHandlerMiddleWare getUserHandlerMiddleWare;

    public void configure() {

        router.get("/users/:id", getUserHandlerMiddleWare);
        router.get("/users", getUserHandlerMiddleWare);

    }

    public Router getRouter(){
        return this.router;
    }
}
