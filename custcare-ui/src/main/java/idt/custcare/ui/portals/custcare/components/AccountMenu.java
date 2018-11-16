package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.IMenu;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Account Menu component.
 */
public class AccountMenu extends BasePage implements IMenu {
    @FindBy(id = "accountinfo")
    private WebElement tabAccountInfo;

    @FindBy(id = "custinfo")
    private WebElement tabCustomerInfo;

    @FindBy(id = "creditcardinfo")
    private WebElement tabPaymentInfo;

    @FindBy(id = "groupinfo")
    private WebElement tabGroup;

    @FindBy(id = "accountqueryrate")
    private WebElement tabGetRate;

    @FindBy(id = "queryTab")
    private WebElement tabQuery;

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectOption(final String option) {
        HashMap<String, WebElement> optionsList = new HashMap<>();
        optionsList.put("QUERY", tabQuery);
        optionsList.put("ACCOUNT INFO", tabAccountInfo);
        optionsList.put("CUSTOMER INFO", tabCustomerInfo);
        optionsList.put("PAYMENT INFO", tabPaymentInfo);
        optionsList.put("GROUP", tabGroup);
        optionsList.put("GET RATE", tabGetRate);
        CommonActions.clickElementByJavascript(optionsList.get(option.toUpperCase()));
    }
}
