package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.pageObject.MainPage;
import ru.yandex.praktikum.config.BeforeAndAfterBaseClass;


public class ConstructorBurgerTest extends BeforeAndAfterBaseClass {

    @Test
    @DisplayName("Переход к разделу \"Булки\"")
    @Description("Переход к разделу \"Булки\" на главной странице при клике на кнопку \"Булки\"")
    public void menuBunsIsActiveAfterClickButtonBunsTest() {
        boolean bunsIsDisplayed = new MainPage(getDriver())
                .openPage()
                .waitLoadTitle()
                .clickOnTabonSauces()
                .clickOnTabBuns()
                .textBunsIsDisplayed();

        Assert.assertTrue(bunsIsDisplayed);
    }

    @Test
    @DisplayName("Переход к разделу \"Соусы\"")
    @Description("Переход к разделу \"Соусы\" на главной странице при клике на кнопку \"Соусы\"")
    public void menuSaucesIsActiveAfterClickButtonSaucesTest() {
        boolean saucesIsDisplayed = new MainPage(getDriver())
                .openPage()
                .waitLoadTitle()
                .clickOnTabonSauces()
                .textSaucesIsDisplayed();

        Assert.assertTrue(saucesIsDisplayed);
    }

    @Test
    @DisplayName("Переход к разделу \"Начинки\"")
    @Description("Переход к разделу \"Начинки\" на главной странице при клике на кнопку \"Начинки\"")
    public void menuIngredientsIsActiveAfterClickButtonIngredientsTest() {
        boolean ingredientsIsDisplayed = new MainPage(getDriver())
                .openPage()
                .waitLoadTitle()
                .clickOnTabIngredients()
                .textIngredientsIsDisplayed();

        Assert.assertTrue(ingredientsIsDisplayed);
    }


}
