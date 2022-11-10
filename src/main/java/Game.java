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

        while (true) {

            do {
                Thread.sleep(5); // might throw InterruptedException
                MonsterSpawner.getInstance().spawnTimer();
                keyStroke = t.pollInput();
            } while (keyStroke == null);
            Monster[] mToArray = monsters.toArray(new Monster[monsters.size()]);

            switch (keyStroke.getCharacter()) {
                case 'w':
                    if (p.getY() > 1) {
                        p.setY(p.getY() - 1);
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mToArray[0].getX(),mToArray[0].getY() ) )
                            System.out.println("wwwwww");// gameover
                    }
                    break;
                case 's':
                    if (p.getY() < t.getTerminalSize().getRows() - 1) {
                        p.setY(p.getY() + 1);
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mToArray[0].getX(),mToArray[0].getY() ) )
                            System.out.println("ssssss");
                    }
                    break;
                case 'a':
                    if (p.getX() > 1) {
                        p.setX(p.getX() - 1);
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mToArray[0].getX(),mToArray[0].getY() ) )
                            System.out.println("aaaaaaaa");
                    }
                    break;
                case 'd':
                    if (p.getX() < t.getTerminalSize().getColumns() - 1) {
                        p.setX(p.getX() + 1);
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mToArray[0].getX(),mToArray[0].getY() ) )
                            System.out.println("dddddddd");
                    }
                    break;
            }
            t.clearScreen();

            //monster(s)
            for (Monster monster : monsters) {
                monster.FollowPlayer(p.getX(), p.getY());
                t.setCursorPosition(monster.getX(), monster.getY());
                t.putCharacter(monster.monsterChar);
            }

            //p
            t.setCursorPosition(p.getX(), p.getY());
            t.putCharacter(p.playerChar);

            t.flush();

        }
    }
}
