package idt.custcare.ui.portals.custcare.pages;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.utils.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Custcare home page.
 */
public class CustcareHomePage extends BasePage {
    private static final String WELCOME_MSG = "//td[@class = 'IdtWelcome'][contains(text(),'Welcome AM\\%s')]"
            + "| //td[@class = 'IdtWelcome'][contains(text(),'Welcome EXTERNAL\\%s')]";
    @FindBy(className = "IdtTitleHeader")
    private WebElement lblHomeTitle;

    /**
     * Verifies if Custcare home page is displayed.
     *
     * @param username the username of user logged in the portal.
     * @return true if home page is displayed.
     */
    public boolean isHomePage(final String username) {
        return (isHomeTitleDisplayed() && isWelcomeUserMessageDisplayed(username));
    }

    /**
     * Verifies if home page title is displayed in home page.
     *
     * @return true if home page title is displayed.
     */
    public boolean isHomeTitleDisplayed() {
        return CommonActions.isElementDisplayed(lblHomeTitle);
    }

    /**
     * Verifies if welcome user message is displayed in home page.
     *
     * @param username the username of user logged in the portal.
     * @return true if welcome user message is displayed.
     */
    public boolean isWelcomeUserMessageDisplayed(final String username) {
        WebElement lblWelcomeUserMessage = getDriver().findElement(
                By.xpath(String.format(WELCOME_MSG, username, username)));
        return CommonActions.isElementDisplayed(lblWelcomeUserMessage);
    }
}
