package idt.custcare.ui.database;

/**
 * OracleDataBase class.
 */
public class OracleDataBase extends DataBase {
    private static final String URL_FORMAT = "jdbc:oracle:thin:%s/%s@%s:%s/%s";

    /**
     * Initializes an instance of {@link OracleDataBase}.
     */
    public OracleDataBase() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUrlFormat() {
        return String.format(URL_FORMAT, getUsername(), getPassword(), getHostname(), getPort(), getDbName());
    }
}
