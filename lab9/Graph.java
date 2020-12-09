import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    public static int Infinity = Integer.MAX_VALUE;

    private HashMap<String, Vertex> vertexMap;
    private LinkedList<Vertex> actors;
    private LinkedList<Vertex> movies;

    public Graph() {
	vertexMap = new HashMap<String, Vertex>();
	movies = new LinkedList<Vertex>();
	actors = new LinkedList<Vertex>();
    }

    public Vertex getVertex(String name) {
	Vertex v = vertexMap.get(name);
	if (v == null) {
	    v = new Vertex(name);
	    vertexMap.put(name, v);
	}
	return v;
    }

    HashMap<String, Vertex> vertexMap() {
	return vertexMap;
    }

    public int vertexCount() {
	return vertexMap.size();
    }

    public void addEdge(String source, String dest) {
	Vertex v = getVertex(source);
	Vertex w = getVertex(dest);
	List<Edge> L = v.adjacents();
	L.add(new Edge(w));
    }

    public void printAvailableActors() {
	for (Vertex e : actors)
	    System.out.printf("%d: %s\n", e.distance() / 2, e);
    }

    public void printAvailableMovies() {
	for (Vertex e : movies)
	    System.out.printf("%s\n", e);
    }

    // EVERYTHING ABOVE THIS LINE IS ALREADY IMPLEMENTED.

    // This reads the named file one line at a time and builds the graph.
    // The file is formatted in the form
    // source|destination
    public void loadFile(String fName) {
	Scanner scan;
	try {
	    if (fName.substring(0, 4).equals("http")) {
		scan = new Scanner(new URL(fName).openStream());
	    } else {
		scan = new Scanner(new File(fName));
	    }
	    scan.useDelimiter("(\\||\r\n|\r|\n)");
	    while (scan.hasNext()) {
		String actor = scan.next();
		String movie = scan.next();
		addEdge(actor, movie);
		addEdge(movie, actor);
	    }
	} catch (FileNotFoundException e) {
	    System.out.printf("File '%s' not found\n", fName);
	} catch (IOException e) {
	}

    }

    public void reset() {
	for (Vertex actor : actors) {
	    actor.reset();
	}
	for (Vertex movie : movies) {
	    movie.reset();
	}
	actors.clear();
	movies.clear();
    }

    // This implements the All Paths Single Source algorithm. As it works if it
    // finds that a node has a less-than-infinite distance from the source node
    // it
    // should add the node toeither the abailable movie list or the avaialble
    // actors
    // list.
    // Note that a node of the graph reporesents an actor if its distance is
    // even,
    // and it represents a movie if its distance is odd.
    public void findAllPaths(String s) {
	reset();
	Queue<Vertex> q = new LinkedList<Vertex>();
	Vertex source = getVertex(s);
	source.setDistance(0);
	q.add(source);
	while (!q.isEmpty()) {
	    Vertex current = q.remove();
	    int newDist = current.distance() + 1;
	    for (Edge edge : current.adjacents()) {
		Vertex destination = edge.destination();
		if (destination.distance() == Infinity) {
		    destination.setDistance(newDist);
		    destination.setPredecessor(current);
		    if(destination.distance()%2==0) {
			actors.add(destination);
		    }
		    else {
			movies.add(destination);
		    }
		    q.add(destination);
		}
	    }
	}
    }

}
