package supple.guard;

public class Room {

    private final int capacity;

    public Room(int capacity) {
        this.capacity = capacity;
    }

    public int capacity() {
        return this.capacity;
    }

}
