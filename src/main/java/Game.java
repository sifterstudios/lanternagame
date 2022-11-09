import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    public void run() throws IOException, InterruptedException {
        Sound.music.playLooped();
        Terminal t = GameTerminal.getInstance().t;

        Player.getInstance().setX(t.getTerminalSize().getColumns()/2);
        Player.getInstance().setY(t.getTerminalSize().getRows()/2);
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
                    if (Player.getInstance().getY() > 1) {
                        Player.getInstance().setY(Player.getInstance().getY() - 1);
                        Sound.walk.play();
                    }
                    break;
                case 's':
                    if (Player.getInstance().getY() < t.getTerminalSize().getRows() - 1) {
                        Player.getInstance().setY(Player.getInstance().getY() + 1);
                        Sound.walk.play();
                    }
                    break;
                case 'a':
                    if (Player.getInstance().getX() > 1) {
                        Player.getInstance().setX(Player.getInstance().getX() - 1);
                        Sound.walk.play();
                    }
                    break;
                case 'd':
                    if (Player.getInstance().getX() < t.getTerminalSize().getColumns() - 1) {
                        Player.getInstance().setX(Player.getInstance().getX() + 1);
                        Sound.walk.play();
                    }
                    break;
            }
            t.clearScreen();

            //monster(s)
            mon1.FollowPlayer(Player.getInstance().getX(), Player.getInstance().getY());
            t.setCursorPosition(mon1.getX(), mon1.getY());
            t.putCharacter(mon1.monsterChar);


            //Player.getInstance()
            t.setCursorPosition(Player.getInstance().getX(), Player.getInstance().getY());
            t.putCharacter(Player.getInstance().playerChar);

            t.flush();

        }
    }

    public void stop() {
    }

    public void start() throws IOException, InterruptedException {
        run();
    }
}
