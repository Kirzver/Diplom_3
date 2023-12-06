package ru.yandex.praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.yandex.praktikum.data.Constants.LOGIN_PAGE;

public class LoginPage {
    private final WebDriver driver;

    private final By tittleEnter = By.xpath(".//h2[text()='Вход']");
    private final By fieldMail = By.xpath(".//div[label[text()='Email']]/input");
    private final By fieldPassword = By.xpath(".//div[label[text()='Пароль']]/input");
    private final By buttonEnter = By.xpath(".//button[text()='Войти']");
    private final By linkRegistration = By.xpath(".//a[text()='Зарегистрироваться']");


    public LoginPage(WebDriver driver){

        this.driver = driver;
    }
  @Step("Открытие страницы авторизации")
    public LoginPage openPage(){
        driver.get(LOGIN_PAGE);
        return this;
    }
    @Step("Ожидание загрузки страницы авторизации")
    public LoginPage waitLoadLoginPage(){
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(tittleEnter).getText() != null
                && !driver.findElement(tittleEnter).getText().isEmpty()
        ));
        return this;
    }
    @Step("Ввод почты в поле email")
    public LoginPage setMail(String email){

        driver.findElement(fieldMail).sendKeys(email);
        return this;
    }
    @Step("Ввод пароля в поле пароль")
    public LoginPage setPassword(String password){

        driver.findElement(fieldPassword).sendKeys(password);
        return this;
    }
    @Step("Клик по кнопке Вход")
    public LoginPage clickOnButtonEnter(){

        driver.findElement(buttonEnter).click();
        return this;
    }
    @Step("Клик по ссылке регистрации")
    public LoginPage clickOnLinkRegistration(){

        driver.findElement(linkRegistration).click();
        return this;
    }

    @Step("Авторизация пользователя")
    public LoginPage loginInAccount(String email,String password){
        waitLoadLoginPage();
        setMail(email);
        setPassword(password);
        clickOnButtonEnter();
        return this;
    }

}
