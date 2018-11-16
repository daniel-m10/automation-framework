package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.IMenu;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on RechargeMenu Menu component.
 */
public class RechargeMenu extends BasePage implements IMenu {
    @FindBy(id = "ccrecharge")
    private WebElement tabCrecitCardAch;
    @FindBy(id = "imtu")
    private WebElement tabMobileTopUp;

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectOption(final String option) {
        HashMap<String, WebElement> optionsList = new HashMap<>();
        optionsList.put("CREDIT CARD ACH", tabCrecitCardAch);
        optionsList.put("MOBILE TOP UP", tabMobileTopUp);
        CommonActions.clickElement(optionsList.get(option.toUpperCase()));
    }
}
