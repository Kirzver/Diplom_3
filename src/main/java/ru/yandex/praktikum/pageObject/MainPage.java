package ru.yandex.praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.yandex.praktikum.data.Constants.MAIN_PAGE;

public class MainPage {

    private final WebDriver driver;
    private final By mainTitle = By.xpath(".//h1[text()='Соберите бургер']");
    private final By buttonPersonalCabinet = By.xpath(".//p[text()='Личный Кабинет']");
    private final By buttonLoginAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private final  By tabBuns = By.xpath(".//span[text()='Булки']");
    private final  By tabSauces = By.xpath(".//span[text()='Соусы']");
    private final  By tabIngredients = By.xpath(".//span[text()='Начинки']");
    private final  By textBuns = By.xpath(".//h2[text()='Булки']");
    private final  By textSauces = By.xpath(".//h2[text()='Соусы']");
    private final  By textIngredients = By.xpath(".//h2[text()='Начинки']");


    public MainPage(WebDriver driver){

        this.driver = driver;
    }
    @Step("Открытие главной страницы")
    public MainPage openPage(){
        driver.get(MAIN_PAGE);
        return this;
    }
    @Step("Ожидание загрузки главной страницы")
    public MainPage waitLoadTitle(){
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(mainTitle).getText() != null
                && !driver.findElement(mainTitle).getText().isEmpty()
        ));
        return this;
    }
    @Step("Клик по кнопке Личный кабинет")
    public MainPage clickOnButtonPersonalCabinet(){
        driver.findElement(buttonPersonalCabinet).click();
        return this;
    }
    @Step("Клик по кнопке Войти в аккаунт")
    public MainPage clickOnButtonLoginAccount(){
        driver.findElement(buttonLoginAccount).click();
        return this;
    }
    @Step("Клик по вкладке Булки")
    public MainPage clickOnTabBuns(){
        driver.findElement(tabBuns).click();
        return this;
    }
    @Step("Клик по вкладке Соусы")
    public MainPage clickOnTabonSauces(){
        driver.findElement(tabSauces).click();
        return this;
    }
    @Step("Клик по вкладке Начинки")
    public MainPage clickOnTabIngredients(){
        driver.findElement(tabIngredients).click();
        return this;
    }
    @Step("Отображение на экране текста Булки")
    public boolean textBunsIsDisplayed(){
        return driver.findElement(textBuns).isDisplayed();

    }
    @Step("Отображение на экране текста Соусы")
    public boolean  textSaucesIsDisplayed(){
        return driver.findElement(textSauces).isDisplayed();

    }
    @Step("Отображение на экране текста Начинки")
    public boolean textIngredientsIsDisplayed(){
        return driver.findElement(textIngredients).isDisplayed();

    }


}
