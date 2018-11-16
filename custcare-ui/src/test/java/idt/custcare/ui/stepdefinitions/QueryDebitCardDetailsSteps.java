package idt.custcare.ui.stepdefinitions;

import cucumber.api.java.en.When;
import idt.custcare.ui.portals.custcare.pages.QueryDebitCardDetailsPage;

/**
 * Contains steps definition methods for Query Debit Card Details page.
 */
public class QueryDebitCardDetailsSteps {
    private QueryDebitCardDetailsPage queryDebitCardDetailsPage;

    /**
     * Initializes an instance of {@link QueryDebitCardDetailsSteps}.
     */
    public QueryDebitCardDetailsSteps() {
        queryDebitCardDetailsPage = new QueryDebitCardDetailsPage();
    }

    /**
     * Query a specified account by control number in Query Debit Card Details page.
     *
     * @param controlNumber the control number of the account.
     */
    @When("^I query an account by control number equal to: (.*)$")
    public void queryAccountByControlNumber(final String controlNumber) {
        queryDebitCardDetailsPage.fillControlNumberField(controlNumber);
        queryDebitCardDetailsPage.clickQueryButton();
    }

    /**
     * Query a specified account by pin in Query Debit Card Details page.
     *
     * @param pin the pin number of the account.
     */
    @When("^I query an account by pin equal to: (.*)$")
    public void queryAccountByPin(final String pin) {
        queryDebitCardDetailsPage.fillPinField(pin);
        queryDebitCardDetailsPage.clickQueryButton();
    }
}
