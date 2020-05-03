

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumController implements AlbumDAOPattern {
    Database database;

    public AlbumController() {
        database = Database.getInstance();
    }

    public void create(String name, int artistID, int releaseYear){
        try{
           // Statement statement = database.connection.createStatement();
            //String query = String.format("INSERT INTO albums (name, artist_id, release_year) VALUES ('%s',%d,%d)",name, artistID, releaseYear);
            PreparedStatement statement = database.connection.prepareStatement("insert into albums (name, artist_id, release_year) values (?,?,?)");
            statement.setString(1,name);
            statement.setInt(2, artistID);
            statement.setInt(3, releaseYear);
            int rowsInserted;
            rowsInserted = statement.executeUpdate();
            System.out.println(String.format("Number of rows inserted %d",rowsInserted));
        }
        catch (SQLException exp){
            exp.printStackTrace();
        }
    }
    public List<Album> findByArtist(int artistID) throws NullPointerException{
        ArrayList<Album> albums = new ArrayList<Album>();
        try{
            Statement statement = database.connection.createStatement();
            String query = String.format("SELECT * FROM albums WHERE artist_id=%d", artistID);
            ResultSet set = statement.executeQuery(query);
            while(set.next()) {
                albums.add(new Album(set.getInt(1), set.getInt(2), set.getInt(3), set.getString(4)));
            }
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        return albums.isEmpty() ? null : albums;

    }
}
