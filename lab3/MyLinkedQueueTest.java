//Esme Rubinstein
import org.junit.jupiter.api.Test;

class MyLinkedQueueTest {

    @Test
    void test() {
	MyQueue<String> test = new MyQueue<String>();
	test.enqueue("E");
	test.enqueue("S");
	test.enqueue("M");
	test.enqueue("E");
	test.dequeue();
	System.out.println(test.front());
	System.out.println(test.size());
    }
    
    void test2() {
	MyQueue<String> test = new MyQueue<String>();
	test.enqueue("E");
	test.enqueue("S");
	test.enqueue("M");
	test.enqueue("E");
	test.clear();
	test.isEmpty();
	System.out.println(test.size());
    }

}
