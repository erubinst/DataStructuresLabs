import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MarkovModel {
    int K;
    HashMap<String, State> model;

    public MarkovModel(int K, String fileName) {
	this.K = K;
	this.model = new HashMap<String, State>();
	train(fileName);
    }

    public void train(String fileName) {
	try {
	    FileReader R = new FileReader(fileName);
	    String s = "";
	    for (int i = 0; i < K; i++) {
		int c = R.read();
		s += (char) c;
	    }
	    boolean done = false;
	    while (!done) {
		int c = R.read();
		if (c == -1) {
		    done = true;
		} else {
		    State state;
		    if (model.containsKey(s)) {
			state = model.get(s);
		    } else {
			state = new State(s);
			model.put(s, state);
		    }
		    state.add();
		    state.add((char) c);
		    s += (char) c;
		    s = s.substring(1);
		}
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("Bad file name");
	} catch (IOException e) {
	    System.out.println("IOEException");
	}
    }

    public String generateText(int M, String start) {
	String text = "";
	String s = start;
	for (int i = 0; i < M; i++) {
	    State state;
	    if (model.containsKey(s)) {
		state = model.get(s);
	    } else {
		state = model.get(start);
	    }
	    char ch = state.generate();
	    s += (char) ch;
	    s = s.substring(1);
	    text += (char) ch;
	}
	return text;
    }

    public void printModel() {
	System.out.printf("%d distinct states:\n", model.size());
	for (String s : model.keySet())
	    System.out.printf("   %s\n", model.get(s));
    }

}
