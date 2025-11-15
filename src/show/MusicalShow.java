package show;

import persons.Director;
import persons.MusicAuthor;


public class MusicalShow extends Show {
    private final MusicAuthor musicAuthor;
    private final String librettoText;

    public MusicalShow(String title, int duration, Director director, MusicAuthor musicAuthor, String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibrettoText() {
        System.out.println("=== Libretto ===");
        System.out.println(librettoText);
    }
}
