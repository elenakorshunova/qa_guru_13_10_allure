package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    public final String repository = "selenide/selenide";
    public final String issueName = "User can enable text report for ALL tests (in TestNG)";

    @BeforeEach
    public void beforeEachTest() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        open("https://github.com/");
    }

    @AfterEach
    public void afterEachTest() {
        closeWebDriver();
    }

}
