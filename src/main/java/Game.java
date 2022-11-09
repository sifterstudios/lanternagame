import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    CollisionChecker collisionChecker = new CollisionChecker();
    public void run() throws IOException, InterruptedException {
        Sound.music.playLooped();
        Terminal t = GameTerminal.getInstance().t;
        var Monsters = MonsterSpawner.getInstance().allAlive;
        var p = Player.getInstance();

        p.setX(t.getTerminalSize().getColumns()/2);
        p.setY(t.getTerminalSize().getRows()/2);
        Monster mon1 = new Monster();

        t.setCursorVisible(false);
        KeyStroke keyStroke;

        new Thread(){
        }.start();

        while (true) {

            do {
                Thread.sleep(5); // might throw InterruptedException
                keyStroke = t.pollInput();
            } while (keyStroke == null);

            switch (keyStroke.getCharacter()) {
                case 'w':
                    if (p.getY() > 1) {
                        p.setY(p.getY() - 1);
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mon1.getX(),mon1.getY() ) )
                            System.out.println("wwwwww");// gameover
                    }
                    break;
                case 's':
                    if (p.getY() < t.getTerminalSize().getRows() - 1) {
                        p.setY(p.getY() + 1);
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mon1.getX(),mon1.getY() ) )
                            System.out.println("ssssss");
                    }
                    break;
                case 'a':
                    if (p.getX() > 1) {
                        p.setX(p.getX() - 1);
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mon1.getX(),mon1.getY() ) )
                            System.out.println("aaaaaaaa");
                    }
                    break;
                case 'd':
                    if (p.getX() < t.getTerminalSize().getColumns() - 1) {
                        p.setX(p.getX() + 1);
                        Sound.walk.play();
                        if(collisionChecker.hasColide(p.getX(),p.getY(),mon1.getX(),mon1.getY() ) )
                            System.out.println("dddddddd");
                    }
                    break;
            }
            t.clearScreen();

            //monster(s)
            mon1.FollowPlayer(p.getX(), p.getY());
            t.setCursorPosition(mon1.getX(), mon1.getY());
            t.putCharacter(mon1.monsterChar);


            //p
            t.setCursorPosition(p.getX(), p.getY());
            t.putCharacter(p.playerChar);

            t.flush();

        }
    }
}
