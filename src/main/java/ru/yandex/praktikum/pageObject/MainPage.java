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
    private final  By bunsActive = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc') and contains(span/text(),'Булки')]");
    private final  By saucesActive = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc') and contains(span/text(),'Соусы')]");
    private final  By ingredientsActive = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc') and contains(span/text(),'Начинки')]");


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
    @Step("Вкладка \"Булки\" активна")
    public boolean bunsIsDisplayed(){
        return driver.findElement(bunsActive).isDisplayed();
    }
    @Step("Вкладка \"Соусы\" активна")
    public boolean  saucesIsDisplayed(){
        return driver.findElement(saucesActive).isDisplayed();
    }
    @Step("Вкладка \"Начинки\" активна")
    public boolean ingredientsIsDisplayed(){
        return driver.findElement(ingredientsActive).isDisplayed();
    }


}
