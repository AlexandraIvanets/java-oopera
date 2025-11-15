package show;

import persons.Actor;
import persons.Director;

import java.util.ArrayList;

public class Show {
    private final String title;
    private final int duration;
    private final Director director;
    private final ArrayList<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }

    public void printListOfActors() {
        System.out.println("Actors of the " + getClass().getSimpleName() + " \"" + title + "\":");
        for (Actor actor : listOfActors) {
            System.out.println(actor);
        }
    }

    public void addActor(Actor actor) {
        if (actor == null) {
            System.out.println("Incorrect actor data.");
            return;
        }
        if (listOfActors.contains(actor)) {
            System.out.println("The actor " + actor.getSurname() + " is already in the " +
                    getClass().getSimpleName() + " \"" + title + "\".");
        } else {
            listOfActors.add(actor);
            System.out.println("Actor " + actor.getSurname() + " has been successfully added to the " +
                    getClass().getSimpleName() + " \"" + title + "\".");
        }
    }

    public void replaceActor(Actor newActor, String surnameOfReplacedActor) {
        if (newActor == null || surnameOfReplacedActor == null) {
            System.out.println("Incorrect actor data.");
            return;
        }
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor actor = listOfActors.get(i);
            if (actor.getSurname().equalsIgnoreCase(surnameOfReplacedActor)) {
                listOfActors.set(i, newActor);
                System.out.println("Actor: " + surnameOfReplacedActor + " has been replaced by " +
                        newActor.getSurname() + " in the " + getClass().getSimpleName() + " \"" + title + "\".");
                return;
            }
        }
        System.out.println("There is no actor with that last name: " + surnameOfReplacedActor);
    }
}
