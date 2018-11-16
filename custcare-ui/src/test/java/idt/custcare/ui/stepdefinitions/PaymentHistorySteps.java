package idt.custcare.ui.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import idt.custcare.ui.portals.custcare.pages.PaymentHistoryPage;
import idt.custcare.ui.utils.CommonActions;
import java.util.List;
import org.testng.Assert;

/**
 * Contains steps definition methods for Payment History page.
 */
public class PaymentHistorySteps {
    private PaymentHistoryPage paymentHistoryPage;
    private String refundMessage;

    /**
     * Initializes an instance of {@link PaymentHistorySteps}.
     */
    public PaymentHistorySteps() {
        paymentHistoryPage = new PaymentHistoryPage();
    }

    /**
     * Checks that all transactions are displayed correctly.
     *
     * @param columnName    as String.
     * @param expectedValue as String.
     */
    @Then("^all transactions should be displayed with (.*) type (.*) on Payment History page$")
    public void allTransactionsShouldBeDisplayedWithType(final String columnName, final String expectedValue) {
        List<String> transactionValues = paymentHistoryPage.getColumnValues(columnName);
        Assert.assertTrue(paymentHistoryPage.areValuesMatchWithExpectedOne(transactionValues, expectedValue));
    }

    /**
     * Clicks on first element on table.
     */
    @And("^I click first element on table$")
    public void iClickFirstElementOnTable() {
        paymentHistoryPage.clickFirstElementOnTable();
    }

    /**
     * Completes refund transaction.
     */
    @And("^I complete refund transaction on the window displayed$")
    public void iCompleteRefundTransactionOnWindowDisplayed() {
        refundMessage = paymentHistoryPage.completeRefundTransaction();
    }

    /**
     * Checks if message match with a expected one.
     *
     * @param expectedMessage as String.
     */
    @Then("^I expect to get message \"([^\"]*)\"$")
    public void iExpectToGetMessage(final String expectedMessage) {
        Assert.assertTrue(refundMessage.contains(expectedMessage));
    }

    /**
     * Checks that all transactions in Payment History.
     *
     * @param amountTypeOne as int.
     * @param typeOneValue  as String.
     * @param amountTypeTwo as int.
     * @param typeTwoValue  as String.
     */
    @And("^there exist (\\d+) transactions displayed on page with type as (.*) and (\\d+) as (.*) on Payment History "
            + "page$")
    public void thereExistTransactionsDisplayedOnPageWithTypeAsSaleAndAsRefundOnPaymentHistoryPage(
            final int amountTypeOne, final String typeOneValue,
            final int amountTypeTwo, final String typeTwoValue) {
        CommonActions.waitFor(1);
        Assert.assertTrue(paymentHistoryPage.areTransactionsMatchWithExpectedTypes(typeOneValue, amountTypeOne,
                typeTwoValue, amountTypeTwo));
    }
}
