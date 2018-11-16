package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.IMenu;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Wireless Menu component.
 */
public class WirelessMenu extends BasePage implements IMenu {
    @FindBy(id = "searchwireless")
    private WebElement tabSearchWireless;

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectOption(final String option) {
        HashMap<String, WebElement> optionsList = new HashMap<>();
        optionsList.put("SEARCH WIRELESS", tabSearchWireless);
        CommonActions.clickElement(optionsList.get(option.toUpperCase()));
    }
}
