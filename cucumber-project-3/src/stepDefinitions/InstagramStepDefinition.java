package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InstagramStepDefinition {


	@Given("^the user launches login Page of Instagram$")
	public void the_user_launches_login_page_of_instagram() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("the user launches login Page of Instagram");
	}
	@When("^the user is redirected to login page$")
	public void the_user_is_redirected_to_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("the user is redirected to login page");
	}
	@When("^the user provides username as ([^\"]*)$")
	public void the_user_provides_username_as_hari(String user) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("the user provides username as "+user);
	}
	@When("^the user provides the password as ([^\"]*)$")
	public void the_user_provides_the_password_as_hari(String pass) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("the user provides the password as "+pass);
	}
	@When("^the user clicks on login button$")
	public void the_user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	  System.out.println("the user clicks on login button");
	}
	@Then("^the user should be redirected to home page of Instagram$")
	public void the_user_should_be_redirected_to_home_page_of_instagram() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("the user should be redirected to home page of Instagram");
	}
	@Then("^the user sees their home page of Instagram$")
	public void the_user_sees_their_home_page_of_instagram() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("the user sees their home page of Instagram");
	}



}
