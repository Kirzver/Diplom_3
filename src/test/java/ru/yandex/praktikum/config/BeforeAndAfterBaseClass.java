package ru.yandex.praktikum.config;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.client.UserClient;
import ru.yandex.praktikum.data.Browser;
import ru.yandex.praktikum.data.BrowserType;
import ru.yandex.praktikum.data.RandomUser;
import ru.yandex.praktikum.data.UserData;


public abstract class BeforeAndAfterBaseClass {
    private WebDriver driver;
    public UserClient userClient;
    public UserData user;

    @Before
    public void start() {
        driver = Browser.getDriver();
        userClient = new UserClient();
        user = RandomUser.getRandomUser();
    }

    public WebDriver getDriver(){
        return driver;
    }


    @After
    public void teardown(){
        driver.quit();
        ValidatableResponse response = userClient.loginUser(user);
        if(response.extract().statusCode() == 200)
            userClient.deleteUser(response.extract().path("accessToken"));
    }
}
