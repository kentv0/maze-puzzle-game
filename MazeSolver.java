import data_structures.LinearList;
import data_structures.LinearListADT;
import data_structures.Queue;
import data_structures.Stack;

/**
 * The MazeSolver Class for {@link MazeGrid.class} using the doubly linked list
 * implementation with stack and queue.
 *
 * @version     0.1.0 01 Nov 2015
 * @author      Kent Vo
 */
public class MazeSolver {
/* This Class finds the shortest route (if one exists) through a randomly
 * generated maze. */

	private MazeGrid grid;
	private Queue<GridCell> queue = new Queue<GridCell>();
	private Stack<GridCell> stack = new Stack<GridCell>();
	private int dimension;
	
    /**
     * Set the number of GridCell for the {@link MazeGrid.class}.
     *
     * @param dimension the number of GridCell across and down.
     */
	public MazeSolver(int dimension) {
		grid = new MazeGrid(this, dimension);
		this.dimension = dimension;
	}
	
    /**
     * Mark each reachable and available GridCell.
     */
	public void mark() {
		// Enqueue the origin GridCell at the yellow starting point.
		GridCell originCell = grid.getCell(0, 0);
		originCell.setDistance(0);
		queue.enqueue(originCell);
		grid.markDistance(originCell);
		while(!queue.isEmpty()) {
            // Dequeue the current GridCell.
			GridCell currentCell = queue.dequeue();
			int x = currentCell.getX();
			int y = currentCell.getY();
			int distance = currentCell.getDistance();
			
			/* Run the breadth first algorithm, marking the distance from the
             * origin in each adjacent GridCell, then enqueue it. */
			GridCell nextCell = grid.getCell(x, y + 1);
			if((grid.isValidMove(nextCell)) && (!nextCell.wasVisited())) {
				nextCell.setDistance(distance + 1);
				grid.markDistance(nextCell);
				queue.enqueue(nextCell);
			}
			nextCell = grid.getCell(x + 1, y);

			if((grid.isValidMove(nextCell)) && (!nextCell.wasVisited())) {
				nextCell.setDistance(distance + 1);
				grid.markDistance(nextCell);
				queue.enqueue(nextCell);
			}
			nextCell = grid.getCell(x, y - 1);

			if((grid.isValidMove(nextCell)) && (!nextCell.wasVisited())) {
				nextCell.setDistance(distance + 1);
				grid.markDistance(nextCell);
				queue.enqueue(nextCell);
			}
			nextCell = grid.getCell(x - 1, y);

			if((grid.isValidMove(nextCell)) && (!nextCell.wasVisited())) {
				nextCell.setDistance(distance + 1);
				grid.markDistance(nextCell);
				queue.enqueue(nextCell);
			}
		}
	}
	
    /**
     * Push each GridCell with minimum distance onto the stack.
     */
	public boolean move() {
        // Start from the GridCell at the green exit point.
		GridCell exitCell = grid.getCell(dimension - 1, dimension - 1);
        
        // Cannot solve puzzle with an unreachable exit.
		if(exitCell.getDistance() == -1) {
			return false;
		}
		stack.push(exitCell);
		
		while(stack.peek().getDistance() != 0) {
            // Get distance of each GridCell adjacent to the top of the stack.
			GridCell currentCell = stack.peek();
			int x = currentCell.getX();
			int y = currentCell.getY();
			int distance = currentCell.getDistance();
			
            // Select GridCell with smallest distance and push onto the stack.
			GridCell nextCell = grid.getCell(x, y + 1);
			if((grid.isValidMove(nextCell)) && (nextCell.getDistance() < distance)) {
				stack.push(nextCell);
				continue;
			}
			nextCell = grid.getCell(x + 1, y);

			if((grid.isValidMove(nextCell)) && (nextCell.getDistance() < distance)) {
				stack.push(nextCell);
				continue;
			}
			nextCell = grid.getCell(x, y - 1);

			if((grid.isValidMove(nextCell)) && (nextCell.getDistance() < distance)) {
				stack.push(nextCell);
				continue;
			}
			nextCell = grid.getCell(x - 1, y);

			if((grid.isValidMove(nextCell)) && (nextCell.getDistance() < distance)) {
				stack.push(nextCell);
				continue;
			}
		}

        // Pop the stack and mark all the GridCell in the shortest path.
		while(!stack.isEmpty()) {
			grid.markMove(stack.pop());
		}
		return true;
	}

    /**
     * Return the stack and queue to an empty state.
     */
	public void reset() {
		queue.makeEmpty();
		stack.makeEmpty();
	}

	public static void main(String[] args) {
		new MazeSolver(50);
	}
}
