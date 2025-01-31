package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Тест-кейсы для вкладки Главная мобильного приложения Мобильный хоспис.")
public class MainPageTests {
    AuthorizationSteps authStep = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        authStep.appDownload();
        try {
            authStep.loadAuthPage();
        } catch (Exception e) {
            authStep.logOut();
            authStep.loadAuthPage();
        }
        authStep.login(validLogin, validPassword);

    }

    @Story("Переход во вкладку \"News\" через главное меню мобильного приложения")
    @Test
    public void goToTheNewsPage() {

        mainSteps.goToTheNews();
    }

    @Story("Переход во вкладку \"About\" через главное меню мобильного приложения")
    @Test
    public void goToTheAboutPage() {

        mainSteps.goToTheAbout();
    }

    @Story("Переход во вкладку «Цитаты» через главное меню мобильного приложения")
    @Test
    public void goToTheQuotationPage() {
        mainSteps.goToTheQuotation();

    }

}
