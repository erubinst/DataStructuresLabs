
// You need to add distance and predecessor information for the Single Source All Paths algorithm.
// You also need to complete the getPath method.

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Vertex {
    String name;
    List<Edge> adjacentList;
    // add distance and predeesoor variables here

    int distance;
    Vertex predecessor;

    // initialize distance and predecessor here.
    public Vertex(String name) {
	this.name = name;
	adjacentList = new LinkedList<Edge>();
	distance = Graph.Infinity;
	predecessor = null;
    }

    public int distance() {
	return distance;
    }

    public void setDistance(int dist) {
	distance = dist;
    }

    public Vertex predecessor() {
	return predecessor;
    }

    public void setPredecessor(Vertex pred) {
	predecessor = pred;
    }

    public List<Edge> adjacents() {
	return adjacentList;
    }

    public String toString() {
	return name;
    }
    
    public void reset() {
	distance = Graph.Infinity;
	predecessor = null;
    }

    // This is called, after the allPaths algorithm is run, to represent the
    // path from the source to thios vertex.
    // Follow the predecessor nodes back to the source (whose predecessor should
    // be null), each time pushing the vertex
    // onto a stack. Then pop the stack until it is empty, each time adding a
    // String version of the vertex onto a String.
    // When the staclk is empty return the string.
    // If 'A">is the source nod3, "C" is the current node and the path goes
    // through "B" this should return somethign like
    // "A => B => C"

    public String getPath() {
	Stack<Vertex> stack = new Stack<Vertex>();
	Vertex current = this;
	while (current != null) {
	    stack.push(current);
	    current = current.predecessor();
	}
	String path = stack.pop().toString();
	while (!stack.isEmpty()) {
	    path = path + " => " + stack.pop();
	}
	return path;
    }
}
