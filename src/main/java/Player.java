import com.googlecode.lanterna.TextColor;

public class Player extends Entity {

    public char playerChar = '♛';

    public TextColor color = TextColor.ANSI.GREEN;

    private static final Player instance = new Player();

    public static Player getInstance() {
        return instance;
    }

    public Player(Position position) {
        super(position);
    }

    public Player() {
    }
}
