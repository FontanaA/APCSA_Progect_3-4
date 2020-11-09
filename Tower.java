//location 2
public class Tower {
    private String description;
    public Boolean door;

    public Tower() {
        door = false;// door = false is closed door = true is open
        description = "On the path guarding a crossroads, you see:\n a tall crumbling tower, broken down due to time. ";
    }

    public String toString() {
        return("Tower:\n" + description );
    }
}