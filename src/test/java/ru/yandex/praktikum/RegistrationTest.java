package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.pageObject.LoginPage;
import ru.yandex.praktikum.pageObject.MainPage;
import ru.yandex.praktikum.pageObject.PersonalCabinetPage;
import ru.yandex.praktikum.pageObject.RegistrationPage;
import ru.yandex.praktikum.config.BeforeAndAfterBaseClass;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.data.Constants.PROFILE_PAGE;

public class RegistrationTest extends BeforeAndAfterBaseClass {

    @Test
    @DisplayName("Регистрация нового пользователя с корректными данными")
    @Description("Переход в личный кабинет после успешной регистрации")
    public void successRegistrationTest() {
        new MainPage(getDriver())
                .openPage()
                .waitLoadTitle()
                .clickOnButtonLoginAccount();

        new LoginPage(getDriver())
                .waitLoadLoginPage()
                .clickOnLinkRegistration();

        new RegistrationPage(getDriver())
                .registration(user.getName(), user.getEmail(), user.getPassword());

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
    @DisplayName("Регистрация нового пользователя с паролем меньше 6-ти символов")
    @Description("Появление надписи \"Некорректный пароль\" под полем \"Пароль\"")
    public void setWrongPasswordRegistrationTest() {
        new MainPage(getDriver())
                .openPage()
                .waitLoadTitle()
                .clickOnButtonLoginAccount();

        new LoginPage(getDriver())
                .waitLoadLoginPage()
                .clickOnLinkRegistration();

        boolean wrongPasswordTextAndVisible = new RegistrationPage(getDriver())
                .registration(user.getName(), user.getPassword(), "111")
                .checkIncorrectPasswordTextAndVisible();

        assertTrue(wrongPasswordTextAndVisible);
    }
}
