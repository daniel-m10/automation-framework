package idt.custcare.ui.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import idt.custcare.ui.database.DataBases;
import idt.custcare.ui.database.DbQueries;
import idt.custcare.ui.utils.DbUtils;

/**
 * Hooks for database operations.
 */
public class DatabaseHooks {

    /**
     * Deletes row with pin equal to 83782422711 and trans_id equal to 'C'.
     */
    @Before(value = "@deleteFromCCHistory")
    public void deleteFromCCHistory() {
        String query = String.format(DbQueries.DELETE_CCHISTORY_HAVING_PIN, "83782422711");
        DbUtils.runQuery(query, DataBases.DEBIT);
        DbUtils.closeCurrentDbClient();
    }

    /**
     * Deletes first row of CC_HISTORY table.
     */
    @After(value = "@deleteFirstRowCCHistory")
    public void deleteFirstRowFromCCHistory() {
        String query = String.format(DbQueries.DELETE_FISRT_ROW_CCHISTORY, "testl5");
        DbUtils.runQuery(query, DataBases.DEBIT);
        DbUtils.closeCurrentDbClient();
    }

    /**
     * Deletes subscription plan.
     */
    @Before(value = "@deleteSubscriberPlan")
    public void deleteSubscriberPlan() {
        String deleteSubscriberQuery = "DELETE SUBSCRIBER_PLAN WHERE CTLNUM = "
                + "(SELECT CTLNUM FROM PARTITIONED_PINTAB WHERE PIN =8760021004)";
        String updatePinTabTableQuery = "UPDATE PINTAB SET STATE='A',EXPIRED_DATE=NULL, BALANCE=500 "
                + "WHERE CTLNUM=760051004";
        String deleteFromTransTable = "DELETE TRANS WHERE CTLNUM = "
                + "(SELECT CTLNUM FROM PARTITIONED_PINTAB WHERE PIN = 8760021004)";
        DbUtils.runQuery(deleteSubscriberQuery, DataBases.DEBIT);
        DbUtils.runQuery(updatePinTabTableQuery, DataBases.DEBIT);
        DbUtils.runQuery(deleteFromTransTable, DataBases.DEBIT);
        DbUtils.closeCurrentDbClient();
    }
}
