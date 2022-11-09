public class CollisionChecker {

    public boolean hasColide(int playerX,int playerY,int monsterX, int monsterY)
    {
        System.out.println("player : " + playerX + "," + playerY);
        System.out.println("monster : " + monsterX + "," + monsterY);
        return (playerX==monsterX &&playerY==monsterY) ;
    }


    //check if collision method



    // if collision true - take damage method

}
