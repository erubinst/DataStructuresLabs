
//Esme Rubinstein
//I affirm that I have adhered to the Honor Code on this assignment.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
    private Square[][] maze;
    private int numRows;
    private int numCols;
    private Square start;
    private Square exit;

    public Maze() {

    }

    public boolean loadMaze(String fname) {
	Scanner mazeFile = null;
	try {
	    mazeFile = new Scanner(new File(fname));
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}

	numRows = mazeFile.nextInt();
	numCols = mazeFile.nextInt();
	// where do I declare numRows/numCols? I want to fill them with ??
	maze = new Square[numRows][numCols];
	for (int row = 0; row < numRows; row++) {
	    for (int col = 0; col < numCols; col++) {
		maze[row][col] = new Square(row, col, mazeFile.nextInt());
		if (maze[row][col].getType() == Square.start) {
		    start = maze[row][col];
		} else if (maze[row][col].getType() == Square.exit) {
		    exit = maze[row][col];
		}
	    }
	}
	return true;

    }

    public ArrayList<Square> getNeighbors(Square sq) {

	//
	ArrayList<Square> neighbors = new ArrayList<Square>();
	int row = sq.getRow();
	int col = sq.getCol();
	if (row > 0) {
	    neighbors.add(maze[row - 1][col]);
	}
	if ((col + 1) < numCols) {
	    neighbors.add(maze[row][col + 1]);
	}
	if ((row + 1) < numRows) {
	    neighbors.add(maze[row + 1][col]);
	}
	if (col > 0) {
	    neighbors.add(maze[row][col - 1]);
	}
	return neighbors;
    }

    public Square getStart() {
	return start;
    }

    public Square getFinish() {
	return exit;
    }

    public void reset() {
	for (int row = 0; row < numRows; row++) {
	    for (int col = 0; col < numCols; col++) {
		maze[row][col].reset();
	    }
	}
    }

    public void printMaze() {
	for (int row = 0; row < numRows; row++) {
	    for (int col = 0; col < numCols; col++) {
		System.out.printf("%d ", maze[row][col].getType());
	    }
	    System.out.println();
	}
	System.out.printf("Start is [%d,%d]\n", start.getRow(), start.getCol());
	System.out.printf("Finish is [%d,%d]\n", exit.getRow(), exit.getCol());
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	for (int row = 0; row < numRows; row++) {
	    for (int col = 0; col < numCols; col++) {
		sb.append(maze[row][col].toString());
	    }
	    sb.append("\n");
	}
	return new String(sb);
    }

}
