import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private final String user = "maria";
    private final String pass = "lucky13";
    private final String link = "jdbc:mysql://localhost:3306/music_albums";
    public Connection connection;
    private Database(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(link, user, pass);
        }
        catch (ClassNotFoundException exc){
            System.out.println(exc);
        }
        catch(SQLException exp){
            System.out.println(exp);
        }
    }

    public static Database getInstance(){
        if(instance == null)
            instance = new Database();
        return instance;
    }

}
