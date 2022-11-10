import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MonsterSpawner {
    public final Set<Monster> allAlive = new HashSet<>();
    private static final MonsterSpawner instance = new MonsterSpawner();
    private final int spawnTime = 500;
    private int counter = 0;

    public static MonsterSpawner getInstance() {
        return instance;
    }

    public void spawnTimer() throws IOException {
        if (counter > spawnTime) {
            allAlive.add(new Monster());
            counter=0;
        }
        counter++;
        //System.out.println(counter);
    }
}

