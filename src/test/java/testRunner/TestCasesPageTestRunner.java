package testRunner;

import org.testng.annotations.Test;
import pages.TestCasesPage;
import setup.BaseSetup;

public class TestCasesPageTestRunner extends BaseSetup {

    TestCasesPage testCases;

    @Test(priority = 1, description = "Test Case 7: Verify Test Cases Page")
    public void verifyTestCasesPage(){
        testCases = new TestCasesPage(driver);
        testCases.verifyTestCases();
    }
}