package idt.custcare.ui.config;

/**
 * Custom reserved words enum.
 */
public enum ReservedWords {
    ALL("all"),
    AND(" and "),
    ASTERISK_SYMBOL("*"),
    BASE_URL("BaseUrl"),
    BASE_LOGIN_URL("BaseLoginUrl"),
    BROWSER("browser"),
    DBs("DBs"),
    DOUBLE_DOT_AND_SLASH("../"),
    ENVIRONMENTS("Environments"),
    ENVIRONMENT_NAME("environmentName"),
    EXPLICIT_TIME("explicitTimeWait"),
    HOST("Host"),
    IMPLICIT_TIME("implicitTimeWait"),
    LOGIN_FAILED("Login failed"),
    NAME("Name"),
    NUMBER_OF_RETURNED_ROWS("NUMBER_OF_RETURNED_ROWS"),
    PAGE_LOAD_TIME("pageLoadTimeWait"),
    PASSWORD("Password"),
    PORTALS("Portals"),
    PORT("Port"),
    SERVICE_NAME("ServiceName"),
    SLEEP_TIME("sleepWaitTime"),
    STRING_EMPTY(""),
    TYPE("Type"),
    USER("User"),
    USERS("Users"),
    USERNAME("Username");

    private String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    ReservedWords(final String word) {
        this.word = word;
    }

    /**
     * Gets the enum word value.
     *
     * @return original word.
     */
    public String val() {
        return word;
    }
}
