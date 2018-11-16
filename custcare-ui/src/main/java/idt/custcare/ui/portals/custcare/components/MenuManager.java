package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.portals.custcare.components.constants.MenuTypes;
import java.util.EnumMap;

/**
 * Creates the instance of a menu component.
 */
public final class MenuManager {
    /**
     * Initializes an instance of {@link MenuManager} utility class.
     */
    private MenuManager() {
    }

    /**
     * Selects an option inside a specific method.
     *
     * @param menu   Menu Type enum value.
     * @param option the option to select in the menu.
     */
    public static void selectOptionInMenu(final MenuTypes menu, final String option) {
        EnumMap<MenuTypes, Runnable> menuList = new EnumMap<>(MenuTypes.class);
        menuList.put(MenuTypes.ACCOUNT, () -> new AccountMenu().selectOption(option));
        menuList.put(MenuTypes.ADMIN, () -> new AdminMenu().selectOption(option));
        menuList.put(MenuTypes.BLOCKING, () -> new BlockingMenu().selectOption(option));
        menuList.put(MenuTypes.FEATURES, () -> new FeaturesMenu().selectOption(option));
        menuList.put(MenuTypes.MAIN, () -> new MainMenu().selectOption(option));
        menuList.put(MenuTypes.RECHARGE, () -> new RechargeMenu().selectOption(option));
        menuList.put(MenuTypes.TRANSACTIONS, () -> new TransactionsMenu().selectOption(option));
        menuList.put(MenuTypes.WIRELESS, () -> new WirelessMenu().selectOption(option));
        menuList.get(menu).run();
    }
}
