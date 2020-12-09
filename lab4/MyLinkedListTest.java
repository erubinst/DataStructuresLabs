import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class MyLinkedListTest {

    @Test
    @Ignore
    public void testSize() {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	LinkedList<Integer> real = new LinkedList<Integer>();
	assertEquals("Size after construction", real.size(), test.size());
	test.add(0, 5);
	real.add(0, 5);
	assertEquals("Size after add", real.size(), test.size());
    }

    @Ignore
    public void testIsEmpty() {
	fail("Not yet implemented");
    }

    @Ignore
    public void testClear() {
	fail("Not yet implemented");
    }

    @Ignore
    public void testMyArrayListInt() {
	fail("Not yet implemented");
    }

    @Ignore
    public void testMyArrayList() {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	LinkedList<Integer> real = new LinkedList<Integer>();
	assertEquals("Size after construction", real.size(), test.size());
    }

    @Ignore
    public void testAddIntEFront() {
	Scanner testFile = null;
	MyLinkedList<String> test = new MyLinkedList<String>();
	LinkedList<String> real = new LinkedList<String>();
	try {
	    testFile = new Scanner(new File("test1.txt"));
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	while (testFile.hasNextLine()) {
	    String line = testFile.nextLine();
	    test.add(0, line);
	    real.add(0, line);
	}
	for (int i = 0; i < real.size(); i++) {
	    assertEquals("Size after construction", real.get(i), test.get(i));
	}
	testFile.close();
    }

    @Ignore
    public void testAddE() {
	Scanner testFile = null;
	MyLinkedList<String> test = new MyLinkedList<String>();
	LinkedList<String> real = new LinkedList<String>();
	try {
	    testFile = new Scanner(new File("test1.txt"));
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	while (testFile.hasNextLine()) {
	    String line = testFile.nextLine();
	    test.add(line);
	    real.add(line);
	}
	for (int i = 0; i < real.size(); i++) {
	    assertEquals("Size after construction", real.get(i), test.get(i));
	}
	testFile.close();

    }

    @Ignore
    public void testAddIntEBack() {
	Scanner testFile = null;
	MyLinkedList<String> test = new MyLinkedList<String>();
	LinkedList<String> real = new LinkedList<String>();
	try {
	    testFile = new Scanner(new File("test1.txt"));
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	while (testFile.hasNextLine()) {
	    String line = testFile.nextLine();
	    test.add(test.size() / 2, line);
	    real.add(real.size() / 2, line);
	}
	for (int i = 0; i < real.size(); i++) {
	    assertEquals("Size after construction", real.get(i), test.get(i));
	}
	testFile.close();

    }

    @Ignore
    public void testGetInt() {
	fail("Not yet implemented");
    }

    @Ignore
    public void testSetIntE() {
	fail("Not yet implemented");
    }

    @Ignore
    public void testRemoveInt() {
	fail("Not yet implemented");
    }

    @Ignore(expected = IndexOutOfBoundsException.class)
    public void testForAddLeftException() throws Exception {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	test.add(-1, 5);
    }

    @Ignore(expected = IndexOutOfBoundsException.class)
    public void testForAddRightException() throws Exception {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	test.add(test.size() + 1, 5);
    }

    @Ignore(expected = IndexOutOfBoundsException.class)
    public void testForGetLeftException() throws Exception {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	test.get(-1);
    }

    @Ignore(expected = IndexOutOfBoundsException.class)
    public void testForGetRightException() throws Exception {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	test.get(test.size() + 1);
    }

    @Ignore
    public void testAddEfficiency1() {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	for (int i = 1; i <= 1000000; i++) {
	    test.add(i);
	    if (i % 10000 == 0) {
		System.out.println(test.get(i - 1));
	    }
	}

    }

    @Ignore
    public void testAddEfficiency2() {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	for (int i = 1; i <= 1000000; i++) {
	    test.add(0, i);
	    if (i % 10000 == 0) {
		System.out.println(test.get(0));
	    }
	}

    }

    @Ignore
    public void testRemoveEfficiency() {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	for (int i = 1; i <= 1000000; i++) {
	    test.add(i);

	}

	for (int i = 1000000; i >= 1; i--) {
	    if (i % 10000 == 0) {
		System.out.println(test.get(i - 1));
	    }
	    test.remove(i - 1);

	}

    }

    @Ignore(expected = OutOfMemoryError.class)
    public void testMemory() {
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	int count = 0;
	while (true) {
	    count++;
	    test.add(count);

	    if (count % 10000 == 0) {
		System.out.println(test.get(count - 1));
	    }
	}
    }

    @Test
    void sieve() {
	MyLinkedList<Integer> lst = new MyLinkedList<Integer>();
	for (int i = 11; i <= 20; i++) {
	    lst.add(i);
	}
	double loopTerm = Math.sqrt(lst.size());
	for (int num = 2; num <= loopTerm; num++) {
	    ListIterator<Integer> listIterator = lst.listIterator();
	    while (listIterator.hasNext()) {
		int primeCandidate = listIterator.next();
		if ((primeCandidate == 1) || (primeCandidate != num) && (Math.floorMod(primeCandidate, num) == 0)) {
		    listIterator.remove();
		    System.out.println(lst.size);
		}
	    }
	}
	System.out.println(lst);
    }

    @Test
    void test() {
	MyLinkedList<String> lst = new MyLinkedList<String>();
	lst.add("1");
	lst.add("2");
	lst.add("3");
	System.out.println("Size:");
	System.out.println(lst.size());
	System.out.println("Conventional Loop:");
	for (int i = 0; i < lst.size(); i++) {
	    System.out.println(lst.get(i));
	}
	System.out.println("Iterator Loop:");
	for (String item : lst) {
	    System.out.println(item);
	}
	System.out.println("Explicit Iterator Loop:");
	ListIterator<String> listIterator = lst.listIterator();
	while (listIterator.hasNext()) {
	    System.out.println(listIterator.next());
	}
    }

}
