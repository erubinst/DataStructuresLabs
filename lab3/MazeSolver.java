//Esme Rubinstein
import java.util.ArrayList;

public abstract class MazeSolver {
    private Maze maze = null;
    // want to make a new worklist by calling the abstract method makeEmpty

    public abstract void makeEmpty();

    public abstract boolean isEmpty();

    public abstract void add(Square sq);

    public abstract Square next();

    public MazeSolver(Maze maze) {
	this.maze = maze;
	makeEmpty();
	add(maze.getStart());
    }

    public boolean isSolved() {
	return maze.getFinish().getSolution();
    }

    public String getPath() {
	Square sq = maze.getFinish();
	String result = "";
	while (true) {
	    sq.setSolution(true);
	    result = "[" + sq.getRow() + "," + sq.getCol() + "] " + result;
	    if (sq == maze.getStart()) {
		break;
	    } else {
		sq = sq.getMark();
	    }
	}
	return result;
    }

    public Square step() {
	Square next = null;
	if (isEmpty()) {
	    System.out.println("No Solution.");
	} else {
	    next = next();
	    if (next == maze.getFinish()) {
		System.out.print("The path is ");
		System.out.println(getPath());
	    } else {
		ArrayList<Square> neighbors = maze.getNeighbors(next);
		for (int i = 0; i < neighbors.size(); i++) {
		    Square sq = neighbors.get(i);
		    if ((sq.getType() != Square.wall) && (sq != maze.getStart()) && (sq.getMark() == null)) {
			sq.setMark(next);
			add(sq);
		    }
		}
		next.setExplored(true);
	    }
	}
	return next;
    }

    public void solve() {
	Square sq = null;
	while((sq != maze.getFinish()) && (isEmpty() == false) ) {
	    sq = step();
	}
	System.exit(1);

    }

}