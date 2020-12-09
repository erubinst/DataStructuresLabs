import java.util.ListIterator;

/**
 * TODO - your description here
 *
 * @author TODO Esme Rubinstein
 */

public class MRUList<T> extends MyLinkedList<T> {

    public boolean contains(Object o) {
	ListIterator<T> listIterator = listIterator();
	while (listIterator.hasNext()) {
	    T item = listIterator.next();
	    if (o.equals(item)) {
		if (listIterator.nextIndex() - 1 == 0) {
		    return true;
		} else {
		    listIterator.remove();
		    add(item);
		    return true;
		}
	    }
	}
	return false;
    }

    public boolean add(T x) {
	super.add(0, x);
	return true;
    }

    public void add(int index, T x) {
	add(x);
    }

}
