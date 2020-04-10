public interface ArtistDAOPattern {
    void create(String name, String country);
    Artist findByName(String name);
}
