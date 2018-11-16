package idt.custcare.ui.driver;

import idt.custcare.ui.config.UiConfig;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Manages and performs actions with the Web Driver.
 */
public final class DriverManager {

    private static DriverManager instance;

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * Initializes an instance of {@link DriverManager}.
     */
    private DriverManager() {
    }

    /**
     * Initializes the Singleton Driver Manager instance.
     *
     * @return singleton instance.
     */
    public static DriverManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Initializes the Web Driver instance.
     */
    public void initializeDriver() {
        DriverTypes driverType = DriverTypes.valueOf(UiConfig.getInstance().getBrowser());
        this.webDriver = DriverFactory.getDriver(driverType);
        this.webDriver.manage().window().maximize();
        setDefaultTimeWaits();
    }

    /**
     * Quits the Web Driver instance.
     */
    public void quitDriver() {
        this.webDriver.quit();
        this.webDriver = null;
    }

    /**
     * Gets the Web Driver instance.
     *
     * @return Web Driver instance.
     */
    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    /**
     * Gets the Web Driver Wait instance.
     *
     * @return Web Driver Wait instance.
     */
    public WebDriverWait getWebDriverWait() {
        return this.webDriverWait;
    }

    /**
     * Sets the default time waits from environment configuration file.
     */
    public void setDefaultTimeWaits() {
        setImplicitTimeWait(UiConfig.getInstance().getImplicitTime());
        setExplicitTimeWait(UiConfig.getInstance().getExplicitTime(), UiConfig.getInstance().getSleepTime());
        setPageLoadTimeWait(UiConfig.getInstance().getPageLoadTime());
    }

    /**
     * Sets implicit time wait.
     *
     * @param implicitTimeWait implicit time wait in seconds.
     */
    public void setImplicitTimeWait(final int implicitTimeWait) {
        webDriver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.SECONDS);
    }

    /**
     * Sets explicit time wait.
     *
     * @param explicitTimeWait explicit time wait in seconds.
     * @param sleepTimeWait    sleep time wait in seconds.
     */
    public void setExplicitTimeWait(final int explicitTimeWait, final int sleepTimeWait) {
        webDriverWait = new WebDriverWait(webDriver, explicitTimeWait, sleepTimeWait);
    }

    /**
     * Sets page load time wait.
     *
     * @param pageLoadTimeWait page load time wait in seconds.
     */
    public void setPageLoadTimeWait(final long pageLoadTimeWait) {
        webDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeWait, TimeUnit.SECONDS);
    }

    /**
     * Gets the current web page title.
     *
     * @return current web page title string.
     */
    public String getCurrentPageTitle() {
        return webDriver.getTitle();
    }
}
