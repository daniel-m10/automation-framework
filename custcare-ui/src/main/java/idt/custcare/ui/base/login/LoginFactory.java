package idt.custcare.ui.base.login;

import idt.custcare.ui.portals.custcare.pages.CustcareLoginPage;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Manages the login pages build.
 */
public final class LoginFactory {
    private static final Logger LOGGER = LogManager.getLogger(LoginFactory.class.getSimpleName());

    /**
     * Private constructor for {@link LoginFactory} utility class.
     */
    private LoginFactory() {
    }

    /**
     * Creates a new Login page according to the portal web.
     *
     * @param portalWeb the portal web name
     * @return an instance of portal login page
     */
    public static ILoginPage createLoginPage(final PortalWeb portalWeb) {
        try {
            Map<PortalWeb, ILoginPage> loginPages = new HashMap<>();
            loginPages.put(PortalWeb.CUSTCARE, new CustcareLoginPage());
            return loginPages.get(portalWeb);
        } catch (NullPointerException e) {
            LOGGER.warn(String.format("Unrecognized portal: %s, exception: %s", portalWeb.toString(), e));
            return null;
        }
    }
}
