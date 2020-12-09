//Esme Rubinstein
public class MazeSolverStack extends MazeSolver {

    private MyStack<Square> stack;

    public MazeSolverStack(Maze maze) {
	super(maze);
    }

    public void makeEmpty() {
	stack = new MyStack<Square>();
    }

    public boolean isEmpty() {
	return stack.isEmpty();
    }

    public void add(Square sq) {
	stack.push(sq);
    }

    public Square next() {
	return stack.pop();
    }

    public static void main(String[] args) {
	Maze maze = new Maze();
	maze.loadMaze(args[0]);
	maze.printMaze();
	MazeSolverStack solver = new MazeSolverStack(maze);
	solver.solve();
    }

}
