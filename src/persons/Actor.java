package persons;

import java.util.Objects;

public class Actor extends Person {
    private final int height;

    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Actor actor = (Actor) object;
        return Objects.equals(getName(), actor.getName())
                && Objects.equals(getSurname(), actor.getSurname())
                && height == actor.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), height);
    }

    @Override
    public String toString() {
        return "Full name: " + getName() + ' ' + getSurname() + " (Height: " + height + ")";
    }
}
