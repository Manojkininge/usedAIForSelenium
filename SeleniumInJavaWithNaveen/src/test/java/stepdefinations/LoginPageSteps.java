package stepdefinations;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		
		DriverFactory.getDriver()
		.get("https://tutorialsninja.com/demo/");
		Thread.sleep(3000);
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() throws InterruptedException {
		title = loginPage.getLoginPageTitle();
		Thread.sleep(3000);
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		
			Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	  
	}

	@When("user enters email {string}")
	public void user_enters_email(String email) {
		loginPage.enterUserName(email);
	
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	@Then("user gets the title of the account page")
	public void user_gets_the_title_of_the_account_page() throws InterruptedException {
		title = loginPage.getLoginPageTitle();
		Thread.sleep(3000);
		System.out.println("Page title is: " + title);
	}

}
