import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextGenerator {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int K = Integer.parseInt(args[0]);
	int M = Integer.parseInt(args[1]);
	String fileName = args[2];
	try {
	    FileReader R = new FileReader(fileName);
	    String s = "";
	    for (int i = 0; i < K; i++) {
		int c = R.read();
		s += (char) c;
	    }
	    MarkovModel model = new MarkovModel(K, fileName);
	    System.out.println(model.generateText(M, s));

	} catch (FileNotFoundException e) {
	    System.out.println("Bad file name");
	} catch (IOException e) {
	    System.out.println("IOEException");
	}
    }

}
