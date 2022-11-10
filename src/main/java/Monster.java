import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.util.Random;

public class Monster extends Entity {

    public final char monsterChar = '៙';
    public TextColor color = TextColor.ANSI.RED;
    private final int minDistanceFromPlayer = 7;


    public Monster(Position position) {
        super(position);
    }

    public Monster() throws IOException {
        getRandomPosition();
    }

    private void getRandomPosition() throws IOException {
        int playerX = Player.getInstance().getPosition().getX();
        int playerY = Player.getInstance().getPosition().getY();

        if (playerX < minDistanceFromPlayer) {
            playerX = minDistanceFromPlayer + 3;
        }
        if (playerY < minDistanceFromPlayer) {
            playerY = minDistanceFromPlayer + 3;
        }

        Random rd = new Random();
        boolean abovePlayer = rd.nextBoolean();
        boolean leftOfPlayer = rd.nextBoolean();

        int x = rd.nextInt(GameTerminal.getInstance().t.getTerminalSize().getColumns());
        int y = rd.nextInt(GameTerminal.getInstance().t.getTerminalSize().getRows());

        setPosition(new Position(x, y));
    }


    // random number gen for x/y position

    // pathfinding

    private int stepTimer = 0;

    public void FollowPlayer(Position position) {
        //metode kalles av monster objekt med arg player.pos

        if (stepTimer > 2) {
            int mx = super.getPosition().getX();
            int my = super.getPosition().getY();
            int px = position.getX();
            int py = position.getY();


            if (px > mx) {
                mx++;
            } else if (position.getX() < mx) {
                mx--;
            }
            if (py > my) {
                my++;
            } else if (py < my) {
                my--;
            }
            super.setPosition(new Position(mx,my));
            stepTimer = 0;
        }
        stepTimer++;
    }
}
