package idt.custcare.ui.portals.custcare.pages;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.utils.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Account Info page.
 */
public class AccountInfoPage extends BasePage {
    @FindBy(xpath = "//span[@class='pageHeading'][contains(text(),'Account Info')]")
    private WebElement lblPageTitle;

    @FindBy(css = ".dndItemContent.accordionBody a[href*='loadPlans']")
    private WebElement lnkUnlimited;

    /**
     * Verifies if Account Info page is displayed.
     *
     * @return true if Account Info page is displayed.
     */
    public boolean isAccountInfoPage() {
        return CommonActions.isElementDisplayed(lblPageTitle);
    }

    /**
     * Checks that unlimited link get displayed and get usable on page.
     *
     * @return true if link is visible and usable, false otherwise.
     */
    public boolean isUnlimitedLinkDisplayed() {
        return CommonActions.isElementDisplayed(lnkUnlimited) && CommonActions.isElementClickable(lnkUnlimited);
    }

    /**
     * Checks Unlimited link.
     */
    public void clickUnlimitedLink() {
        CommonActions.clickElement(lnkUnlimited);
    }
}
