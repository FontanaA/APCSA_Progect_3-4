//location = 3
public class Door {
    private String description;
    public Boolean door;

    public Door() {
        door = false;// door = false is closed door = true is open
        description = "You find a rusty door in the side of a cliff";
    }

    public String toString() {
        return("Door:\n" + description );
    }
}