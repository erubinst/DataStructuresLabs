import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Concordance {
    int numLines;
    int numWords;
    TreeMap<String, ArrayList<Integer>> map;
    TreeSet<Character> punctuation;
    static int MAXLISTSIZE = 15;

    public Concordance(String punctuationString, String fname) {
	numLines = 0;
	numWords = 0;
	map = new TreeMap<String, ArrayList<Integer>>();
	punctuation = new TreeSet<Character>();
	for (int i = 0; i < punctuationString.length(); i++) {
	    punctuation.add(punctuationString.charAt(i));
	}
	Build(fname);
	Print();
	Search();
    }

    private String strip(String word) {
	int i = 0;
	int j = word.length() - 1;
	while (i <= j && punctuation.contains(word.charAt(i))) {
	    i++;
	}
	while (j >= i && punctuation.contains(word.charAt(j))) {
	    j--;
	}
	return word.substring(i, j + 1);
    }

    public void Build(String fname) {
	Scanner input = null;
	try {
	    input = new Scanner(new File(fname));
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	while (input.hasNext()) {
	    String line = input.nextLine();
	    Scanner lineInput = new Scanner(line);
	    if (lineInput.hasNext()) {
		numLines++;
		while (lineInput.hasNext()) {
		    String word = lineInput.next();
		    word = strip(word);
		    if (word.length() > 0) {
			numWords++;
			ArrayList<Integer> entry = null;
			if (map.containsKey(word)) {
			    entry = map.get(word);
			} else {
			    entry = new ArrayList<Integer>();
			    map.put(word, entry);
			}
			entry.add(numLines);
		    }
		}
	    }
	}
    }

    public void Print() {
	Set<String> keys = map.keySet();
	ArrayList<String> sortedKeys = new ArrayList<String>();
	sortedKeys.addAll(keys);
	Collections.sort(sortedKeys);
	System.out.println(numLines + " lines, " + numWords + " words, and " + sortedKeys.size() + " unique words.");
	for (String key : sortedKeys) {
	    ArrayList<Integer> entry = map.get(key);
	    if(entry.size()>MAXLISTSIZE) {
		System.out.printf("%-20s%s\n", key, "many entries");
	    }
	    else {
		System.out.printf("%-20s%s\n", key, entry);
	    }
	}
    }
    
    public void Search() {
	String n;
	//should have a loop in which the user is prompted to enter strings; for each string the 
	//program should check if that is one of the keys of the concordance and if so it should
	//print the value associated with this key.
	Scanner wordInput = new Scanner(System.in);
	System.out.println("Enter a word: ");
	n = wordInput.next(); 
	while(!n.equals("quit") ){
	    if(map.containsKey(n)) {
		System.out.println(map.get(n));
	    }
	    else {
		System.out.println("Word is not in concordance.");
	    }
	    Scanner wordInput2 = new Scanner(System.in);
	    n = wordInput2.next();
	}
	System.exit(0);
    } 

    public static void main(String[] args) {
	Concordance C = new Concordance("!\"#$%&\\'()*+,-./:;<=>?@[\\\\]^_`{|}~", args[0]);

    }
}
