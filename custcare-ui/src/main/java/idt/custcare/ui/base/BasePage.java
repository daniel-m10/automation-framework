package idt.custcare.ui.base;

import idt.custcare.ui.driver.DriverManager;
import idt.custcare.ui.utils.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents and encapsulates common pages objects attributes.
 */
public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    /**
     * Initializes an instance of {@link BasePage}.
     */
    public BasePage() {
        setDriver(DriverManager.getInstance().getWebDriver());
        setDriverWait(DriverManager.getInstance().getWebDriverWait());
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Moves scroll bar down until get end of page.
     */
    public static void reachBottomPage() {
        CommonActions.scrollDownPageUntilBottom();
    }

    /**
     * Accepts windows alert.
     */
    public static void acceptTransaction() {
        CommonActions.acceptAlert();
    }

    /**
     * Gets the title.
     *
     * @return the String title.
     */
    public String getTitle() {
        return DriverManager.getInstance().getCurrentPageTitle();
    }

    /**
     * Gets the driver.
     *
     * @return driver property
     */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Sets a value in driver.
     *
     * @param driver value to set in driver property
     */
    protected void setDriver(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Gets the driverWait.
     *
     * @return driverWait property
     */
    protected WebDriverWait getDriverWait() {
        return driverWait;
    }

    /**
     * Sets a value in driverWait.
     *
     * @param driverWait value to set in driverWait property
     */
    protected void setDriverWait(final WebDriverWait driverWait) {
        this.driverWait = driverWait;
    }
}
