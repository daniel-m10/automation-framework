package idt.custcare.ui.portals.custcare.dto;

/**
 * Contains properties for Environment config data transfer object.
 */
public class EnvironmentConfigDto {
    private String portal;
    private String baseLoginUrl;
    private String userType;
    private String username;
    private String password;

    /**
     * Gets value contained in portal.
     *
     * @return portal value.
     */
    public String getPortal() {
        return portal;
    }

    /**
     * Sets a value in portal.
     *
     * @param portal is the value to set.
     */
    public void setPortal(final String portal) {
        this.portal = portal;
    }

    /**
     * Gets value contained in baseLoginUrl.
     *
     * @return baseLoginUrl value.
     */
    public String getBaseLoginUrl() {
        return baseLoginUrl;
    }

    /**
     * Sets a value in baseLoginUrl.
     *
     * @param baseLoginUrl is the value to set.
     */
    public void setBaseLoginUrl(final String baseLoginUrl) {
        this.baseLoginUrl = baseLoginUrl;
    }

    /**
     * Gets value contained in userType.
     *
     * @return userType value.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets a value in userType.
     *
     * @param userType is the value to set.
     */
    public void setUserType(final String userType) {
        this.userType = userType;
    }

    /**
     * Gets value contained in username.
     *
     * @return username value.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets a value in username.
     *
     * @param username is the value to set.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Gets value contained in password.
     *
     * @return password value.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets a value in password.
     *
     * @param password is the value to set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }
}
