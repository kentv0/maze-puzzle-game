/**
 * The GridCell Class encapsulates information about each cell in the
 * {@link MazeGrid.class}.
 *
 * @version     0.1.0 01 Nov 2015
 * @author      Alan Riggins
 */
public class GridCell {
    private int xCoordinate, yCoordinate, distanceFromOrigin;
    
    // Constructor should be called **ONLY** from the MazeGrid class
    // Distance is always set to -1, which indicates that it is
    // undefined. It must be set explicitly by a call to setDistance().
    public GridCell(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
        distanceFromOrigin = -1;
    }

    // Sets the distance of this cell from the origin [0,0]
    public void setDistance(int d) {
        distanceFromOrigin = d;
    }
    
    // Returns the distance of this cell from the origin [0,0]. If the distance
    // has not been set, returns -1
    public int getDistance() {
        return distanceFromOrigin;
    }
 
    // Sets the X coordinate to the cell
    private void setX(int x) {
        xCoordinate = x;
    }

    // Sets the Y coordinate to the cell
    private void setY(int y) {
        yCoordinate = y;
    }
    
    // Returns the X coordinate of this cell
    public int getX() {
        return xCoordinate;
    }

    // Returns the Y coordinate of this cell
    public int getY() {
        return yCoordinate;
    }
        
    // Returns true if this cell has been visited, otherwise false
    public boolean wasVisited() {
        return distanceFromOrigin != -1;
    }
    
    // Returns the string format for the X and Y coordinates
    public String toString() {
        return "X: " + xCoordinate + "   Y: " + yCoordinate;
    }
    
    // Verifies the X and Y coordinates
    public boolean equals(GridCell c) {
        return c.xCoordinate == xCoordinate && c.yCoordinate == yCoordinate;
    }
}
