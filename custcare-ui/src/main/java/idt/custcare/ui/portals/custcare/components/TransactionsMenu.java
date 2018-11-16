package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.IMenu;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Transactions Menu component.
 */
public class TransactionsMenu extends BasePage implements IMenu {
    @FindBy(id = "billinghist")
    private WebElement tabBillingHistory;
    @FindBy(id = "creditcardhist")
    private WebElement tabPaymentHistory;

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectOption(final String option) {
        HashMap<String, WebElement> optionsList = new HashMap<>();
        optionsList.put("BILLING HISTORY", tabBillingHistory);
        optionsList.put("PAYMENT HISTORY", tabPaymentHistory);
        CommonActions.clickElement(optionsList.get(option.toUpperCase()));
    }
}
