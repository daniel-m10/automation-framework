package idt.custcare.ui.base;

/**
 * Handles methods that components of menu type should implement.
 */
public interface IMenu {
    /**
     * Selects an option inside a menu component.
     *
     * @param option the option to click in the menu.
     */
    void selectOption(String option);
}
