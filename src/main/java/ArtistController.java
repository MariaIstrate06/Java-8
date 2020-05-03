import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ArtistController implements ArtistDAOPattern{
    Database database;

    public ArtistController() {
        database = database.getInstance();
    }

    public void create(String name, String country) {
        try {
            PreparedStatement statement = database.connection.prepareStatement("insert into artists (name, country) values (?,?)");
            statement.setString(1,name);
            statement.setString(2, country);
            int rowsInserted;
            rowsInserted = statement.executeUpdate();
            System.out.println(String.format("Number of rows inserted %d", rowsInserted));
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }
    public Artists findByName(String name) throws NullPointerException {
        Artists lastArtist = null;
        try {
            PreparedStatement statement = database.connection.prepareStatement("SELECT * FROM artists WHERE name=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lastArtist = new Artists(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                System.out.println(lastArtist);
            }
            return lastArtist;
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return lastArtist;
    }
}