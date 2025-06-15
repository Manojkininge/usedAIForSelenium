package stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

    private LoginPage loginPage;
    private AccountsPage accountsPage;

    public AccountsPageSteps() {
        this.loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credTable) {
        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver()
                .get("https://tutorialsninja.com/demo/index.php?route=account/login");
        accountsPage = loginPage.doLogin(userName, password);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = accountsPage.getAccountsPageTitle();
        System.out.println("Accounts Page title is: " + title);
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {
        List<String> expected = sectionsTable.asList().stream()
                .map(String::trim)
                .collect(Collectors.toList());

        List<String> actual = accountsPage.getAccountsSectionsList().stream()
                .map(String::trim)
                .collect(Collectors.toList());

        Assert.assertEquals(
                "Expected size " + expected.size() + " but found " + actual.size(),
                expected.size(),
                actual.size()
        );

        Assert.assertTrue(
                "Actual list has items not in expected",
                expected.containsAll(actual)
        );
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedSectionCount) {
        Assert.assertEquals(
                "Accounts section count mismatch",
                expectedSectionCount.intValue(),
                accountsPage.getAccountsSectionCount()
        );
    }
}