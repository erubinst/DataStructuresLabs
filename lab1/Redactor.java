//Esme Rubinstein
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Redactor {

    public static void main(String[] args) {
	if (args.length == 2) {
	    Scanner input = null;
	    Scanner input2 = null;
	    Scanner input3 = null;
	    Scanner input4 = null;
	    boolean found = false;
	    String word;
	    int wordCount = 0;
	    String[] wordlist;
	    try {
		input = new Scanner(new File(args[0])); // you'll probably want args[0]

	    } catch (FileNotFoundException e) {
		System.out.println("Problem opening file: " + e.getMessage());
		System.exit(1);
	    }
	    while (input.hasNext()) {
		input.next();
		wordCount++;
	    }
	    wordlist = new String[wordCount];
	    try {
		input2 = new Scanner(new File(args[0]));

	    } catch (FileNotFoundException e) {
		System.out.println("Problem opening file: " + e.getMessage());
		System.exit(1);

	    }
	    wordCount = 0;
	    while (input2.hasNext()) {
		wordlist[wordCount++] = input2.next();
	    }

	    try {
		input3 = new Scanner(new File(args[1]));

	    } catch (FileNotFoundException e) {
		System.out.println("Problem opening file: " + e.getMessage());
		System.exit(1);
	    }
	    while (input3.hasNextLine()) {
		String line = input3.nextLine();
		input4 = new Scanner(line);
		while (input4.hasNext()) {
		    word = input4.next();
		    found = false;
		    for (String w : wordlist) {
			if (word.equals(w)) {
			    found = true;
			    break;

			}
		    }
		    if (found == true) {
			System.out.print("XXXXXX");
		    } else {
			System.out.print(word);
		    }
		    System.out.print(" ");
		}
		System.out.println();
	    }

	}
	// TODO Auto-generated method stub

    }

}
