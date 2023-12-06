package ru.yandex.praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.yandex.praktikum.data.Constants.*;

public class RegistrationPage {
    private final WebDriver driver;

    private final By tittleRegistration = By.xpath(".//h2[text()='Регистрация']");
    private final By fieldName = By.xpath(".//div[label[text()='Имя']]/input");
    private final By fieldMail = By.xpath(".//div[label[text()='Email']]/input");
    private final By fieldPassword = By.xpath(".//div[label[text()='Пароль']]/input");
    private final By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By stringIncorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    private final By linkEnter = By.xpath(".//a[text()='Войти']");


    public RegistrationPage(WebDriver driver){

        this.driver = driver;
    }
    @Step("Открытие страницы регистрации")
    public RegistrationPage openPage(){
        driver.get(REGISTER_PAGE);
        return this;
    }
    @Step("Ожидание загрузки страницы регистрации")
    public RegistrationPage waitLoadRegistrationPage(){
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(tittleRegistration).getText() != null
                && !driver.findElement(tittleRegistration).getText().isEmpty()
        ));
        return this;
    }
    @Step("Ввод имени")
    public RegistrationPage setName(String name){

        driver.findElement(fieldName).sendKeys(name);
        return this;
    }
    @Step("Ввод почты")
    public RegistrationPage setMail(String email){

        driver.findElement(fieldMail).sendKeys(email);
        return this;
    }
    @Step("Ввод пароля")
    public RegistrationPage setPassword(String password){

        driver.findElement(fieldPassword).sendKeys(password);
        return this;
    }
    @Step("Клик по кнопке Регистрация")
    public RegistrationPage clickOnButtonRegistration(){

        driver.findElement(buttonRegistration).click();
        return this;
    }
    @Step("Проверка появления надписи о некорректном пароле")
    public boolean checkIncorrectPasswordTextAndVisible(){
        return ((driver.findElement(stringIncorrectPassword).getText().equals(INCORRECT_PASSWORD))
                && (driver.findElement(stringIncorrectPassword).isDisplayed()));

    }
    @Step("Клик по надписи Вход")
    public RegistrationPage clickOnLinkEnter(){

        driver.findElement(linkEnter).click();
        return this;
    }
    @Step("Регистрация нового пользователя")
    public RegistrationPage registration(String name, String email,String password){
        waitLoadRegistrationPage();
        setName(name);
        setMail(email);
        setPassword(password);
        clickOnButtonRegistration();
        return this;
    }
}
