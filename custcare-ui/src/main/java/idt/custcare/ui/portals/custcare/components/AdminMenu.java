package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.IMenu;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Admin Menu component.
 */
public class AdminMenu extends BasePage implements IMenu {
    @FindBy(id = "blocking")
    private WebElement tabBlocking;

    @FindBy(id = "unblockani")
    private WebElement tabUnblockAni;

    @FindBy(id = "classsummary")
    private WebElement tabClassSummary;

    @FindBy(id = "classmsg")
    private WebElement tabClassMessages;
    @FindBy(id = "addmessage")
    private WebElement tabAccountMessage;

    @FindBy(id = "usagelimits")
    private WebElement tabUsageLimits;

    @FindBy(id = "fees")
    private WebElement tabFeeInfo;

    @FindBy(id = "adminwireless")
    private WebElement tabWireless;

    @FindBy(id = "subpoenaquery")
    private WebElement tabSubpoenaQuery;

    @FindBy(id = "remit")
    private WebElement tabRemittance;

    @FindBy(id = "publicspeeddialcode")
    private WebElement tabPublicSpeedDialCode;

    @FindBy(id = "screenpopadmin")
    private WebElement tabScreenPops;

    @FindBy(id = "createacct")
    private WebElement tabCreateAccount;

    @FindBy(id = "helplink")
    private WebElement tabHelp;

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectOption(final String option) {
        HashMap<String, WebElement> optionsList = new HashMap<>();
        optionsList.put("BLOCKING", tabBlocking);
        optionsList.put("UNBLOCK ANI", tabUnblockAni);
        optionsList.put("CLASS SUMMARY", tabClassSummary);
        optionsList.put("CLASS MESSAGES", tabClassMessages);
        optionsList.put("ACCOUNT MESSAGE", tabAccountMessage);
        optionsList.put("USAGE LIMITS", tabUsageLimits);
        optionsList.put("FEE INFO", tabFeeInfo);
        optionsList.put("WIRELESS", tabWireless);
        optionsList.put("SUBPOENA QUERY", tabSubpoenaQuery);
        optionsList.put("REMITTANCE", tabRemittance);
        optionsList.put("PUBLIC SPEED DIAL CODE", tabPublicSpeedDialCode);
        optionsList.put("SCREEN POPS", tabScreenPops);
        optionsList.put("CREATE ACCOUNT", tabCreateAccount);
        optionsList.put("HELP", tabHelp);
        CommonActions.clickElement(optionsList.get(option.toUpperCase()));
    }
}
