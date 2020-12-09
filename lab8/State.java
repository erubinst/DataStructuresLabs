import java.util.Random;
import java.util.TreeMap;

public class State {
    String str;
    int count;
    TreeMap<Character, Integer> suffixes;
    Random rand;

    public State(String str) {
	this.str = str;
	this.count = 0;
	this.suffixes = new TreeMap<Character, Integer>();
	this.rand = new Random();
    }

    public void add() {
	count++;
    }

    public void add(char c) {
	if (suffixes.containsKey(c)) {
	    suffixes.put(c, suffixes.get(c) + 1);
	} else {
	    suffixes.put(c, 1);
	}
    }

    public char generate() {
	int r = rand.nextInt(count);
	char ch = 0;
	for (Character c : suffixes.keySet()) {
	    r -= suffixes.get(c);
	    if (r < 0) {
		ch = c;
		break;
	    }
	}
	return ch;
    }

    public String toString() {
	String s = String.format("%d %s:", count, str);
	for (Character ch : suffixes.keySet())
	    s += String.format(" (%c %d) ", ch, suffixes.get(ch));
	return s;
    }

}
