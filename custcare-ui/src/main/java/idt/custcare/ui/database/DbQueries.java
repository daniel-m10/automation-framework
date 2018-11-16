package idt.custcare.ui.database;

/**
 * Contains queries strings to execute in a database.
 */
public final class DbQueries {
    public static final String SELECT_RECORD = "select %s from %s where %s";

    public static final String SELECT_COUNT_OF_RECORDS = "select count(*) NUMBER_OF_RETURNED_ROWS from %s where %s";

    public static final String INSERT_RECORD = "insert into %s (%s) values (%s)";

    public static final String DELETE_RECORD = "delete from %s where %s";

    public static final String UPDATE_RECORD = "update %s set %s where %s";

    public static final String DELETE_CCHISTORY_HAVING_PIN = "delete from cc_history where ctlnum = "
            + "(select ctlnum from pintab where pin = %s and trans_id = 'C')";

    public static final String DELETE_FISRT_ROW_CCHISTORY = "DELETE FROM CC_HISTORY WHERE CS_USER = '%s' "
            + "AND TIMESTAMP >= SYSDATE - 1 AND ROWNUM = 1";

    /**
     * Initializes an instance of {@link DbQueries}.
     */
    private DbQueries() {
    }
}
