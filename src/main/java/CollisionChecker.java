public class CollisionChecker {

    public boolean hasCollided(Position monster, Position player)
    {
        int mx = monster.getX();
        int my = monster.getY();
        int px = player.getX();
        int py = player.getY();

        if (mx == px && my == py) {
            System.out.println("---COLLISION---");
            System.out.println("player : " + px + "," + py);
            System.out.println("monster : " + mx + "," + my);
            System.out.println("---------------");
            return true;
        }
            return false;
    }


    //check if collision method



    // if collision true - take damage method

}
