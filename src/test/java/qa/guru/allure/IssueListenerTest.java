package qa.guru.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class IssueListenerTest extends TestBase {

    @Test
    @DisplayName("Тест с использованием Listener")
    public void testWithListener() {
        $(".header-search-input").click();
        $(".header-search-input").setValue("selenide/selenide");
        $(".header-search-input").submit();
        $(linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(byPartialLinkText("User can enable text report for ALL tests (in TestNG)"))
                .shouldBe(visible);
    }
}