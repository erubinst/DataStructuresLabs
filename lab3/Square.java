//Esme Rubinstein
public class Square {
    public static final int emptySpace = 0;
    public static final int wall = 1;
    public static final int start = 2;
    public static final int exit = 3;

    private int type;
    private int row;
    private int col;
    private Square mark = null;
    private boolean explored = false;
    private boolean solution = false;

    public int getRow() {
	return row;
    }

    public int getCol() {
	return col;
    }

    public int getType() {
	return type;
    }

    public Square(int row, int col, int type) {
	super();
	this.row = row;
	this.col = col;
	this.type = type;
    }

    public void reset() {
	mark = null;
	explored = false;
	solution = false;
    }

    public boolean getSolution() {
	return solution;
    }

    public void setSolution(boolean val) {
	solution = val;
    }

    public boolean getExplored() {
	return explored;
    }

    public void setExplored(boolean val) {
	explored = val;
    }

    public Square getMark() {
	return mark;
    }

    public void setMark(Square sq) {
	mark = sq;
    }

    public String toString() {
	if (type == wall) {
	    return "#";
	} else if (type == start) {
	    return "S";
	} else if (type == exit) {
	    return "E";
	} else if (solution) {
	    return "x";
	} else if (explored) {
	    return ".";
	} else if (mark != null) {
	    return "o";
	} else {
	    return "_";
	}
    }

}
