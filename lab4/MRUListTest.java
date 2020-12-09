import java.util.ListIterator;

import org.junit.jupiter.api.Test;

class MRUListTest {

    @Test
    void test() {
	MRUList<String> lst = new MRUList<String>();
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
	lst.contains("1");
	System.out.println("Contains:  " + lst);
    }
}
