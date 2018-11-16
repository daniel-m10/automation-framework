package idt.custcare.ui.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import idt.custcare.ui.base.BasePage;
import idt.custcare.ui.portals.custcare.components.MenuManager;
import idt.custcare.ui.portals.custcare.components.SubMenuManager;
import idt.custcare.ui.portals.custcare.components.constants.MenuTypes;
import idt.custcare.ui.portals.custcare.components.constants.SubMenuTypes;

/**
 * Contains common steps definition methods for many pages and/or components used y many scenarios.
 */
public class CommonSteps {
    /**
     * Selects an option from main menu.
     *
     * @param option the option contained inside the main menu.
     */
    @Given("^I select (.*) option from MAIN menu$")
    public void selectOptionFromMainMenu(final String option) {
        MenuManager.selectOptionInMenu(MenuTypes.MAIN, option);
    }

    /**
     * Selects an option from specified menu.
     *
     * @param option   the option contained inside the menu.
     * @param menuName the menu or submenu name.
     */
    @Given("^I select (.*) option inside (.*) menu$")
    public void selectOptionInsideMenu(final String option, final MenuTypes menuName) {
        MenuManager.selectOptionInMenu(MenuTypes.MAIN, menuName.toString());
        MenuManager.selectOptionInMenu(menuName, option);
    }

    /**
     * Selects an option inside a submenu.
     *
     * @param option      the option contained inside the submenu.
     * @param subMenuName the submenu name.
     * @param menuName    the main menu name.
     */
    @Given("^I select (.*) option from (.*) submenu inside (.*)$")
    public void selectOptionFromSubMenuInsideMenu(final String option, final MenuTypes subMenuName,
                                                  final MenuTypes menuName) {
        MenuManager.selectOptionInMenu(menuName, subMenuName.toString());
        MenuManager.selectOptionInMenu(subMenuName, option);
    }

    /**
     * Selects an option from a sub menu.
     *
     * @param option      as String.
     * @param subMenuType as Submenu type.
     */
    @And("^I select (.*) submenu from (.*) menu$")
    public void iSelectSubMenuFromFeaturesPage(final String option, final SubMenuTypes subMenuType) {
        SubMenuManager.selectSubMenu(subMenuType, option);
    }

    /**
     * Accepts transaction.
     */
    @And("^I accept the transaction$")
    public void iAcceptTheTransaction() {
        BasePage.acceptTransaction();
    }
}
