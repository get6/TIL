import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private int year;
    private Artist artist;
    private List<Song> songs;

    public Album(String name, int year, Artist artist) {
        this.name = name;
        this.year = year;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public void addTrack(Song song) {
        songs.add(song);
    }

    public Song getTrack(int num) {
        return songs.get(num - 1);
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
