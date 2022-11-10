import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    CollisionChecker collisionChecker = new CollisionChecker();
    public void run() throws IOException, InterruptedException {
//        Sound.music.playLooped();
        Terminal t = GameTerminal.getInstance().t;
        var monsters = MonsterSpawner.getInstance().allAlive;
        var p = Player.getInstance();

        p.setX(t.getTerminalSize().getColumns()/2);
        p.setY(t.getTerminalSize().getRows()/2);
        monsters.add(new Monster());

        t.setCursorVisible(false);
        KeyStroke keyStroke;


        while (!isDead) {

            do {
                Thread.sleep(5); // might throw InterruptedException
                keyStroke = t.pollInput();
                MonsterSpawner.getInstance().spawnTimer();

                tick += 5;
                for (Monster monster : MonsterSpawner.getInstance().allAlive) {
                    if (tick > 500) {
                        monster.FollowPlayer(p.getPosition());
                        updateScreen(GameTerminal.getInstance().t, score);
                    }
                }
                if (tick > 500) {
                    score.incrementScore();
                    tick = 0;
                }

                for (Monster monster : MonsterSpawner.getInstance().allAlive) {
                    if (collisionChecker.hasCollided(monster.getPosition(), Player.getInstance().getPosition())) {
                        isDead = true;
                        break;
                    }
                }

            } while (keyStroke == null && !isDead);

            int px = p.getPosition().getX();
            int py = p.getPosition().getY();
            //assert keyStroke != null;
            if (keyStroke.getCharacter() == null) break;
            switch (keyStroke.getCharacter()) {

                case 'w':
                    if (py > 3) {
                        p.setPosition(new Position(px, py - 1));
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mToArray[0].getX(),mToArray[0].getY() ) )
                            System.out.println("wwwwww");// gameover
                    }
                    break;
                case 's':
                    if (py < t.getTerminalSize().getRows() - 1) {
                        p.setPosition(new Position(px, py + 1));
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mToArray[0].getX(),mToArray[0].getY() ) )
                            System.out.println("ssssss");
                    }
                    break;
                case 'a':
                    if (px > 1) {
                        p.setPosition(new Position(px - 1, py));
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mToArray[0].getX(),mToArray[0].getY() ) )
                            System.out.println("aaaaaaaa");
                    }
                    break;
                case 'd':
                    if (px < t.getTerminalSize().getColumns() - 1) {
                        p.setPosition(new Position(px + 1, py));
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mToArray[0].getX(),mToArray[0].getY() ) )
                            System.out.println("dddddddd");
                    }
                    break;
            }
            updateScreen(t, score);
        }

        t.clearScreen();
        t.setCursorPosition((t.getTerminalSize().getColumns() / 2) - 4, t.getTerminalSize().getRows() / 2);
        t.putString("GAME OVER");
        t.flush();
        Sound.death.play();
    }
}
