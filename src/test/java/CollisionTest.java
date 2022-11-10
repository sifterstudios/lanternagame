import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollisionTest {
    @Test
    void shouldReturnTrueWhenPositionIsEqual() {
        Position sut = new Position(3,3);
        Player player = new Player(sut);
        Monster monster = new Monster(sut);
        CollisionChecker col = new CollisionChecker();
        assertTrue(col.hasCollided(player.getPosition(), monster.getPosition()));
    }

    @Test
    void shouldReturnFalseWhenPositionsAreDifferent() {
        Position sut = new Position(3,3);
        Position sut2 = new Position(2,3);
        Player player = new Player(sut);
        Monster monster = new Monster(sut2);
        CollisionChecker col = new CollisionChecker();
        assertFalse(col.hasCollided(player.getPosition(), monster.getPosition()));
    }
}
