package idt.custcare.ui.stepdefinitions;

import cucumber.api.java.en.Then;
import idt.custcare.ui.portals.custcare.dto.EnvironmentConfigDto;
import idt.custcare.ui.portals.custcare.pages.CustcareHomePage;
import org.testng.Assert;

/**
 * Contains steps definition methods for Custcare home page.
 */
public class HomeSteps {
    private CustcareHomePage custcareHomePage;
    private EnvironmentConfigDto environmentConfig;

    /**
     * Initializes an instance of {@link HomeSteps}.
     *
     * @param environmentConfig as EnvironmentConfigDto type.
     */
    public HomeSteps(final EnvironmentConfigDto environmentConfig) {
        custcareHomePage = new CustcareHomePage();
        this.environmentConfig = environmentConfig;
    }

    /**
     * Verifies that Home page is displayed.
     */
    @Then("^I should be redirected to Home page$")
    public void shouldBeRedirectedToHomePage() {
        final String username = environmentConfig.getUsername().replace("am\\", "");
        Assert.assertTrue(custcareHomePage.isHomePage(username));
    }
}
