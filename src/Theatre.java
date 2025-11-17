import persons.*;
import show.Ballet;
import show.Opera;
import show.Show;

public class Theatre {
    private static final String LINE_BREAKER = "-".repeat(75);

    public static void main(String[] args) {
        Actor DiCaprio = new Actor("Leonardo", "DiCaprio", Gender.MALE, 181);
        Actor Kidman = new Actor("Nicole", "Kidman", Gender.FEMALE, 180);
        Actor Hemsworth = new Actor("Chris", "Hemsworth", Gender.MALE, 190);
        Director Bigelow = new Director("Kathryn", "Bigelow", Gender.FEMALE, 20);
        Director Scorsese = new Director("Martin", "Scorsese", Gender.MALE, 30);
        MusicAuthor Zimmer = new MusicAuthor("Hans", "Zimmer", Gender.MALE);
        Choreographer Baryshnikov = new Choreographer("Mikhail", "Baryshnikov", Gender.MALE);

        String librettoOfCarmen = """
                On the square
                everyone comes by,
                everyone comes and goes;
                funny sort of people these!""";

        String librettoOfNutcracker = """
                It is Christmas Eve in a small town in Germany, in the 1820s. In the town square,
                the mysterious Drosselmeier presents a performance in his Children’s Street
                Theatre and then hurries off to the Silberhaus’ Christmas party with his gifts.""";

        Show showWe = new Show("We", 130, Bigelow);
        Opera operaCarmen = new Opera("Carmen", 145,
                Bigelow, Zimmer, librettoOfCarmen, 5);
        Ballet balletTheNutcracker = new Ballet("The nutcracker", 121,
                Scorsese, Zimmer, librettoOfNutcracker, Baryshnikov);

        showWe.addActor(Kidman);
        showWe.addActor(DiCaprio);
        operaCarmen.addActor(Hemsworth);
        operaCarmen.addActor(DiCaprio);
        operaCarmen.addActor(Kidman);
        balletTheNutcracker.addActor(Hemsworth);
        balletTheNutcracker.addActor(Kidman);
        System.out.println(LINE_BREAKER);

        showWe.printListOfActors();
        operaCarmen.printListOfActors();
        balletTheNutcracker.printListOfActors();
        System.out.println(LINE_BREAKER);

        System.out.println("Checking for adding an existing actor");
        showWe.addActor(Kidman);
        showWe.printListOfActors();
        System.out.println(LINE_BREAKER);

        System.out.println("Checking for replacement");
        showWe.replaceActor(Hemsworth, "Kidman");
        showWe.printListOfActors();
        System.out.println(LINE_BREAKER);

        System.out.println("Checking for replacement of a non-existent actor");
        showWe.replaceActor(Kidman, "Depp");
        showWe.printListOfActors();
        System.out.println(LINE_BREAKER);

        operaCarmen.printLibrettoText();
        System.out.println(LINE_BREAKER);
        balletTheNutcracker.printLibrettoText();
        System.out.println(LINE_BREAKER);
    }
}
