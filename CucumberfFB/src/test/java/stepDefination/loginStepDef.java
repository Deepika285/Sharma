package stepDefination;

import org.junit.Assert;

import POMpackage.LandingPagePOM;
import POMpackage.LoginPagePOM;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import facebook.CucumberfFB.Baseclass;



public class loginStepDef extends Baseclass {
	
	  @Given("^Initialize the browser$")
	    public void initialize_the_browser() throws Throwable {
		  driver = initializeBrowser(); 
	    }

	    @When("^User enters (.+) and (.+)$")
	    public void user_enters_and(String username, String password) throws Throwable {
	    	 LoginPagePOM lap = new LoginPagePOM(driver);
		        lap.getUser().sendKeys(username);
		        lap.getPass().sendKeys(password);
		        lap.getClickbutton().click();
	    }

	    @Then("^User will redirect to Home page and acces the track specified courses$")
	    public void user_will_redirect_to_home_page_and_acces_the_track_specified_courses() throws Throwable {
	        
	    }

	    @Then("^User click profile section$")
	    public void user_click_profile_section() throws Throwable {
	        LandingPagePOM la = new LandingPagePOM(driver);
	        la.getClickP().click();
	        String n = la.getClikN().getText();
	        Assert.assertEquals("Vivek Sharma", n);
	    }

	    @And("^User will land to Login page \"([^\"]*)\" and need to input credentials$")
	    public void user_will_land_to_login_page_something_and_need_to_input_credentials(String strArg1) throws Throwable {
	    	driver.get(strArg1);
	    }
}
