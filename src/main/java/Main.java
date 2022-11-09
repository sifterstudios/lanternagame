import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

// importere PLayer og Monster classes?


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{

        DefaultTerminalFactory d = new DefaultTerminalFactory();
        Terminal t = d.createTerminal();



        Monster mon1 = new Monster(10,10);
        Player player = new Player(1,1);

        t.setCursorVisible(false);
        KeyStroke keyStroke = null;
        while (true) {

            do {
                Thread.sleep(5); // might throw InterruptedException
                keyStroke = t.pollInput();
            } while (keyStroke == null);

            if (keyStroke.getCharacter() == 'w') {
                player.setY(player.getY()-1);
            }
            if (keyStroke.getCharacter() == 's') {
                player.setY(player.getY()+1);
            }
            if (keyStroke.getCharacter() == 'a') {
                player.setX(player.getX()-1);
            }
            if (keyStroke.getCharacter() == 'd') {
                player.setX(player.getX()+1);
            }
            t.clearScreen();

            //monster(s)
            mon1.monFlwPlayer(player.getX(), player.getY());
            t.setCursorPosition(mon1.getX(), mon1.getY());
            t.putCharacter(mon1.monsterChar);


            //player
            t.setCursorPosition(player.getX(), player.getY());
            t.putCharacter(player.playerChar);

            t.flush();
        }
    }
}
