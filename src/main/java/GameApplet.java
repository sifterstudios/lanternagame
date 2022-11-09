import java.applet.Applet;
import java.io.IOException;

public class GameApplet extends Applet {
    private final Game game = new Game();

    public void init() {

    }

    public void start() {
        try {
            game.start();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        game.stop();
    }
}
