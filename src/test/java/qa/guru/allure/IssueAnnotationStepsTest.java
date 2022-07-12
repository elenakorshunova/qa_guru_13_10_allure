package qa.guru.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssueAnnotationStepsTest extends TestBase {

    @Test
    @DisplayName("Тест с использованием степов с аннотациями")
    public void testAnnotatedSteps() {
        IssueWebSteps steps = new IssueWebSteps();
        steps.searchForRepository(repository);
        steps.openRepositoryLink(repository);
        steps.openIssueTab();
        steps.shouldSeeIssueWithName(issueName);
        steps.takeScreenshot();
    }

    @Test
    @DisplayName("Ошибочный тест с использованием степов с аннотациями")
    public void testWithError() {
        IssueWebSteps steps = new IssueWebSteps();
        steps.searchForRepository(repository);
        steps.openRepositoryLink(issueName);
        steps.openIssueTab();
        steps.shouldSeeIssueWithName(issueName);
        steps.takeScreenshot();
    }
}
