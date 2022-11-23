package com.epam.rd;

import io.restassured.response.ValidatableResponse;

import java.util.List;

public class ResponseUtils {

    public static ValidatableResponse getResponse() {
        return RequestsUtils.getResponse();
    }


    public static int getIntFromResponse(String path) {
        return getResponse()
                .extract()
                .jsonPath()
                .getInt(path);
    }

    public static String getStringFromResponse(String path) {
        return getResponse()
                .extract()
                .jsonPath()
                .getString(path);
    }

    public static <T> List<T> getListFromResponse(String path, Class<T> type ) {
        return getResponse()
                .extract()
                .jsonPath()
                .getList(path, type);
    }

    public static int getStatusCodeFromResponse() {
        return getResponse()
                .extract()
                .statusCode();
    }

    public static <T> T getObjectFromResponse(String path, Class<T> type) {
        return getResponse()
                .extract()
                .jsonPath()
                .getObject(path, type);
    }
}
