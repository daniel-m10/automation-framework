package idt.custcare.ui.utils;

import idt.custcare.ui.config.ReservedWords;
import idt.custcare.ui.database.DataBases;
import idt.custcare.ui.database.DbClientManager;
import idt.custcare.ui.database.DbQueries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Contains utils methods related to Database.
 */
public final class DbUtils {
    private static final Logger LOGGER = LogManager.getLogger(DbUtils.class.getSimpleName());
    private static final String FILTER_FORMAT = "%s = %s";

    /**
     * Initializes an instance of {@link DbUtils}.
     */
    private DbUtils() {
    }

    /**
     * Gets the total rows obtained after to execute a Select query.
     *
     * @param table        the table name in database.
     * @param filter       the values of the query filter in a map.
     * @param databaseName the database name where the query will be executed.
     * @return the number of total rows affected after to execute a Select query.
     */
    public static int getTotalRowsOfASelectQuery(final String table, final Map<String, String> filter,
                                                 final DataBases databaseName) {
        runQuery(String.format(DbQueries.SELECT_COUNT_OF_RECORDS, table, getValuesAsACondition(filter)),
                databaseName);
        int totalAffectedRecords = Integer.parseInt(getDataOfASpecificColumn(DbClientManager.getResultSet(),
                ReservedWords.NUMBER_OF_RETURNED_ROWS.val()));
        closeCurrentDbClient();
        return totalAffectedRecords;
    }

    /**
     * Gets data contained in specified column by executing a Select query.
     *
     * @param table        the table name in database.
     * @param column       the column name in table.
     * @param filter       the values of the query filter in a map.
     * @param databaseName the database name where the query will be executed.
     * @return data obtained as string.
     */
    public static String getRowDataOfASelectQuery(final String table, final String column,
                                                  final Map<String, String> filter, final DataBases databaseName) {
        runQuery(String.format(DbQueries.SELECT_RECORD, column, table, getValuesAsACondition(filter)),
                databaseName);
        String data = getDataOfASpecificColumn(DbClientManager.getResultSet(), column);
        closeCurrentDbClient();
        return data;
    }

    /**
     * Runs a query in a specified database.
     *
     * @param query        as String type.
     * @param databaseName as Databases type.
     */
    public static void runQuery(final String query, final DataBases databaseName) {
        String runQueryMessage = "--------- Executing: %s on %s database ---------";
        LOGGER.info(String.format(runQueryMessage, query, databaseName));
        DbClientManager.establishDatabaseConnection(databaseName);
        DbClientManager.executeQuery(query);
    }

    /**
     * Closes the established database connection.
     */
    public static void closeCurrentDbClient() {
        DbClientManager.closeConnection();
    }

    /**
     * Gets the value contained in a specific column.
     *
     * @param resultSet  contains the rows.
     * @param columnName as String.
     * @return the value contained in a row.
     */
    private static String getDataOfASpecificColumn(final ResultSet resultSet, final String columnName) {
        String columnData = "";
        try {
            resultSet.first();
            columnData = resultSet.getString(columnName);
        } catch (SQLException ex) {
            LOGGER.error("Error trying to get data in a column, exception:", ex);
        }
        return columnData;
    }

    /**
     * Gets the values in a map as a query condition.
     *
     * @param map contains values to convert as query filter format.
     * @return the query condition as string.
     */
    private static String getValuesAsACondition(final Map<String, String> map) {
        List<String> conditions = map.entrySet().stream()
                .map(e -> String.format(FILTER_FORMAT, e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        return String.join(ReservedWords.AND.val(), conditions);
    }
}
