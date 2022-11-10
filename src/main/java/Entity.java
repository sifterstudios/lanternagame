public class Entity {

    private Position position;

    public Entity() {
        this.position = new Position(0,0);
    }

    public Entity(Position position) {
        this.position = position;
    }


    // kan bruke en int[] for å get/set x/y samtidig


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
