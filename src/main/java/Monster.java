public class Monster extends Entity{

    public final char monsterChar = 'X';




    public Monster(int x, int y) {
        super(x, y);
    }


    // random number gen for x/y position


    // pathfinding

    private int stepTimer = 0;
    public void monFlwPlayer(int playerX, int playerY) {

        if (stepTimer > 2) {
            if (playerX > super.getX()) {
                super.setX(super.getX()+1);
            }
            else if (playerX < super.getX()) {
                super.setX(super.getX()-1);
            }

            if (playerY > super.getY()) {
                super.setY(super.getY()+1);
            }
            else if (playerY < super.getY()) {
                super.setY(super.getY()-1);
            }
            stepTimer = 0;
            Sound.walk.play();
        }
        stepTimer++;

    }
}
