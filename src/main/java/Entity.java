public class Entity {

    private int x;
    private int y;



    public Entity(int x, int y) {
        this. x = x;
        this. y = y;
    }



    // kan bruke en int[] for å get/set x/y samtidig


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
