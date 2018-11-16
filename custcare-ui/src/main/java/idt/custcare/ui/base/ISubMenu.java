package idt.custcare.ui.base;

/**
 * Handles methods that components of submenu type should implement.
 */
public interface ISubMenu {
    /**
     * Selects an option inside a submenu component.
     *
     * @param option the option to click in the submenu.
     */
    void clickSubMenu(String option);
}
