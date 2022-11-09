import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Walls {


    /*
    static final char block = '\u2588';
    static List<Position> positions = new ArrayList<>() ;


    public static List<Position> drawTheWall() throws IOException {


        for (int i =0; i < 159; i++) {
            Position p = new Position(i, 0);
            positions.add(p);

        }
        for (int i = 0; i < 80; i++) {
            Position p = new Position(0, i);
            positions.add(p);

        }
        for (int i = 0; i < 159; i++) {
            Position p = new Position(i, 42);
            positions.add(p);

        }
        for (int i = 0; i < 80; i++) {
            Position p = new Position(159, i);
            positions.add(p);
        }

        //the rocks
        for (int i = 10; i < 15; i++) {
            for (int j=10;j<13;j++) {
                Position p = new Position(i, j);
                positions.add(p);
            }
        }
        for (int i = 45; i < 50; i++) {
            for (int j=33;j<36;j++) {
                Position p = new Position(i, j);
                positions.add(p);
            }
        }
        positions.add( setRock(45,15,10,5) );


        return positions;


    }
    public static  Position  setRock(int x,int y, int sizeX,int sizeY)
    {
        for (int i = 10; i < 15; i++) {
            for (int j=10;j<13;j++) {
                Position p = new Position(i, j);
                return p ;
            }
        }
        return null ;
    }
    public static void setWalls(Terminal terminal) throws IOException {
        List<Position> p = drawTheWall();
        for (int i=0;i<p.size();i++)
        {
            terminal.setCursorPosition(p.get(i).getX(),p.get(i).getY() );
            terminal.putCharacter(block);
            terminal.flush();
        }

    }
    public static boolean isWall(int x,int y) throws IOException {
        List<Position> p = drawTheWall();
        for (int i=0;i<p.size();i++)
        {
            if(p.get(i).getX()== x && p.get(i).getY()==y)
                return true ;
        }
        return false ;

    }

     */


}
