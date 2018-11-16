package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.IMenu;
import idt.custcare.ui.utils.CommonActions;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Main Menu component.
 */
public class MainMenu extends BasePage implements IMenu {
    @FindBy(id = "queryTab")
    private WebElement tabQuery;

    @FindBy(id = "accountTab")
    private WebElement tabAccount;

    @FindBy(id = "transTab")
    private WebElement tabTransactions;

    @FindBy(id = "rechargeTab")
    private WebElement tabRecharge;

    @FindBy(id = "featuresTab")
    private WebElement tabFeatures;

    @FindBy(id = "adminTab")
    private WebElement tabAdmin;

    @FindBy(id = "buyTab")
    private WebElement tabBuy;

    @FindBy(id = "getRateTab")
    private WebElement tabGetRate;

    @FindBy(id = "employeeAcctTab")
    private WebElement tabEmployeeAcct;

    @FindBy(id = "userTab")
    private WebElement tabUserDetails;

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectOption(final String option) {
        HashMap<String, WebElement> optionsList = new HashMap<>();
        optionsList.put("QUERY", tabQuery);
        optionsList.put("ACCOUNT", tabAccount);
        optionsList.put("TRANSACTIONS", tabTransactions);
        optionsList.put("RECHARGE", tabRecharge);
        optionsList.put("FEATURES", tabFeatures);
        optionsList.put("ADMIN", tabAdmin);
        optionsList.put("BUY", tabBuy);
        optionsList.put("GET RATE", tabGetRate);
        optionsList.put("EMPLOYEE ACCT", tabEmployeeAcct);
        optionsList.put("USER DETAILS", tabUserDetails);
        CommonActions.clickElement(optionsList.get(option.toUpperCase()));
    }
}
