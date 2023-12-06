package ru.yandex.praktikum.data;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUser {

    public static UserData getRandomUser() {
        String email = RandomStringUtils.randomAlphabetic(4,6) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(6,10);
        String name = RandomStringUtils.randomAlphabetic(8);

        return new UserData(email, password, name);
    }

}
