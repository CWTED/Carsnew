import java.awt.*;

/**
 * An interface that contains methods that enable movement of our cars.
 */
public interface Movable {
    /*enum Direction{
        NORTH, EAST, SOUTH, WEST
    }*/
    //Point currentpoint = new Point();
    void move();
    void turnLeft();
    void turnRight();

}
