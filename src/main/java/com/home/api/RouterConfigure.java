package com.home.api;

import javax.inject.Inject;

import com.home.api.middleware.GetUserHandlerMiddleWare;
import com.home.api.types.RestEndpointTypes;
import com.jetdrone.vertx.yoke.middleware.Router;

/**
 * Created by zhuanghua on 16/7/25.
 */
public class RouterConfigure {
    @Inject
    private Router router;

    @Inject
    private GetUserHandlerMiddleWare getUserHandlerMiddleWare;

    public void configure() {

        router.get(RestEndpointTypes.GET_USER.value(), getUserHandlerMiddleWare);

    }

}
