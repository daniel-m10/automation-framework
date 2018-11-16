package idt.custcare.ui.driver;

import java.util.EnumMap;
import org.openqa.selenium.WebDriver;

/**
 * Creates the instance of a Web Driver.
 */
public final class DriverFactory {
    /**
     * Initializes an instance of {@link DriverFactory} utility class.
     */
    private DriverFactory() {
    }

    /**
     * Gets a Web Driver instances based in a Driver Type parameter.
     *
     * @param type Driver Type enum value.
     * @return Web Driver instance.
     */
    public static WebDriver getDriver(final DriverTypes type) {
        Browser browser = (Browser) getStrategyBrowser().get(type).performStep();
        return browser.getDriver();
    }

    /**
     * Gets strategy browser map.
     *
     * @return browser map.
     */
    private static EnumMap<DriverTypes, StrategyGetter> getStrategyBrowser() {
        EnumMap<DriverTypes, StrategyGetter> driverMap = new EnumMap<>(DriverTypes.class);
        driverMap.put(DriverTypes.CHROME, ChromeBrowser::new);
        driverMap.put(DriverTypes.FIREFOX, FirefoxBrowser::new);
        driverMap.put(DriverTypes.INTERNET_EXPLORER, InternetExplorerBrowser::new);
        return driverMap;
    }
}
