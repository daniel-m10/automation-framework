package idt.custcare.ui.portals.custcare.components;

import idt.custcare.ui.portals.custcare.components.constants.SubMenuTypes;
import java.util.EnumMap;

/**
 * Creates the instance of a menu component.
 */
public final class SubMenuManager {

    /**
     * Initializes an instance of {@link SubMenuManager} utility class.
     */
    private SubMenuManager() {
    }

    /**
     * Selects an option inside a specific method.
     *
     * @param subMenuType SubMenu Type enum value.
     * @param option      the option to select in the menu.
     */
    public static void selectSubMenu(final SubMenuTypes subMenuType, final String option) {
        EnumMap<SubMenuTypes, Runnable> subMenuList = new EnumMap<>(SubMenuTypes.class);
        subMenuList.put(SubMenuTypes.FEATURES_UNLIMITED_CALLING,
                () -> new UnlimitedCallingSubMenu().clickSubMenu(option));
        subMenuList.get(subMenuType).run();
    }
}
