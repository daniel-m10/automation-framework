package idt.custcare.ui.portals.custcare.pages;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.utils.CommonActions;
import idt.custcare.ui.utils.constants.SearchBy;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Billing History page.
 */
public class BillingHistoryPage extends BasePage {
    private static final String COMMA = ",";
    private static final String TYPE_OF_TRANSACTION_LOCATOR = "a[title='Type of Transaction']";
    private static final String RIGHT_SIDE_MENU = "rightSideMenuId";
    private static final String TRANSACTION_TABLE = "ccDataDiv";

    @FindBy(xpath = "//span[@class='pageHeading'][contains(text(),'Billing History')]")
    private WebElement lblPageTitle;

    @FindBy(id = "detailsTableId")
    private WebElement tblTransactions;

    @FindBy(id = "rightSideMenuControlId")
    private WebElement btnHistoryDisplayOptions;

    @FindBy(id = "fromDate")
    private WebElement txtFromDate;

    @FindBy(id = "toDate")
    private WebElement txtToDate;

    @FindBy(css = "input[class='formButton']")
    private WebElement btnQueryButton;

    @FindBy(id = "loadingImg")
    private WebElement imgLoadingImage;

    @FindBy(css = ".summary.transaction .tdDataRight.fDate")
    private WebElement txtActualTransaction;

    @FindBy(css = "tr:nth-child(8) > td:nth-child(2)")
    private WebElement txtHardCardPin;

    @FindBy(css = "tr:nth-child(9) > td:nth-child(2)")
    private WebElement txtHardCardClassId;

    @FindBy(css = "tr:nth-child(10) > td:nth-child(2)")
    private WebElement txtHardCardControlNumber;

    /**
     * Verifies if page is displayed.
     *
     * @return true if Account Info page is displayed.
     */
    public boolean isPageTitleDisplayed() {
        return CommonActions.isElementDisplayed(lblPageTitle);
    }

    /**
     * Verifies if Transactions section is displayed and it contains records.
     *
     * @return true if Transactions section is displayed with records.
     */
    public boolean isTransactionSectionAndRecordDisplayed() {
        int records = tblTransactions.findElements(By.tagName("tbody")).size();
        return CommonActions.isElementDisplayed(tblTransactions) && records > 0;
    }

    /**
     * Displays History options.
     */
    public void clickOnDisplayOptions() {
        CommonActions.clickElementByJavascript(btnHistoryDisplayOptions);
    }

    /**
     * Verifies that only correct checkboxes get checked.
     *
     * @param checkBoxes as String.
     */
    public void unsetImproperCheckBoxes(final String checkBoxes) {
        CommonActions.waitUntilElementIsDisplayed(SearchBy.ID, RIGHT_SIDE_MENU);
        String[] options = checkBoxes.split(COMMA);
        for (String option : options) {
            WebElement checkBox = checkBoxesId(option);
            if (option.matches("(RAW DATA|COMMENTS)") && CommonActions.isElementSelected(checkBox)) {
                CommonActions.clickElementByJavascript(checkBox);
            }
        }
    }

