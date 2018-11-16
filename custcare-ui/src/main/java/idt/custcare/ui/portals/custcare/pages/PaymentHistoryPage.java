package idt.custcare.ui.portals.custcare.pages;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.utils.CommonActions;
import idt.custcare.ui.utils.constants.SearchBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Payment History page.
 */
public class PaymentHistoryPage extends BasePage {

    private static final String CELLS_LOCATOR = "#table_data > tbody > tr:nth-child(%s) > td:nth-child(%s)";
    private static final String TABLE_LOCATOR = "#table_data > tbody > tr";
    private static final String TEXT_LOCATOR = ".tdDataRight";

    @FindBy(css = "input[value='Refund']")
    private WebElement btnRefund;

    @FindBy(css = "b > li")
    private WebElement txtRefundMessage;

    /**
     * Initializes an instance of {@link PaymentHistoryPage}.
     */
    public PaymentHistoryPage() {
        super();
    }

    /**
     * Gets column values from table.
     *
     * @param columnName as String.
     * @return the values from a specific column.
     */
    public List<String> getColumnValues(final String columnName) {
        List<String> values = new ArrayList<>();
        List<WebElement> tableValues = CommonActions.findElementsBy(SearchBy.CSS, TABLE_LOCATOR);

        for (int i = 1; i <= tableValues.size(); i++) {
            String position = getCellPosition(columnName);
            String locator = String.format(CELLS_LOCATOR, i, position);
            WebElement element = CommonActions.findElementBy(SearchBy.CSS, locator);
            values.add(element.getText());
        }
        return values;
    }

    /**
     * Checks that values match with an expected one.
     *
     * @param transactionValues as a List of String.
     * @param expectedValue     as String.
     * @return true of all values match with expected one, false otherwise.
     */
    public boolean areValuesMatchWithExpectedOne(final List<String> transactionValues, final String expectedValue) {
        return transactionValues.stream().allMatch(value -> value.equalsIgnoreCase(expectedValue));
    }

    /**
     * Clicks first element on table.
     */
    public void clickFirstElementOnTable() {
        CommonActions.waitFor(1);
        String firstElementLocator = "#table_data > tbody > tr:nth-child(1) > td:nth-child(1) > a";
        WebElement element = CommonActions.findElementBy(SearchBy.CSS, firstElementLocator);
        CommonActions.clickElement(element);
    }

    /**
     * Completes refund transaction.
     *
     * @return message obtained once transaction is done.
     */
    public String completeRefundTransaction() {
        List<String> handles = CommonActions.getWindowHandles();
        String parentHandle = handles.get(0);
        String refundHandle = handles.get(1);
        CommonActions.switchWindow(refundHandle);
        CommonActions.clickElement(btnRefund);
        CommonActions.acceptAlert();
        String getRefundMessage = CommonActions.getTextElement(txtRefundMessage);
        CommonActions.closeWindowDriver();
        CommonActions.switchWindow(parentHandle);
        return getRefundMessage;
    }

    /**
     * Gets cell position on table.
     *
     * @param cellName as String.
     * @return cells position as String.
     */
    private String getCellPosition(final String cellName) {
        Map<String, String> cells = new HashMap<>();
        cells.put("DATE", "1");
        cells.put("TRANSACTION", "2");
        cells.put("CARD NAME", "3");
        cells.put("AMOUNT", "4");
        cells.put("STATUS", "5");
        return cells.get(cellName.toUpperCase());
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
        List<String> transactions = CommonActions.findElementsBy(SearchBy.CSS, TEXT_LOCATOR)
                .stream().map(WebElement::getText)
                .filter(value -> value.equalsIgnoreCase(typeOneValue) || value.equalsIgnoreCase(typeTwoValue))
                .collect(Collectors.toList());

        boolean isTypeOneCorrectlyDisplayed = transactions.stream()
                .filter(value -> value.equalsIgnoreCase(typeOneValue)).count() == amountTypeOne;
        boolean isTypeTwoCorrectlyDisplayed = transactions.stream()
                .filter(value -> value.equalsIgnoreCase(typeTwoValue)).count() == amountTypeTwo;
        return isTypeOneCorrectlyDisplayed && isTypeTwoCorrectlyDisplayed;
    }
}
