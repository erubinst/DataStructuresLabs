//Esme Rubinstein
import org.junit.jupiter.api.Test;

class MyStackTest {

    @Test
    void test() {
	MyStack<String> test = new MyStack<String>();
	test.push("e");
	test.push("s");
	test.push("m");
	test.push("e");
	System.out.println(test.pop());
	System.out.println(test.pop());
	System.out.println(test.pop());
	System.out.println(test.pop());
	System.out.println(test.size());
	
    }
    
    void test2() {
	MyStack<String> test = new MyStack<String>();
	test.push("e");
	test.push("s");
	test.push("m");
	test.push("e");
	test.clear();
	System.out.println(test.size);
	
    }

}
