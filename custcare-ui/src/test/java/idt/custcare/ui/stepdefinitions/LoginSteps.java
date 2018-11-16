package idt.custcare.ui.stepdefinitions;

import cucumber.api.java.en.Given;
import idt.custcare.ui.base.login.ILoginPage;
import idt.custcare.ui.base.login.LoginFactory;
import idt.custcare.ui.base.login.PortalWeb;
import idt.custcare.ui.base.login.UserTypes;
import idt.custcare.ui.config.EnvironmentManager;
import idt.custcare.ui.portals.custcare.dto.EnvironmentConfigDto;
import idt.custcare.ui.portals.custcare.pages.CustcareLoginPage;

/**
 * Contains steps definition methods for login pages.
 */
public class LoginSteps {
    private ILoginPage loginPage;
    private EnvironmentConfigDto environmentConfig;

    /**
     * Initializes an instance of {@link LoginSteps}.
     *
     * @param environmentConfig as EnvironmentConfigDto type.
     */
    public LoginSteps(final EnvironmentConfigDto environmentConfig) {
        this.environmentConfig = environmentConfig;
    }

    /**
     * Logs a user in a portal web.
     *
     * @param portalWeb the portal web to logs the user.
     * @param userType  the user type that will login in the portal.
     */
    @Given("^I login to (.*) web portal with (.*) credentials$")
    public void loginToWebPortalWithCredentials(final PortalWeb portalWeb, final UserTypes userType) {
        configureEnvironment(portalWeb, userType);
        loginPage = LoginFactory.createLoginPage(portalWeb);
        loginPage.loginUserInPortal(environmentConfig.getUsername(), environmentConfig.getPassword(),
                environmentConfig.getBaseLoginUrl());
    }

    /**
     * Logs a user in a Custcare portal with IDT credentials.
     *
     * @param userType the user type that will login in the portal.
     */
    @Given("^I login to Custcare portal as IDT user with (.*) credentials$")
    public void loginToCustcarePortalAsIdtUserWithCredentials(final UserTypes userType) {
        configureEnvironment(PortalWeb.CUSTCARE, userType);
        CustcareLoginPage custcareLoginPage = new CustcareLoginPage();
        custcareLoginPage.loginAsIdtUser(environmentConfig.getUsername(), environmentConfig.getPassword(),
                environmentConfig.getBaseLoginUrl());
    }

    /**
     * Configures Portal and User data according received values.
     *
     * @param portalWeb the portal web name.
     * @param userType  the user type name.
     */
    private void configureEnvironment(final PortalWeb portalWeb, final UserTypes userType) {
        EnvironmentManager environmentManager = EnvironmentManager.getInstance();
        environmentManager.configureEnvironmentSettings(portalWeb, userType);
        environmentConfig.setPortal(portalWeb.toString());
        environmentConfig.setBaseLoginUrl(environmentManager.getBaseLoginUrl());
        environmentConfig.setUserType(userType.toString());
        environmentConfig.setUsername(environmentManager.getUsername());
        environmentConfig.setPassword(environmentManager.getPassword());
    }
}
