package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import ru.yandex.praktikum.pageObject.LoginPage;
import ru.yandex.praktikum.pageObject.MainPage;
import ru.yandex.praktikum.pageObject.PersonalCabinetPage;
import ru.yandex.praktikum.config.BeforeAndAfterBaseClass;

import static org.hamcrest.CoreMatchers.is;
import static ru.yandex.praktikum.data.Constants.*;

public class TransitionTest extends BeforeAndAfterBaseClass {

    @Test
    @DisplayName("Переход по клику на кнопку \"Личный кабинет\"")
    @Description("Успешная загрузка личного кабинета после перехода с главной страницы")
    public void goToPersonalCabinetTest() {
        userClient.createUser(user);

        new LoginPage(getDriver())
                .openPage()
                .loginInAccount(user.getEmail(), user.getPassword());

        new MainPage(getDriver())
                .waitLoadTitle()
                .clickOnButtonPersonalCabinet();

        new PersonalCabinetPage(getDriver())
                .waitLoadTextProfile();

        Assert.assertThat(getDriver().getCurrentUrl(),
                is(PROFILE_PAGE));
    }

    @Test
    @DisplayName("Переход по клику на кнопку \"Конструктор\"")
    @Description("Успешная загрузка главной страницы после клика на кнопку \"Конструктор\" в личном кабинете")
    public void goToMainPageOnClickButtonConstructorTest() {
        userClient.createUser(user);

        new LoginPage(getDriver())
                .openPage()
                .loginInAccount(user.getEmail(), user.getPassword());

        new MainPage(getDriver())
                .waitLoadTitle()
                .clickOnButtonPersonalCabinet();

        new PersonalCabinetPage(getDriver())
                .waitLoadTextProfile()
                .clickOnButtonConstructor();

        new MainPage(getDriver())
                .waitLoadTitle();

        Assert.assertThat(getDriver().getCurrentUrl(),
                is(MAIN_PAGE));
    }

    @Test
    @DisplayName("Переход по клику на логотип \"Stellar Burger\"")
    @Description("Успешная загрузка главной страницы после клика на логотип \"Stellar Burger\" в личном кабинете")
    public void goToMainPageOnClickLogoTest() {
        userClient.createUser(user);

        new LoginPage(getDriver())
                .openPage()
                .loginInAccount(user.getEmail(), user.getPassword());

        new MainPage(getDriver())
                .waitLoadTitle()
                .clickOnButtonPersonalCabinet();

        new PersonalCabinetPage(getDriver())
                .waitLoadTextProfile()
                .clickOnLogo();

        new MainPage(getDriver())
                .waitLoadTitle();

        Assert.assertThat(getDriver().getCurrentUrl(),
                is(MAIN_PAGE));
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Выход из аккаунта по кнопке \"Выйти\" в личном кабинете")
    public void exitFromPersonalCabinetOnClickExitButtonTest() {
        userClient.createUser(user);

        new LoginPage(getDriver())
                .openPage()
                .loginInAccount(user.getEmail(), user.getPassword());

        new MainPage(getDriver())
                .waitLoadTitle()
                .clickOnButtonPersonalCabinet();

        new PersonalCabinetPage(getDriver())
                .waitLoadTextProfile()
                .clickOnButtonExit();

        new LoginPage(getDriver())
                .waitLoadLoginPage();

        Assert.assertThat(getDriver().getCurrentUrl(),
                is(LOGIN_PAGE));
    }
}
