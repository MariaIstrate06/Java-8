import java.util.List;

public interface ArtistDAOPattern {
    void create(String name, String country);
    Artists findByName(String name);
}
