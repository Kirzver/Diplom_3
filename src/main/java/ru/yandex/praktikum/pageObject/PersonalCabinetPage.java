package ru.yandex.praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PersonalCabinetPage {

    private final WebDriver driver;

    private final By textProfile = By.xpath(".//a[text()='Профиль']");
    private final By logo = By.xpath(".//div/a[@href='/']");
    private final By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    private final By buttonExit = By.xpath(".//button[text()='Выход']");


    public PersonalCabinetPage(WebDriver driver){

        this.driver = driver;
    }
    @Step("Ожидание загрузки страницы личного кабинета")
    public PersonalCabinetPage waitLoadTextProfile(){
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(textProfile).getText() != null
                && !driver.findElement(textProfile).getText().isEmpty()
        ));
        return this;
    }
    @Step("Клик по кнопке Конструктор")
    public PersonalCabinetPage clickOnButtonConstructor(){

        driver.findElement(buttonConstructor).click();
        return this;
    }
    @Step("Клик по лого")
    public PersonalCabinetPage clickOnLogo(){
        driver.findElement(logo).click();
        return this;
    }
    @Step("Клик по кнопке Выход в личном кабинете")
    public PersonalCabinetPage clickOnButtonExit(){
        driver.findElement(buttonExit).click();
        return this;
    }
}
