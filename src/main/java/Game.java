import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    CollisionChecker collisionChecker = new CollisionChecker();
    private boolean isDead = false;

    public void run() throws IOException, InterruptedException {
        Sound.music.playLooped();
        Terminal t = GameTerminal.getInstance().t;
        var monsters = MonsterSpawner.getInstance().allAlive;
        var p = Player.getInstance();
        int tick = 0;
        HighScore score = new HighScore();


        p.setPosition(new Position((t.getTerminalSize().getColumns() / 2), (t.getTerminalSize().getRows() / 2)));
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
                        Sound.music.stop();
                        Sound.death.play();
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
                    }
                    break;
                case 's':
                    if (py < t.getTerminalSize().getRows() - 1) {
                        p.setPosition(new Position(px, py + 1));
                        Sound.walk.play();
                    }
                    break;
                case 'a':
                    if (px > 1) {
                        p.setPosition(new Position(px - 1, py));
                        Sound.walk.play();
                    }
                    break;
                case 'd':
                    if (px < t.getTerminalSize().getColumns() - 1) {
                        p.setPosition(new Position(px + 1, py));
                        Sound.walk.play();
                    }
                    break;
            }
            updateScreen(t, score);
        }

        t.clearScreen();
        t.setCursorPosition(0,0);
        t.putString("HIGHSCORE: " + score.getScore());
        t.setCursorPosition((t.getTerminalSize().getColumns() / 2) - 4, t.getTerminalSize().getRows() / 2);
        t.putString("GAME OVER");
        t.flush();
    }

    public void updateScreen(Terminal t, HighScore score) throws IOException {
        t.clearScreen();
        t.setCursorPosition(0,0);
        t.putString("HIGHSCORE: " + score.getScore());

        for (int i = 1; i < t.getTerminalSize().getRows(); i++) {
            for (int j = 0; j < t.getTerminalSize().getColumns(); j++) {
                if (i == 1) {
                    t.setCursorPosition(j,1);
                    t.putCharacter('▓');
                }
                if (i == t.getTerminalSize().getRows()-1) {
                    t.setCursorPosition(j,t.getTerminalSize().getColumns()-1);
                    t.putCharacter('▓');
                }
                else {
                    t.setCursorPosition(0,i);
                    t.putCharacter('▓');
                    t.setCursorPosition(t.getTerminalSize().getColumns(),i);
                    t.putCharacter('▓');
                }

            }

        }

        for (Monster monster : MonsterSpawner.getInstance().allAlive) {
            if (collisionChecker.hasCollided(monster.getPosition(), Player.getInstance().getPosition())) {
                isDead = true;
                break;
            }
            t.setCursorPosition(monster.getPosition().getX(), monster.getPosition().getY());
            t.putCharacter(monster.monsterChar);
        }

        //p
        t.setCursorPosition(Player.getInstance().getPosition().getX(), Player.getInstance().getPosition().getY());
        t.putCharacter(Player.getInstance().playerChar);

        t.flush();
    }
}
