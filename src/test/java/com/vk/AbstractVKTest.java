package com.vk;

import com.codeborne.selenide.Selenide;
import com.vk.fragment.HeaderFragment;
import com.vk.fragment.TopProfileFragment;
import com.vk.page.LoginPage;
import com.vk.page.MessengerPage;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Optional;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public abstract class AbstractVKTest {

    protected MessengerPage messengerPage = new MessengerPage();
    protected String chatName;

    public AbstractVKTest() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(false)
                                                                         .savePageSource(false));
    }

    @Description("Login to VK")
    @BeforeSuite
    public void login() {
        Selenide.open("https://vk.com/");
        var loginPage = new LoginPage();

        // temporary solution, only for demo
        var login = Optional.ofNullable(System.getenv("VK_LOGIN"))
                            .orElseThrow(() -> new IllegalArgumentException("[VK_LOGIN] Env Variable is missing!"));
        var password = Optional.ofNullable(System.getenv("VK_PASS"))
                               .orElseThrow(() -> new IllegalArgumentException("[VK_PASS] Env Variable is missing!"));

        loginPage.login(login, password);
    }

    @Description("Logout from VK")
    @AfterSuite
    public void logout() {
        var headerFragment = new HeaderFragment();
        headerFragment.expandTopProfileLink();

        var topProfileFragment = new TopProfileFragment();
        topProfileFragment.logout();
    }

}
