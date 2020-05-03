public class Main {
    public static void main(String[] args){
        AlbumDAOPattern album = new AlbumController();
        ArtistDAOPattern artist = new ArtistController();

        artist.create("My Chemical Romance", "USA");
        artist.create("Adam's Nest", "Romania");
        artist.create("Simple Plan", "Canada");

        album.create("Viktoria", artist.findByName("Adam's Nest").getId(),2006);

        album.create("Get Your Heart On", artist.findByName("Simple Plan").getId(),2013);
        album.create("Still Not Getting Any", artist.findByName("Simple Plan").getId(),2004);
        album.create("No Pads, No Helmets... Just Balls", artist.findByName("Simple Plan").getId(),2002);

        album.create("The Black Parade", artist.findByName("My Chemical Romance").getId(),2006);
        album.create("The Cheers for Sweet Revenge", artist.findByName("My Chemical Romance").getId(),2004);
        album.create("May Death Never Stop You", artist.findByName("My Chemical Romance").getId(),2014);

    }
}
