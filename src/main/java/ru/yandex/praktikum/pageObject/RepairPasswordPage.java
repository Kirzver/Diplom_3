package ru.yandex.praktikum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.yandex.praktikum.data.Constants.REPAIR_PASSWORD_PAGE;

public class RepairPasswordPage {
    private final WebDriver driver;

    private final By linkEnter = By.xpath(".//a[text()='Войти']");

    private final By titleRepairPassword = By.xpath(".//h2[text()='Восстановление пароля']");

    public RepairPasswordPage(WebDriver driver){

        this.driver = driver;
    }
    @Step("Открытие страницы восстановления пароля")
    public RepairPasswordPage openPage(){
        driver.get(REPAIR_PASSWORD_PAGE);
        return this;
    }
    @Step("Ожидание загрузки страницы восстановления пароля")
    public RepairPasswordPage waitLoadRepairPasswordPage(){
        new WebDriverWait(driver, 3).until(driver -> (driver.findElement(titleRepairPassword).getText() != null
                && !driver.findElement(titleRepairPassword).getText().isEmpty()
        ));
        return this;
    }
    @Step("Клик по надписи Вход")
    public RepairPasswordPage clickOnLinkEnter(){

        driver.findElement(linkEnter).click();
        return this;
    }


}
