package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUpTest() {
        BaseTest.setup();
        driver = BaseTest.driver;
    }

    @Given("User is on Login Page")
    public void user_is_on_login_page() {
        driver.get("http://testphp.vulnweb.com/login.php"); // Change to your application URL
        loginPage = new LoginPage(driver);
    }

    @When("User enters credentials for {string}")
    public void user_enters_credentials(String testCaseID) {
        String[] testData = ExcelUtils.getTestData(testCaseID);
        if (testData == null) {
            throw new RuntimeException("No test data found for TC_ID: " + testCaseID);
        }
        loginPage.enterUsername(testData[0]);
        loginPage.enterPassword(testData[1]);
    }

    @And("Clicks the login button")
    public void clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // Add assertion for successful login
        System.out.println("Login successful");
    }

    @After
    public void tearDownTest() {
        BaseTest.tearDown();
    }
}
