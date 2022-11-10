public class Player extends Entity {

    public char playerChar = 'O';

    private Color GREEN;

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
