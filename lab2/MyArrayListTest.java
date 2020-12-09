//Esme Rubinstein
//I affirm that I have adhered to the Honor Code on this assignment
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyArrayListTest {

    @Ignore
    public void testSize() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	ArrayList<Integer> real = new ArrayList<Integer>();
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
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	ArrayList<Integer> real = new ArrayList<Integer>();
	assertEquals("Size after construction", real.size(), test.size());
    }

    @Ignore
    public void testAddIntEFront() {
	Scanner testFile = null;
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
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
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
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
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
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
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	test.add(-1, 5);
    }

    @Ignore(expected = IndexOutOfBoundsException.class)
    public void testForAddRightException() throws Exception {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	test.add(test.size() + 1, 5);
    }

    @Ignore(expected = IndexOutOfBoundsException.class)
    public void testForGetLeftException() throws Exception {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	test.get(-1);
    }

    @Ignore(expected = IndexOutOfBoundsException.class)
    public void testForGetRightException() throws Exception {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	test.get(test.size() + 1);
    }

   
    @Ignore
    public void testAddEfficiency1() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	for (int i = 1; i <= 1000000; i++) {
	    test.add(i);
	    if (i % 10000 == 0) {
		System.out.println(test.get(i-1));
	    }
	}

    }

    @Ignore
    public void testAddEfficiency2() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	for (int i = 1; i <= 1000000; i++) {
	    test.add(0,i);
	    if (i % 10000 == 0) {
		System.out.println(test.get(0));
	    }
	}

    }

    @Ignore
    public void testRemoveEfficiency() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
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

    @Ignore (expected = OutOfMemoryError.class)
    public void testMemory() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	int count = 0;
	while (true) {
	    count++;
	    test.add(count);

	    if (count % 10000 == 0) {
		System.out.println(test.get(count-1));
	    }
	}
    }

}
