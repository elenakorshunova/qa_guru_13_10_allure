package qa.guru.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssueAnnotationStepsTest extends TestBase {

    @Test
    @DisplayName("Тест с использованием степов с аннотациями")
    public void testAnnotatedSteps() {
        IssueWebSteps steps = new IssueWebSteps();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
        steps.takeScreenshot();
    }

    @Test
    @DisplayName("Ошибочный тест с использованием степов с аннотациями")
    public void testWithError() {
        IssueWebSteps steps = new IssueWebSteps();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryLink(ISSUE_NAME);
        steps.openIssueTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
        steps.takeScreenshot();
    }
}
