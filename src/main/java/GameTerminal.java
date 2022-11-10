import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class GameTerminal {
    DefaultTerminalFactory d;
    Terminal t;





    public static final GameTerminal instance;

    static {
        try {
            instance = new GameTerminal();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GameTerminal() throws IOException {
        d = new DefaultTerminalFactory();
        t = d.createTerminal();
    }

    public static GameTerminal getInstance() {
        return instance;
    }

   

}
