package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.IMenu;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Features Menu component.
 */
public class FeaturesMenu extends BasePage implements IMenu {
    @FindBy(id = "animaps")
    private WebElement tabAniCliMappings;

    @FindBy(id = "privatespeeddialcode")
    private WebElement tabSpeedDialCodes;

    @FindBy(id = "accountidmaps")
    private WebElement tabAutomaticTopUpMappings;

    @FindBy(id = "unlimited")
    private WebElement tabUnlimittedCalling;

    @FindBy(id = "destSpecial")
    private WebElement tabDestinationSpecialCalling;


    /**
     * {@inheritDoc}
     */
    @Override
    public void selectOption(final String option) {
        HashMap<String, WebElement> optionsList = new HashMap<>();
        optionsList.put("ANI CLI MAPPINGS", tabAniCliMappings);
        optionsList.put("SPEED DIAL CODES", tabSpeedDialCodes);
        optionsList.put("AUTOMATIC TOP UP MAPPINGS", tabAutomaticTopUpMappings);
        optionsList.put("UNLIMITTED CALLING", tabUnlimittedCalling);
        optionsList.put("DESTINATION SPECIAL CALLING", tabDestinationSpecialCalling);
        CommonActions.clickElement(optionsList.get(option.toUpperCase()));
    }
}
