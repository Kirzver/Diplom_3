package ru.yandex.praktikum.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public static WebDriver
    getDriver(){
        String browserProperty = System.getProperty("test.browser","chrome");
        BrowserType browser = BrowserType.valueOf(browserProperty.toUpperCase());
        switch (browser){
            case CHROME:
                return new ChromeDriver();
            case YANDEX:
                System.setProperty("webdriver.chrome.driver","src/test/java/ru/yandex/praktikum/driver/yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new RuntimeException("browser undefined");
        }
    }
}
