import java.sql.Connection;

public class Database {
    private static Database db;
    private final String db_username="dba";
    private final String db_pass = "sql";
    private final String db_conn_string="//";
    public Connection dbConnection;

    public Database(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
