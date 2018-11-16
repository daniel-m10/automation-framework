package idt.custcare.ui.portals.custcare.pages;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.utils.CommonActions;
import idt.custcare.ui.utils.constants.LanguagePreference;
import idt.custcare.ui.utils.constants.SearchBy;
import idt.custcare.ui.utils.constants.SelectBy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Unlimited Calling page.
 */
public class UnlimitedCallingPage extends BasePage {
    private static final String BUY_BUTTON_LOCATOR = "input[value='Buy']";
    private static final String REDEEM_BUTTON_LOCATOR = "input[value='Redeem']";
    private static final String RENEW_BUTTON_LOCATOR = "input[value='Renew']";
    private static final String UPDATE_BUTTON_LOCATOR = "input[value='Update']";
    private static final String REFUND_BUTTON_LOCATOR = "input[value='Refund']";

    @FindBy(css = "#ccDataDiv div span")
    private WebElement txtPageTitle;

    @FindBy(css = "table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(2) > div")
    private WebElement txtPlanStatus;

    @FindBy(css = "div[title='Set plan to renew automatically based on Renewal Period.'] b")
    private WebElement txtAutoRenew;

    @FindBy(id = "processRequestSuccessId")
    private WebElement txtRequestSuccess;

    @FindBy(id = "processRequestFailedId")
    private WebElement txtErrorMessage;

    @FindBy(css = "div:nth-child(9) > table:nth-child(1) > tbody > tr > td > b")
    private WebElement txtMessageLanguagePreference;

    @FindBy(css = "td:nth-child(2) > div:nth-child(2)")
    private WebElement txtEnrollmentStatus;

    @FindBy(id = "languageSelectedId")
    private WebElement ddlLenguagePreference;

    @FindBy(id = "redemptionCode")
    private WebElement txtRedemptionCode;

    @FindBy(css = "input[value='Redeem']")
    private WebElement btnRedeem;

    @FindBy(css = "input[value='Renew']")
    private WebElement btnRenew;

    @FindBy(css = "input[value='Update']")
    private WebElement btnUpdate;

    @FindBy(css = "input[value='Refund']")
    private WebElement btnRefund;

    @FindBy(css = "input[value='Buy']")
    private WebElement btnBuy;

    @FindBy(css = "#detailMsg1 a")
    private WebElement lnkbtnShowDetails;

    /**
     * Initializes an instance of {@link UnlimitedCallingPage}.
     */
    public UnlimitedCallingPage() {
        super();
    }

    /**
     * Gets page title.
     *
     * @return the title as String.
     */
    public String getPageTitle() {
        return CommonActions.getTextElement(txtPageTitle);
    }

    /**
     * Gets text from a Web Element.
     *
     * @param elementName as String.
     * @return the text from element as String.
     */
    public String getTextFromElement(final String elementName) {
        Map<String, WebElement> pageText = new HashMap<>();
        pageText.put("ENROLLMENT STATUS", txtEnrollmentStatus);
        pageText.put("AUTO RENEW", txtAutoRenew);
        pageText.put("LANGUAGE PREFERENCE", txtMessageLanguagePreference);
        pageText.put("PLAN STATUS", txtPlanStatus);
        return CommonActions.getTextElement(pageText.get(elementName.toUpperCase()));
    }

    /**
     * Chooses a language from drop down list.
     *
     * @param selectBy as SelectBy type.
     * @param language as String.
     */
    public void chooseLanguage(final SelectBy selectBy, final String language) {
        String languageValue = LanguagePreference.valueOf(language.toUpperCase()).toString();
        CommonActions.selectOptionFromList(selectBy, languageValue, ddlLenguagePreference);
    }

    /**
     * Completes redeem transaction.
     *
     * @param activationCode as String.
     */
    public void redeemActivationCode(final String activationCode) {
        CommonActions.setInputField(txtRedemptionCode, activationCode);
        CommonActions.clickElementByJavascript(btnRedeem);
    }

    /**
     * Gets alert message.
     *
     * @return alert message as String.
     */
    public String getAlertMessage() {
        return CommonActions.getAlertMessage();
    }

    /**
     * Gets request success message.
     *
     * @return success message as String.
     */
    public String getRequestSuccessMessage() {
        return CommonActions.getTextElement(txtRequestSuccess);
    }

    /**
     * Checks that element is visible and clickable.
     *
     * @param elementName as String.
     * @return true if element fulfill conditions, false otherwise.
     */
    public boolean isElementVisibleAndClickable(final String elementName) {
        WebElement element = getClickableElementLocator(elementName);
        return CommonActions.isElementDisplayed(element) && CommonActions.isElementClickable(element);
    }

    /**
     * Gets list of specific buttons.
     *
     * @param buttonName as String.
     * @return a List of buttons that match with button name passed as parameter.
     */
    public List<WebElement> getListOfButtons(final String buttonName) {
        return CommonActions.findElementsBy(SearchBy.CSS, getButtonLocator(buttonName));
    }

    /**
     * Clicks a button on page.
     *
     * @param buttonName as String.
     */
    public void clickButtonOnPage(final String buttonName) {
        CommonActions.clickElement(getClickableElementLocator(buttonName));
    }

    /**
     * Gets error message from page.
     *
     * @return error message as String.
     */
    public String getErrorMessage() {
        return CommonActions.getTextElement(txtErrorMessage);
    }

    /**
     * Gets locator from a clickable element.
     *
     * @param elementName as String.
     * @return locator as WebElement type.
     */
    private WebElement getClickableElementLocator(final String elementName) {
        Map<String, WebElement> clickableElements = new HashMap<>();
        clickableElements.put("REDEEM", btnRedeem);
        clickableElements.put("RENEW", btnRenew);
        clickableElements.put("UPDATE", btnUpdate);
        clickableElements.put("REFUND", btnRefund);
        clickableElements.put("SHOW DETAILS", lnkbtnShowDetails);
        return clickableElements.get(elementName.toUpperCase());
    }

    /**
     * Gets locator from a button.
     *
     * @param button as String.
     * @return button locator as String.
     */
    private String getButtonLocator(final String button) {
        Map<String, String> buttonLocator = new HashMap<>();
        buttonLocator.put("REDEEM", REDEEM_BUTTON_LOCATOR);
        buttonLocator.put("RENEW", RENEW_BUTTON_LOCATOR);
        buttonLocator.put("UPDATE", UPDATE_BUTTON_LOCATOR);
        buttonLocator.put("BUY", BUY_BUTTON_LOCATOR);
        buttonLocator.put("REFUND", REFUND_BUTTON_LOCATOR);
        return buttonLocator.get(button.toUpperCase());
    }
}
