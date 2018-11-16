package idt.custcare.ui.portals.custcare.pages;

import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.base.login.ILoginPage;
import idt.custcare.ui.utils.CommonActions;
import idt.custcare.ui.utils.LoginUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manages elements and actions on Custcare login page.
 */
public class CustcareLoginPage extends BasePage implements ILoginPage {
    private static final String LOGIN_KEYS_FORMAT = "%s%s%s";

    @FindBy(id = "ctl00_MainContent_txtUsername")
    private WebElement txtUsername;

    @FindBy(id = "ctl00_MainContent_txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "ctl00_MainContent_btnLogin")
    private WebElement btnLogin;

    @FindBy(id = "ctl00_MainContent_btnInternalLogin")
    private WebElement btnLoginIdtUser;

    @FindBy(id = "ctl00_MainContent_spnMain")
    private WebElement frmLogin;

    /**
     * Clicks on btnLoginIdtUser element.
     */
    public void clickOnLoginIdtUserButton() {
        CommonActions.clickElement(btnLoginIdtUser);
    }

    /**
     * Login user in portal with IDT credentials.
     *
     * @param username     the username that will login in the portal.
     * @param password     password for User to login in the portal.
     * @param baseLoginUrl the url to login in the portal.
     */
    public void loginAsIdtUser(final String username, final String password, final String baseLoginUrl) {
        getDriver().navigate().to(baseLoginUrl);
        LoginUtils.loginToPortal(username, password, btnLoginIdtUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loginUserInPortal(final String username, final String password, final String baseLoginUrl) {
        getDriver().navigate().to(baseLoginUrl);
        CommonActions.setInputField(txtUsername, username);
        CommonActions.setInputField(txtPassword, password);
        CommonActions.clickElement(btnLogin);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLoginPage() {
        return CommonActions.isElementDisplayed(frmLogin);
    }
}
