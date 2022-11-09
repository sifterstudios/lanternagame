public class Player extends Entity{

    public final char playerChar = 'O';

    private static final Player instance = new Player();

    public static Player getInstance() {
        return instance;
    }
}
