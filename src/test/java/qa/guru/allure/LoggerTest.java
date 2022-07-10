package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LoggerTest {

    private Logger logger = new Logger();

    @Test
    public void testGithubIssueSearch() {
        open("https://github.com");
        logger.info("Открыли страницу");

        searchForRepository("eroshenkoam/allure-example");
        logger.info("Нажали на кнопку");

        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#76")).should(Condition.exist);
    }

    private void searchForRepository(String repository) {
        $(".header-search-input").click();
        logger.info("Нажали на кнопку");

        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
        logger.info("Нажали на кнопку");
    }

}

