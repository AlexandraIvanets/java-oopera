package show;

import persons.Choreographer;
import persons.Director;
import persons.MusicAuthor;


public class Ballet extends MusicalShow {
    private final Choreographer choreographer;

    public Ballet(String title, int duration, Director director, MusicAuthor musicAuthor,
                  String librettoText, Choreographer choreographer) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }
}
