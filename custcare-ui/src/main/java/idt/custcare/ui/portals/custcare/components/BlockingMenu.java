package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.IMenu;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Blocking Menu component.
 */
public class BlockingMenu extends BasePage implements IMenu {
    @FindBy(id = "anipinblock")
    private WebElement tabAniAccountBlocking;
    @FindBy(id = "ccblock")
    private WebElement tabCreditCardBlocking;

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectOption(final String option) {
        HashMap<String, WebElement> optionsList = new HashMap<>();
        optionsList.put("ANI ACCOUNT BLOCKING", tabAniAccountBlocking);
        optionsList.put("CREDIT CARD BLOCKING", tabCreditCardBlocking);
        CommonActions.clickElement(optionsList.get(option.toUpperCase()));
    }
}
