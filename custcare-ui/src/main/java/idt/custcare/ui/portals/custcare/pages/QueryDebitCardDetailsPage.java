package idt.custcare.ui.portals.custcare.pages;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.utils.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Query Debit Card Details page.
 */
public class QueryDebitCardDetailsPage extends BasePage {
    @FindBy(name = "cnum")
    private WebElement txtControlNumber;

    @FindBy(name = "pin")
    private WebElement txtPin;

    @FindBy(id = "queryButtonId")
    private WebElement btnQuery;

    /**
     * Clicks on btnQuery element.
     */
    public void clickQueryButton() {
        CommonActions.clickElement(btnQuery);
    }

    /**
     * Fills a value in txtControlNumber element.
     *
     * @param value is the value to fill.
     */
    public void fillControlNumberField(final String value) {
        CommonActions.setInputField(txtControlNumber, value);
    }

    /**
     * Fills a value in txtPin element.
     *
     * @param value is the value to fill.
     */
    public void fillPinField(final String value) {
        CommonActions.setInputField(txtPin, value);
    }
}
