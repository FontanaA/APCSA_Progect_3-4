//location = 5
public class House {
    public Boolean door;
    private String description;

    public House() {
        description = "You approach a house with a locked door";
        door = false;
    }

    public String toString() {
        return("House:\n" + description);
    }
}
