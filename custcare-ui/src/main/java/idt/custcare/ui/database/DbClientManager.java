package idt.custcare.ui.database;

import idt.custcare.ui.config.EnvironmentManager;
import idt.custcare.ui.config.ReservedWords;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EnumMap;
import org.apache.commons.dbutils.DbUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

/**
 * DbClientManager class.
 */
public final class DbClientManager {
    private static final Logger LOGGER = LogManager.getLogger(DbClientManager.class.getSimpleName());
    private static final String NON_SELECT_QUERY_REGEX = "(delete|insert|update)(.+)";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static int affectedRows;

    /**
     * Private constructor.
     */
    private DbClientManager() {
    }

    /**
     * Establishes a connection to a specific database.
     *
     * @param dataBaseName object with database properties.
     */
    public static void establishDatabaseConnection(final DataBases dataBaseName) {
        try {
            DataBase dataBase = configDbClient(dataBaseName);
            connection = DriverManager.getConnection(dataBase.getUrlFormat());
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            LOGGER.error("Cannot establish database connection");
            LOGGER.info(e.getMessage());
        }
    }

    /**
     * Runs a query to get data from Database.
     *
     * @param query to be executed.
     */
    public static void executeQuery(final String query) {
        try {
            if (query.matches(NON_SELECT_QUERY_REGEX)) {
                affectedRows = statement.executeUpdate(query);
            } else {
                resultSet = statement.executeQuery(query);
            }
        } catch (SQLException e) {
            LOGGER.error("Cannot execute query");
            LOGGER.info(e.getMessage());
        }
    }

    /**
     * Gets the result set attribute.
     *
     * @return a result set object.
     */
    public static ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * Gets the affected rows attribute.
     *
     * @return affectedRows int.
     */
    public static int getAffectedRows() {
        return affectedRows;
    }

    /**
     * Closes the all the database connection objects.
     */
    public static void closeConnection() {
        DbUtils.closeQuietly(resultSet);
        DbUtils.closeQuietly(statement);
        DbUtils.closeQuietly(connection);
    }

    /**
     * Builds and returns a Database object using the environment parameters.
     *
     * @param databaseName as Databases type.
     * @return The Database instantiate object.
     */
    private static DataBase configDbClient(final DataBases databaseName) {
        JSONObject dbInfo = EnvironmentManager.getInstance().getDatabaseConfig(databaseName);
        DataBase database = getDatabaseClient((String) dbInfo.get(ReservedWords.TYPE.val()));
        database.setHostname((String) dbInfo.get(ReservedWords.HOST.val()));
        database.setPort((String) dbInfo.get(ReservedWords.PORT.val()));
        database.setUsername((String) dbInfo.get(ReservedWords.USER.val()));
        database.setPassword((String) dbInfo.get(ReservedWords.PASSWORD.val()));
        database.setDbName((String) dbInfo.get(ReservedWords.SERVICE_NAME.val()));
        return database;
    }

    /**
     * Instantiates and gets a Database of specific type.
     *
     * @param dbType The Database type String representation.
     * @return A Database object.
     */
    private static DataBase getDatabaseClient(final String dbType) {
        EnumMap<DataBaseTypes, DataBase> map = new EnumMap<>(DataBaseTypes.class);
        map.put(DataBaseTypes.ORACLE, new OracleDataBase());
        return map.get(DataBaseTypes.valueOf(dbType.toUpperCase()));
    }
}
