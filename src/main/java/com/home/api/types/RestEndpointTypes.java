package com.home.api.types;

/**
 * Created by zhuanghua on 16/7/25.
 */
public enum RestEndpointTypes {
    GET_USER ("/users/abc");

    private String value;

    private RestEndpointTypes(final String value)
    {
        this.value = value;
    }


    public String value()
    {
        return value;
    }

}
