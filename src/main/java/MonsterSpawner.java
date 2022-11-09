import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MonsterSpawner {
    public final Set<Monster> allAlive = new HashSet<>();
    private static final MonsterSpawner instance = new MonsterSpawner();

    public static MonsterSpawner getInstance() {
        return instance;
    }

    public void spawnTimer() throws InterruptedException, IOException {
        while (true) {
            allAlive.add(new Monster());
            Thread.sleep(5000);
        }
    }

}
