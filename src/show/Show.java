package show;

import persons.Actor;
import persons.Director;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }

    public void printListOfActors() {
        System.out.println("Actors of the " + getTypeName() + " \"" + title + "\":");
        for (Actor actor : listOfActors) {
            System.out.println(actor);
        }
    }

    public void printDirectorInfo() {
        System.out.println(director);
    }

    public void addActor(Actor actor) {
        if (actor == null) {
            System.out.println("Incorrect actor data.");
            return;
        }
        if (listOfActors.contains(actor)) {
            System.out.println("The actor " + actor.getSurname() + " is already in the " +
                    getTypeName() + " \"" + title + "\".");
        } else {
            listOfActors.add(actor);
            System.out.println("Actor " + actor + " has been successfully added to the " +
                    getTypeName() + " \"" + title + "\".");
        }
    }

    public void replaceActor(Actor newActor, String surnameOfReplacedActor) {
        if (newActor == null || surnameOfReplacedActor == null) {
            System.out.println("Incorrect actor data.");
            return;
        }
        if (listOfActors.contains(newActor)) {
            System.out.println("The actor " + newActor.getSurname() + " is already in the " +
                    getTypeName() + " \"" + title + "\".");
            return;
        }
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor actor = listOfActors.get(i);
            if (actor.getSurname().equalsIgnoreCase(surnameOfReplacedActor)) {
                indexes.add(i);
            }
        }
        if (indexes.isEmpty()) {
            System.out.println("There is no actor with that last name: " + surnameOfReplacedActor);
        } else if (indexes.size() == 1) {
            listOfActors.set(indexes.getFirst(), newActor);
            System.out.println("Actor: " + surnameOfReplacedActor + " has been replaced by " +
                    newActor.getSurname() + " in the " + getTypeName() + " \"" + title + "\".");
        } else {
            System.out.println("The show have multiple actors with the same last name:");
            for (int i = 0; i < indexes.size(); i++) {
                System.out.println((i + 1) + " " + listOfActors.get(indexes.get(i)));
            }
            int min = 1;
            int max = indexes.size();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Enter the number of the actor you want to replace from " + min + " to " + max + ":");
                System.out.println("To cancel the replacement, enter -1");
                System.out.print("---> ");
                if (scanner.hasNextInt()) {
                    int userIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (userIndex == -1) {
                        System.out.println("Replacement operation cancelled");
                        return;
                    }
                    if (userIndex >= min && userIndex <= max) {
                        Actor replacedActor = listOfActors.get(indexes.get(userIndex - 1));
                        listOfActors.set(indexes.get(userIndex - 1), newActor);
                        System.out.println("Actor: " + replacedActor + " has been replaced by " +
                                newActor + " in the " + getTypeName() + " \"" + title + "\".");
                        break;
                    } else {
                        System.out.println("The number is out of range.");
                    }
                } else {
                    System.out.println("Error: You must enter an integer.");
                    scanner.nextLine();
                }
            }
        }
    }

    public String getTypeName() {
        return "show";
    }
}
