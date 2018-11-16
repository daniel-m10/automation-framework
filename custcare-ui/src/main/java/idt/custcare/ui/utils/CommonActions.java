package idt.custcare.ui.utils;

import idt.custcare.ui.config.UiConfig;
import idt.custcare.ui.driver.DriverManager;
import idt.custcare.ui.driver.DriverTypes;
import idt.custcare.ui.utils.constants.SearchBy;
import idt.custcare.ui.utils.constants.SelectBy;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Manages and performs actions on Web elements.
 */
public final class CommonActions {
    private static final Logger LOGGER = LogManager.getLogger(CommonActions.class.getSimpleName());
    private static final String ALERT_NOT_PRESENT_MSG = "Alert is not present";
    private static final String CLICK_JS_SCRIPT = "arguments[0].click();";
    private static JavascriptExecutor js = (JavascriptExecutor) DriverManager.getInstance().getWebDriver();

    /**
     * Private constructor for {@link CommonActions} utility class.
     */
    private CommonActions() {
    }

    /**
     * Waits and clears the WebElement.
     *
     * @param webElement WebElement to wait and clear.
     */
    public static void clearTextField(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    /**
     * Clears and sets an input Field.
     *
     * @param webElement WebElement to wait and fill.
     * @param text       Text to fill.
     */
    public static void clearAndSetInputField(final WebElement webElement, final String text) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        clearTextField(webElement);
        webElement.sendKeys(text);
    }

    /**
     * Sets an input Field.
     *
     * @param webElement WebElement to wait and fill.
     * @param text       Text to fill.
     */
    public static void setInputField(final WebElement webElement, final String text) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    /**
     * Waits and clicks on a webElement.
     *
     * @param webElement WebElement to wait and click.
     */
    public static void clickElement(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Waits and clicks on a webElement using a javascript code.
     *
     * @param webElement WebElement to wait and click.
     */
    public static void clickElementByJavascript(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        js.executeScript(CLICK_JS_SCRIPT, webElement);
    }

    /**
     * Selects an item by value in select element.
     *
     * @param webElement select element.
     * @param value      value to be selected.
     */
    public static void selectOption(final WebElement webElement, final String value) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }

    /**
     * Gets the text of the current selected item in select element.
     *
     * @param webElement select element.
     * @return current selected item text.
     */
    public static String getSelectedText(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        Select select = new Select(webElement);
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Waits and gets the text of an WebElement.
     *
     * @param webElement WebElement to wait and get the text.
     * @return Text of element.
     */
    public static String getTextElement(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * Sets the checkbox state according to state parameter.
     *
     * @param webElement checkbox web element.
     * @param state      checkbox state.
     */
    public static void setCheckboxState(final WebElement webElement, final boolean state) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        if (!webElement.isSelected() && state || webElement.isSelected() && !state) {
            webElement.click();
        }
    }

    /**
     * Accepts and alert prompt.
     */
    public static void acceptAlert() {
        DriverManager.getInstance().getWebDriverWait()
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());

        Alert alert = DriverManager.getInstance().getWebDriver().switchTo().alert();
        alert.accept();
    }

    /**
     * Gets the message contained in an alert window.
     *
     * @return alert window message as String.
     */
    public static String getAlertMessage() {
        DriverManager.getInstance().getWebDriverWait()
                .ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverManager.getInstance().getWebDriver().switchTo().alert();
        String message = alert.getText();
        alert.accept();
        return message;
    }

    /**
     * Verifies if Web element is Displayed.
     *
     * @param webElement WebElement.
     * @return True if the element is Displayed.
     */
    public static boolean isElementDisplayed(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isDisplayed();
    }

