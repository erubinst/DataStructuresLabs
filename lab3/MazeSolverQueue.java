//Esme Rubinstein
public class MazeSolverQueue extends MazeSolver {

    private MyQueue<Square> queue;

    public MazeSolverQueue(Maze maze) {
	super(maze);
    }

    public void makeEmpty() {
	queue = new MyQueue<Square>();
    }

    public boolean isEmpty() {
	return queue.isEmpty();
    }

    public void add(Square sq) {
	queue.enqueue(sq);
    }

    public Square next() {
	return queue.dequeue();
    }
    
    public static void main(String[] args) {
	Maze maze = new Maze();
	maze.loadMaze(args[0]);
	maze.printMaze();
	MazeSolverQueue solver = new MazeSolverQueue(maze);
	solver.solve();
	}

}
