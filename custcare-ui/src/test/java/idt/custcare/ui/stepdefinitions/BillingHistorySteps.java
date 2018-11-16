package idt.custcare.ui.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.portals.custcare.pages.BillingHistoryPage;
import org.testng.Assert;

/**
 * Contains steps definition methods for Billing History page.
 */
public class BillingHistorySteps {
    private BillingHistoryPage billingHistoryPage;

    /**
     * Initializes an instance of {@link BillingHistorySteps}.
     */
    public BillingHistorySteps() {
        billingHistoryPage = new BillingHistoryPage();
    }

    /**
     * Verifies that Billing History page is displayed.
     */
    @Then("^Billing History page should be displayed with transaction records$")
    public void billingHistoryPageShouldBeDisplayedWithTransactionRecords() {
        Assert.assertTrue(billingHistoryPage.isPageTitleDisplayed(), "Page title: Billing History is not displayed");
        Assert.assertTrue(billingHistoryPage.isTransactionSectionAndRecordDisplayed(),
                "Records are not displayed in Transactions section");
    }

    /**
     * Ensures that some checkboxes are unchecked.
     *
     * @param checkBoxes as String.
     */
    @And("^make sure that all check boxes are checked except (.*)$")
    public void makeSureThatAllCheckBoxesAreCheckedExceptAnd(final String checkBoxes) {
        BasePage.reachBottomPage();
        billingHistoryPage.clickOnDisplayOptions();
        billingHistoryPage.unsetImproperCheckBoxes(checkBoxes);
    }

    /**
     * Puts a date an amount of months back.
     *
     * @param months as int.
     */
    @And("^I put (\\d+) month back in from date for Get billing records$")
    public void iPutMonthBackInFromDateForGetBillingRecords(final int months) {
        billingHistoryPage.putMonthBack(months);
    }

    /**
     * Checks that transactions displayed on page have the correct types.
     *
     * @param amountTypeOne as int.
     * @param typeTwoValue  as String.
     * @param amountTypeTwo as int.
     * @param typeOneValue  as String.
     */
    @Then("^there exist (\\d+) transactions displayed on page with type as (.*) and (\\d+) as (.*) "
            + "on Billing History page$")
    public void thereExistOneExtraTransactionDisplayedOnPage(final int amountTypeOne, final String typeOneValue,
                                                             final int amountTypeTwo, final String typeTwoValue) {
        Assert.assertTrue(billingHistoryPage.areTransactionsMatchWithExpectedTypes(typeOneValue, amountTypeOne,
                typeTwoValue, amountTypeTwo));
    }

    /**
     * Checks transactions are correctly displayed on window.
     *
     * @param amountOfTransactions as int.
     * @param transactionValue     as String.
     */
    @Then("^(\\d+) transaction should be displayed with type as (.*) on Billing History page$")
    public void transactionShouldBeDisplayedWithTypeAsSale(final int amountOfTransactions,
                                                           final String transactionValue) {
        Assert.assertTrue(billingHistoryPage.areTransactionsTypesTheCorrectOnes(amountOfTransactions,
                transactionValue));
    }

    /**
     * Puts date field with current date.
     */
    @And("^I put current in from date for Get billing records$")
    public void iPutCurrentInFromDateForGetBillingRecords() {
        billingHistoryPage.putCurrentDate();
    }

    /**
     * Clicks last record on page.
     */
    @And("^I click record displayed on page$")
    public void iClickFirstRecordDisplayedOnPage() {
        billingHistoryPage.clickRecordDisplayedOnPage();
    }

    /**
     * Checks all Hard Card values exist.
     */
    @Then("^I expect that all Hard Card values exist$")
    public void iExpectThatAllHardCardValuesExist() {
        Assert.assertTrue(billingHistoryPage.areHardValuesExists());
    }
}