    /**
     * Verifies if Alert prompt is present and switches to it.
     *
     * @return True if alert is present.
     */
    public static boolean isAlertPresent() {
        try {
            DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (NoAlertPresentException e) {
            LOGGER.error(ALERT_NOT_PRESENT_MSG);
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    /**
     * Verifies if the current browser belongs to the driver type received.
     *
     * @param driver Driver Type enum value.
     * @return True if current browser belongs to driver type parameter.
     */
    public static boolean isCurrentBrowser(final DriverTypes driver) {
        return UiConfig.getInstance().getBrowser().contains(driver.name());
    }

    /**
     * Checks if element is selected.
     *
     * @param element as WebElement.
     * @return true if element is selected, false otherwise.
     */
    public static boolean isElementSelected(final WebElement element) {
        return element.isSelected();
    }

    /**
     * Gets a list of WebElements.
     *
     * @param by      as SearchBy enum type.
     * @param locator as String.
     * @return a list of WebElements.
     */
    public static List<WebElement> findElementsBy(final SearchBy by, final String locator) {
        By searchBy = getBy(by, locator);
        return DriverManager.getInstance().getWebDriver().findElements(searchBy);
    }

    /**
     * Gets a WebElement.
     *
     * @param by      as SearchBy enum type.
     * @param locator as String.
     * @return a locator WebElement.
     */
    public static WebElement findElementBy(final SearchBy by, final String locator) {
        By searchBy = getBy(by, locator);
        return DriverManager.getInstance().getWebDriver().findElement(searchBy);
    }

    /**
     * Gets element text using JavaScriptExecutor.
     *
     * @param element as WebElement.
     * @return element text as String.
     */
    public static String getTextByJavaScript(final WebElement element) {
        return js.executeScript("return arguments[0].value;", element).toString();
    }

    /**
     * Deletes text on a field using keys.
     *
     * @param element as WebElement type.
     */
    public static void deleteTextUsingKeys(final WebElement element) {
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.DELETE);
    }

    /**
     * Moves scroll bar down until get end of page.
     */
    public static void scrollDownPageUntilBottom() {
        long scrollPauseTime = 1;
        String lastHeight = js.executeScript("return document.body.scrollHeight").toString();

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            waitFor(scrollPauseTime);
            String newHeight = js.executeScript("return document.body.scrollHeight").toString();
            if (newHeight.equals(lastHeight)) {
                break;
            }
            lastHeight = newHeight;
        }
    }

    /**
     * Waits for a certain amount of time.
     *
     * @param seconds as long.
     */
    public static void waitFor(final long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            LOGGER.error("Error executing Thread.");
            LOGGER.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Gets window handles.
     *
     * @return list of actual window handles.
     */
    public static List<String> getWindowHandles() {
        return new ArrayList<>(DriverManager.getInstance().getWebDriver().getWindowHandles());
    }

    /**
     * Switches between windows.
     *
     * @param windowHandle as String.
     */
    public static void switchWindow(final String windowHandle) {
        DriverManager.getInstance().getWebDriver().switchTo().window(windowHandle);
    }

    /**
     * Closes the driver of opened window.
     */
    public static void closeWindowDriver() {
        DriverManager.getInstance().getWebDriver().close();
    }


    /**
     * Waits until the element gets displayed on page.
     *
     * @param by      of SearchBy enum type.
     * @param locator as String.
     */
    public static void waitUntilElementIsDisplayed(final SearchBy by, final String locator) {
        By searchBy = getBy(by, locator);
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(searchBy));
    }

    /**
     * Gets By object given a locator.
     *
     * @param option  as SearchBy enum type.
     * @param locator as String.
     * @return By object.
     */
    private static By getBy(final SearchBy option, final String locator) {
        Map<SearchBy, By> byMap = new EnumMap<>(SearchBy.class);
        byMap.put(SearchBy.CSS, By.cssSelector(locator));
        byMap.put(SearchBy.ID, By.id(locator));
        byMap.put(SearchBy.XPATH, By.xpath(locator));
        byMap.put(SearchBy.CLASS, By.className(locator));
        return byMap.get(option);
    }

    /**
     * Selects a value from list based on a select criteria.
     *
     * @param selectBy as SelectBy type.
     * @param option   as String.
     * @param element  as WebElement type.
     */
    public static void selectOptionFromList(final SelectBy selectBy, final String option, final WebElement element) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        switch (selectBy) {
            case VISIBLE_TEXT:
                select.selectByVisibleText(option);
                break;
            case VALUE:
                select.selectByValue(option);
                break;
            case INDEX:
                select.selectByIndex(Integer.parseInt(option));
                break;
            default:
                String message = "'%s' is not a valid option";
                throw new IllegalArgumentException(String.format(message, option));
        }
    }

    /**
     * Checks if an element is clickable.
     *
     * @param element as WebElement.
     * @return true if element is clickable, false otherwise.
     */
    public static boolean isElementClickable(final WebElement element) {
        try {
            DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (NoSuchElementException e) {
            LOGGER.error("Web element isn't clickable.", e);
            return false;
        }
    }
}
