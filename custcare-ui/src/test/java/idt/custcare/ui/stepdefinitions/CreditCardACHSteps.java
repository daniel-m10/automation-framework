package idt.custcare.ui.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import idt.custcare.ui.portals.custcare.pages.CreditCardACHPage;
import idt.custcare.ui.utils.CommonActions;
import org.testng.Assert;

/**
 * Contains steps definition methods for Credit Card ACH page.
 */
public class CreditCardACHSteps {
    private CreditCardACHPage creditCardACHPage;

    /**
     * Initializes an instance of {@link CreditCardACHSteps}.
     */
    public CreditCardACHSteps() {
        creditCardACHPage = new CreditCardACHPage();
    }

    /**
     * Completes a transaction.
     *
     * @param buttonName as String.
     */
    @And("^I complete (.*) transaction$")
    public void iClickOnButton(final String buttonName) {
        creditCardACHPage.clickOnButton(buttonName);
        CommonActions.acceptAlert();
    }

    /**
     * Checks a message obtained with an expected one.
     *
     * @param expectedMessage as String.
     */
    @Then("^I expect to get message: (.*)$")
    public void iExpectToGetMessageTransactionCompletedSuccessfully(final String expectedMessage) {
        String messageType = expectedMessage.toLowerCase().contains("successfully") ? "success" : "error";
        String actualMessage = creditCardACHPage.getTransactionMessage(messageType);
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
