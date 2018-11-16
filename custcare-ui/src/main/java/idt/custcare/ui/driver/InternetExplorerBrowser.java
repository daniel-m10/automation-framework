package idt.custcare.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

/**
 * Initializes an instance of a Internet Explorer web driver.
 */
public class InternetExplorerBrowser implements Browser {
    private static final String IE_DRIVER_VERSION = "3.6.0";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getDriver() {
        WebDriverManager.iedriver().version(IE_DRIVER_VERSION).architecture(io.github.bonigarcia.wdm.Architecture.X32)
                .arch32().setup();
        return new InternetExplorerDriver(buildOptions());
    }

    /**
     * Builds the Internet Explorer options object.
     *
     * @return Internet Explorer options object.
     */
    private InternetExplorerOptions buildOptions() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        return options;
    }
}
