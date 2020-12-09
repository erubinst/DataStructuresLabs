
/**
 * Load a tree from a text file.  Format is line based, with each line
 * consisting of a String for data, followed by two ints indicating if
 * the node has a left child or right child.  (1 is yes, 0 is no).
 * Ordering of nodes is postorder.
 *
 * @author John Donaldson
 * @author Benjamin Kuperman (Spring 2007)
 * @author Alexa Sharp (Fall 2012)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class TreeLoader {

    BinaryTree<String> loadTreeFromFile(String fname) throws IOException {
	Scanner input = null;
	try {
	    input = new Scanner(new File(fname));
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening the file " + e.getMessage());
	}
	Stack<BinaryTree<String>> newStack = new Stack<BinaryTree<String>>();
	while (input.hasNext()) {
	    String data = input.next();
	    String isLeft = input.next();
	    String isRight = input.next();
	    BinaryTree<String> left = null;
	    BinaryTree<String> right = null;

	    if (isRight.equals("1")) {
		right = newStack.pop();
	    } else {
		right = new EmptyTree<String>();
	    }
	    if (isLeft.equals("1")) {
		left = newStack.pop();
	    } else {
		left = new EmptyTree<String>();
	    }
	    newStack.push(new ConsTree<String>(data, left, right));
	}
	if (newStack.empty()) {
	    return new EmptyTree<String>();
	} else {
	    return newStack.pop();
	}
    }

    // So you can test your tree loader
    public static void main(String[] args) throws IOException {
	if (args.length != 1) {
	    System.out.println("Usage:  java TreeLoader filename");
	} else {
	    TreeLoader tl = new TreeLoader();
	    BinaryTree<String> t = tl.loadTreeFromFile(args[0]);
	    System.out.println(t);
	}
    }
}
