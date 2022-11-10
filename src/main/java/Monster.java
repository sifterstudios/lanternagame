import java.io.IOException;
import java.util.Random;

public class Monster extends Entity {

    public final char monsterChar = 'X';
    private final int minDistanceFromPlayer= 7;


    public Monster(int x, int y) {
        super(x, y);
    }
    public Monster() throws IOException {
        getRandomPosition();
    }

    private void getRandomPosition() throws IOException {
        int playerX = Player.getInstance().getPosition().getX();
        int playerY = Player.getInstance().getPosition().getY();

        if (playerX < minDistanceFromPlayer) {
            playerX = minDistanceFromPlayer + 3;
        }if (playerY < minDistanceFromPlayer) {
            playerY = minDistanceFromPlayer + 3;
        }

        Random rd = new Random();
        boolean abovePlayer = rd.nextBoolean();
        boolean leftOfPlayer = rd.nextBoolean();

        setX(leftOfPlayer ? rd.nextInt(playerX - minDistanceFromPlayer)
                : rd.nextInt(playerX + minDistanceFromPlayer, GameTerminal.getInstance().t.getTerminalSize().getColumns()));
        setY(abovePlayer ? rd.nextInt(playerY - minDistanceFromPlayer)
                : rd.nextInt(playerY + minDistanceFromPlayer, GameTerminal.getInstance().t.getTerminalSize().getRows()));

    }


    // random number gen for x/y position

    // pathfinding

    private int stepTimer = 0;

    public void FollowPlayer(int playerX, int playerY) {

        if (stepTimer > 2) {
            if (playerX > super.getX()) {
                super.setX(super.getX() + 1);
            } else if (playerX < super.getX()) {
                super.setX(super.getX() - 1);
            }

            if (playerY > super.getY()) {
                super.setY(super.getY() + 1);
            } else if (playerY < super.getY()) {
                super.setY(super.getY() - 1);
            }
            stepTimer = 0;
        }
        stepTimer++;

    }
}
