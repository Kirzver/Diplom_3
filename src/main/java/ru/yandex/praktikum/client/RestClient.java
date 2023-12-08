package ru.yandex.praktikum.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestClient {

    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";

    protected RequestSpecification requestSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }
}
