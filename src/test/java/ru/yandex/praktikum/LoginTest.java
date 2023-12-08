package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.pageObject.*;
import ru.yandex.praktikum.config.BeforeAndAfterBaseClass;

import static org.hamcrest.CoreMatchers.is;
import static ru.yandex.praktikum.data.Constants.PROFILE_PAGE;

public class LoginTest extends BeforeAndAfterBaseClass {

    @Test
    @DisplayName("Вход пользователя в аккаунт по кнопке \"Войти в аккаунт\"")
    @Description("Переход в личный кабинет после успешного входа в аккаунт по кнопке \"Войти в аккаунт\"")
    public void enterByClickButtonEnterAccountTest() {
        userClient.createUser(user);
        new MainPage(getDriver())
                .openPage()
                .waitLoadTitle()
                .clickOnButtonLoginAccount();

        new LoginPage(getDriver())
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
    @DisplayName("Вход пользователя в аккаунт по кнопке \"Личный кабинет\"")
    @Description("Переход в личный кабинет после успешного входа в аккаунт по кнопке \"Личный кабинет\"")
    public void enterByClickButtonPersonalCabinetTest() {
        userClient.createUser(user);
        new MainPage(getDriver())
                .openPage()
                .waitLoadTitle()
                .clickOnButtonPersonalCabinet();

        new LoginPage(getDriver())
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
    @DisplayName("Вход пользователя в аккаунт  по кнопке \"Войти\" на форме регистрации")
    @Description("Переход в личный кабинет после успешного входа в аккаунт по кнопке \"Войти\" на форме регистрации")
    public void enterByClickLinkEnterOnRegisterFormTest() {
        userClient.createUser(user);
        new RegistrationPage(getDriver())
                .openPage()
                .waitLoadRegistrationPage()
                .clickOnLinkEnter();

        new LoginPage(getDriver())
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
    @DisplayName("Вход пользователя в аккаунт  по кнопке \"Войти\" на форме восстановления пароля")
    @Description("Переход в личный кабинет после успешного входа в аккаунт по кнопке \"Войти\" " +
            "на форме восстановления пароля")
    public void enterByClickLinkEnterOnRepairPasswordFormTest() {
        userClient.createUser(user);
        new RepairPasswordPage(getDriver())
                .openPage()
                .waitLoadRepairPasswordPage()
                .clickOnLinkEnter();

        new LoginPage(getDriver())
                .loginInAccount(user.getEmail(), user.getPassword());

        new MainPage(getDriver())
                .waitLoadTitle()
                .clickOnButtonPersonalCabinet();

        new PersonalCabinetPage(getDriver())
                .waitLoadTextProfile();

        Assert.assertThat(getDriver().getCurrentUrl(),
                is(PROFILE_PAGE));
    }
}
