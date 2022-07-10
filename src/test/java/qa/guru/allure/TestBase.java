package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void beforeAllTests() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        open("https://github.com/");
    }

    public final String REPOSITORY = "selenide/selenide";
    public final String ISSUE_NAME = "User can enable text report for ALL tests (in TestNG)";
}
