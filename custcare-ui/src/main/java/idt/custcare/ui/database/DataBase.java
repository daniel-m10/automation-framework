package idt.custcare.ui.database;

/**
 * DataBase class.
 */
public abstract class DataBase {
    private String username;
    private String password;
    private String hostname;
    private String port;
    private String dbName;

    /**
     * Initializes an instance of {@link DataBase}.
     */
    public DataBase() {
    }

    /**
     * Builds the Database URL format.
     *
     * @return url for database connetion.
     */
    public abstract String getUrlFormat();

    /**
     * Gets the username attribute.
     *
     * @return username String value.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username attribute.
     *
     * @param username string value.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Gets the password attribute.
     *
     * @return password String value.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password attribute.
     *
     * @param password string value.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the hostname attribute.
     *
     * @return hostname String value.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Sets the hostname attribute.
     *
     * @param hostname string value.
     */
    public void setHostname(final String hostname) {
        this.hostname = hostname;
    }

    /**
     * Gets the port attribute.
     *
     * @return port String value.
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets the port attribute.
     *
     * @param port String value.
     */
    public void setPort(final String port) {
        this.port = port;
    }

    /**
     * Gets the dbName attribute.
     *
     * @return dbName String Value.
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * Sets the dbName attribute.
     *
     * @param dbName String value.
     */
    public void setDbName(final String dbName) {
        this.dbName = dbName;
    }
}
