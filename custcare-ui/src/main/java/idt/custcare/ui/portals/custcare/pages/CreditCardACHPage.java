package idt.custcare.ui.portals.custcare.pages;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Credit Card ACH page.
 */
public class CreditCardACHPage extends BasePage {
    @FindBy(css = "input[value='Recharge']")
    private WebElement btnRecharge;

    @FindBy(css = "input[value='Reset']")
    private WebElement btnReset;

    @FindBy(css = "input[name='modifycc']")
    private WebElement btnModifyCC;

    @FindBy(css = "input[name='modifyci']")
    private WebElement btnModifyCI;

    @FindBy(css = "#ccDataDiv > table:nth-child(6) > tbody > tr:nth-child(1) > td")
    private WebElement lblSuccessTransactionMessage;

    /**
     * Initializes an instance of {@link CreditCardACHPage}.
     */
    public CreditCardACHPage() {
        super();
    }

    /**
     * Clicks a button on the page.
     *
     * @param buttonName as String.
     */
    public void clickOnButton(final String buttonName) {
        WebElement element = getElementLocator(buttonName);
        CommonActions.clickElement(element);
    }

    /**
     * Gets message obtained after complete transaction.
     *
     * @param name as String.
     * @return transaction message.
     */
    public String getTransactionMessage(final String name) {
        return CommonActions.getTextElement(getElementLocator(name));
    }

    /**
     * Gets the WebElement of an element found on page.
     *
     * @param elementName as String.
     * @return WebElement of one page element.
     */
    private WebElement getElementLocator(final String elementName) {
        Map<String, WebElement> pageElements = new HashMap<>();
        pageElements.put("SUCCESS", lblSuccessTransactionMessage);
        pageElements.put("RECHARGE", btnRecharge);
        pageElements.put("RESET", btnReset);
        pageElements.put("MODIFY CC", btnModifyCC);
        pageElements.put("MODIFY CI", btnModifyCI);
        return pageElements.get(elementName.toUpperCase());
    }
}
