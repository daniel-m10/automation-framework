package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.ISubMenu;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Unlimited Calling Submenu component.
 */
public class UnlimitedCallingSubMenu extends BasePage implements ISubMenu {
    @FindBy(id = "unlimitedPlans")
    private WebElement tabCurrentPlans;

    @FindBy(id = "unlimitedOffers")
    private WebElement tabAditionalOffers;

    @FindBy(id = "unlimitedSearch")
    private WebElement tabDestinationSearch;

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickSubMenu(final String option) {
        Map<String, WebElement> subMenus = new HashMap<>();
        subMenus.put("CURRENT PLANS", tabCurrentPlans);
        subMenus.put("ADDITIONAL OFFERS", tabAditionalOffers);
        subMenus.put("DESTINATION SEARCH", tabDestinationSearch);
        CommonActions.clickElement(subMenus.get(option.toUpperCase()));
    }
}
