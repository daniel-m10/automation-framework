package idt.custcare.ui.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import idt.custcare.ui.portals.custcare.pages.UnlimitedCallingPage;
import idt.custcare.ui.utils.constants.SelectBy;
import org.testng.Assert;

/**
 * Contains steps definition methods for Unlimited Calling page.
 */
public class UnlimitedCallingSteps {
    private UnlimitedCallingPage unlimitedCallingPage;

    /**
     * Initializes an instance of {@link UnlimitedCallingSteps}.
     */
    public UnlimitedCallingSteps() {
        unlimitedCallingPage = new UnlimitedCallingPage();
    }

    /**
     * Checks if a expected title appears on page.
     *
     * @param expectedMessage as String.
     */
    @Then("^I expect (.*) text appears on Unlimited Calling page")
    public void iExpectTextAppearsOnUnlimitedCallingPage(final String expectedMessage) {
        Assert.assertEquals(unlimitedCallingPage.getPageTitle(), expectedMessage);
    }

    /**
     * Checks if a expected message or text appears on page.
     *
     * @param element         as String.
     * @param expectedMessage as String.
     */
    @And("^I expect (.*) text appears on page as (.*)$")
    public void iExpectTextAppearsOnUnlimitedCallingPageAs(final String element, final String expectedMessage) {
        Assert.assertEquals(unlimitedCallingPage.getTextFromElement(element), expectedMessage);
    }

    /**
     * Selects a language from drop down list.
     *
     * @param language as String.
     * @param selectBy as SelectBy type.
     */
    @When("^I select (.*) (.*) form message language preference$")
    public void iSelectFrommMessageLanguagePreference(final String language, final SelectBy selectBy) {
        unlimitedCallingPage.chooseLanguage(selectBy, language);
    }

    /**
     * Completes redeem transaction.
     *
     * @param activationCode as String.
     */
    @And("^I select (.*) for Activation code and I click on Redeem$")
    public void iSelectForActivationCodeAndIClickOnRedeem(final String activationCode) {
        unlimitedCallingPage.redeemActivationCode(activationCode);
    }

    /**
     * Checks if the message obtained from alert match with the expected one.
     *
     * @param expectedMessage as String.
     */
    @Then("^I should get the message (.*)$")
    public void iShouldGetTheMessageDoWantToRedeemThisCode(final String expectedMessage) {
        Assert.assertEquals(unlimitedCallingPage.getAlertMessage(), expectedMessage);
    }

    /**
     * Checks that a expected text exists.
     *
     * @param expectedMessage as String.
     */
    @And("^the text (.*) should exist$")
    public void afterConfirmTransactionTheTextShouldExist(final String expectedMessage) {
        Assert.assertTrue(unlimitedCallingPage.getRequestSuccessMessage().contains(expectedMessage));
    }

    /**
     * Checks if a link/button is visible and clickable on page.
     *
     * @param buttonName as String.
     */
    @And("^(.*) (?:button|link) should be visible and clickable$")
    public void buttonShouldBeVisibleAndClickable(final String buttonName) {
        Assert.assertTrue(unlimitedCallingPage.isElementVisibleAndClickable(buttonName));
    }

    /**
     * Checks that a button exist a certain number of times on page.
     *
     * @param quantity as int.
     * @param button   as String.
     */
    @And("^there exist (\\d+) (.*) buttons?$")
    public void thereExistBuyButtons(final int quantity, final String button) {
        Assert.assertEquals(unlimitedCallingPage.getListOfButtons(button).size(), quantity);
    }

    /**
     * Clicks a button located on Unlimited Calling Plans page.
     *
     * @param buttonName as String.
     */
    @And("^I click (.*) button on Unlimited Calling Plans$")
    public void iClickButtonOnUnlimitedCallingPlans(final String buttonName) {
        unlimitedCallingPage.clickButtonOnPage(buttonName);
    }

    /**
     * Checks if expected error message appears on page.
     *
     * @param expectedMessage as String.
     */
    @Then("^the error message (.*) should be displayed on page$")
    public void theErrorMessageShouldBeDisplayedOnPage(final String expectedMessage) {
        Assert.assertEquals(unlimitedCallingPage.getErrorMessage(), expectedMessage);
    }
}