    /**
     * Sets date an amount of months back.
     *
     * @param months as int.
     */
    public void putMonthBack(final int months) {
        String fromDate = CommonActions.getTextByJavaScript(txtFromDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String oneMonthBack = LocalDate.parse(fromDate, formatter).minusMonths(months).format(formatter);
        CommonActions.deleteTextUsingKeys(txtFromDate);
        CommonActions.setInputField(txtFromDate, oneMonthBack);
        CommonActions.clickElementByJavascript(btnQueryButton);
    }

    /**
     * Puts a date field with the current date.
     */
    public void putCurrentDate() {
        String toDate = CommonActions.getTextByJavaScript(txtToDate);
        CommonActions.deleteTextUsingKeys(txtFromDate);
        CommonActions.setInputField(txtFromDate, toDate);
        CommonActions.clickElementByJavascript(btnQueryButton);
    }

    /**
     * Clicks record display on page.
     */
    public void clickRecordDisplayedOnPage() {
        CommonActions.waitFor(1);
        CommonActions.clickElement(txtActualTransaction);
    }

    /**
     * Checks that transaction types are displayed with correct value and amount.
     *
     * @param amountTypeOne as String.
     * @param amountTypeTwo as String.
     * @param typeOneValue  as int.
     * @param typeTwoValue  as int.
     * @return true if transaction types are displayed correctly, false otherwise.
     */
    public boolean areTransactionsMatchWithExpectedTypes(final String typeOneValue, final int amountTypeOne,
                                                         final String typeTwoValue, final int amountTypeTwo) {
        CommonActions.waitFor(2);
        return areTransactionsTypesTheCorrectOnes(amountTypeOne, typeOneValue)
                && areTransactionsTypesTheCorrectOnes(amountTypeTwo, typeTwoValue);
    }

    /**
     * Checks that transactions are displayed correctly on table.
     *
     * @param amountOfTransactions as int.
     * @param transactionValue     as String.
     * @return true if transactions have the correct value and size, false otherwise.
     */
    public boolean areTransactionsTypesTheCorrectOnes(final int amountOfTransactions, final String transactionValue) {
        CommonActions.waitFor(2);
        return CommonActions.findElementsBy(SearchBy.CSS, TYPE_OF_TRANSACTION_LOCATOR)
                .stream().map(WebElement::getText)
                .filter(value -> value.equalsIgnoreCase(transactionValue)).count() == amountOfTransactions;
    }

    /**
     * Checks that Hard Values are displayed on emerging window.
     *
     * @return true if values are displayed, false otherwise.
     */
    public boolean areHardValuesExists() {
        List<String> hardCardValues = new ArrayList<>();
        List<String> handles = CommonActions.getWindowHandles();
        String parentHandle = handles.get(0);
        String transactionHandle = handles.get(1);
        CommonActions.switchWindow(transactionHandle);
        CommonActions.waitUntilElementIsDisplayed(SearchBy.ID, TRANSACTION_TABLE);
        hardCardValues.add(CommonActions.getTextElement(txtHardCardClassId));
        hardCardValues.add(CommonActions.getTextElement(txtHardCardControlNumber));
        hardCardValues.add(CommonActions.getTextElement(txtHardCardPin));
        CommonActions.closeWindowDriver();
        CommonActions.switchWindow(parentHandle);
        return hardCardValues.stream().noneMatch(String::isEmpty);
    }

    /**
     * Gets checkbox id from History options.
     *
     * @param checkBoxName as String.
     * @return checkbox id locator.
     */
    private WebElement checkBoxesId(final String checkBoxName) {
        Map<String, String> checkBoxes = new HashMap<>();
        String checkBoxId = "%sCheckBoxId";
        checkBoxes.put("CALL HISTORY", "calldetail");
        checkBoxes.put("CREDITS", "credit");
        checkBoxes.put("PAYMENT HISTORY", "creditcard");
        checkBoxes.put("DEBITS", "debit");
        checkBoxes.put("PROMOTIONS", "promo");
        checkBoxes.put("CHARGES", "charge");
        checkBoxes.put("ROPP HISTORY", "roppcall");
        checkBoxes.put("DATA USAGE", "data");
        checkBoxes.put("SMS", "sms");
        checkBoxes.put("TRANSACTIONS", "transaction");
        checkBoxes.put("EVENTS", "event");
        checkBoxes.put("COMMENTS", "comment");
        checkBoxes.put("RAW DATA", "rawDataId");
        checkBoxes.put("SHOW ALL", "allRecordsId");
        String partialLocator = checkBoxes.get(checkBoxName.toUpperCase());
        return checkBoxName.toLowerCase().matches("raw data|show all")
                ? CommonActions.findElementBy(SearchBy.ID, partialLocator)
                : CommonActions.findElementBy(SearchBy.ID, String.format(checkBoxId, partialLocator));
    }
}
