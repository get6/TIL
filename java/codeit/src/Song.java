public class Song {

    private String name;
    private Artist artist;
    private Album album;

    public Song(String name, Artist artist, Album album) {
        this.name = name;
        this.artist = artist;
        this.album = album;
    }

    @Override
    public String toString() {
        return name + " - " + artist.getName() + "\n" + album.getName() + "(" + album.getYear() + ")";
    }
}
