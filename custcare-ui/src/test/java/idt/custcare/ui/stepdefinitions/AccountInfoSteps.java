package idt.custcare.ui.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import idt.custcare.ui.portals.custcare.pages.AccountInfoPage;
import org.testng.Assert;

/**
 * Contains steps definition methods for Account Info page.
 */
public class AccountInfoSteps {
    private AccountInfoPage accountInfoPage;

    /**
     * Initializes an instance of {@link AccountInfoSteps}.
     */
    public AccountInfoSteps() {
        accountInfoPage = new AccountInfoPage();
    }

    /**
     * Verifies that Account Info page is displayed.
     */
    @Then("^I should be redirected to Account Info page$")
    public void shouldBeRedirectedToAccountInfoPage() {
        Assert.assertTrue(accountInfoPage.isAccountInfoPage(), "Account Info page is not displayed as expected");
    }

    /**
     * Checks if unlimited link is visible and clickable.
     */
    @Then("^a link under Unlimited/Current plans should be visible and clickable")
    public void aLinkUnderUnlimitedCurrentPlansShouldBeDisplayed() {
        Assert.assertTrue(accountInfoPage.isUnlimitedLinkDisplayed());
    }

    /**
     * Clicks unlimited link.
     */
    @When("^I click unlimited link from Account Info page$")
    public void iClickUnlimitedLinkFromAccountInfoPage() {
        accountInfoPage.clickUnlimitedLink();
    }
}
