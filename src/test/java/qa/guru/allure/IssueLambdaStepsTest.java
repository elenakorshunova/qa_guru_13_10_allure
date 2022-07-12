package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueLambdaStepsTest extends TestBase {

    @Test
    @DisplayName("Тест с использованием лямбда степов")
    public void testWithLambdaSteps() {
        step("Ищем репозиторий по имени " + repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(repository);
            $(".header-search-input").submit();
        });
        step("В результатах поиска переходим по ссылке репозитория " + repository, () -> {
            $(linkText("selenide/selenide")).click();
        });
        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue c названием " + issueName, () -> {
            $(withText(issueName)).should(Condition.exist);
        });
    }
}