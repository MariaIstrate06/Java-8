import java.util.List;

public interface AlbumDAOPattern {
    void create(String name, int artistID, int releaseYear);
    List<Album> findByArtist(int artistID);
}
