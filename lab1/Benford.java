//Esme Rubinstein
//Benford Analysis: Files that had more numbers/data in them tended to follow Benford's Law better
//Files that had data from real life also tended to work better (the file that had the digits of pi
//and the digits of e didn't follow Benford's Law very well, for example.  All of the census ones
//seemed to follow the law pretty well, and they usually were better when they had more digits

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Benford {

    public static final int MAXWIDTH = 50;

    public static void main(String[] args) {
	int[] counters = new int[10];
	int totalDigitWords = 0;
	int maxcount = -1;
	for (int i = 0; i < 10; i++) {
	    counters[i] = 0;
	}
	System.out.println("Welcome to the Benford analysis program");
	for (String filename : args) {
	    Scanner input = null;
	    try {
		input = new Scanner(new File(filename));
	    } catch (FileNotFoundException e) {
		System.out.println("Problem opening file: " + e.getMessage());
		continue;
	    }
	    while (input.hasNext()) {
		String word = input.next();
		char firstChar = word.charAt(0);
		if (Character.isDigit(firstChar)) {
		    int digit = Integer.parseInt(word.substring(0, 1));
		    counters[digit]++;
		    totalDigitWords++;
		}
	    }
	    input.close();
	}
	for (int i = 0; i < 10; i++) {
	    if (counters[i] > maxcount) {
		maxcount = counters[i];
	    }
	}
	System.out.println();
	for (int i = 0; i < 10; i++) {
	    int count = counters[i];
	    float freq = (float) count / totalDigitWords * 100;
	    int numStars = Math.round((float) count / maxcount * MAXWIDTH);
	    System.out.printf("%d %8d %4.1f%% : ", i, count, freq);
	    for (int j = 0; j < numStars; j++) {
		System.out.print("*");
	    }
	    System.out.println();

	}

    }

}
