
/**
 * TODO - your comments here
 */

import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> extends AbstractList<T> {

    protected class Node {
	T data;
	Node next;
	Node prev;

	// TODO - your code here
	protected Node() {
	    this.data = null;
	    this.next = null;
	    this.prev = null;
	}
    }

    Node head;
    Node tail;
    int size;
    int modCount;

    public MyLinkedList() {
	Node newHead = new Node();
	Node newTail = new Node();
	newHead.next = newTail;
	newTail.prev = newHead;
	this.head = newHead;
	this.tail = newTail;
	this.size = 0;
	this.modCount = 0;
    }

    private Node getNth(int index) throws IndexOutOfBoundsException {
	Node p;
	if ((index > size) || (index < 0)) {
	    throw new IndexOutOfBoundsException();
	} else if (index > (size) / 2) {
	    p = tail;
	    for (int i = size; i > index; i--) {
		p = p.prev;
	    }
	}

	else {
	    p = head;
	    for (int i = 0; i <= index; i++) {
		p = p.next;
	    }
	}
	return p;
    }

    public boolean add(T data) {
	add(size, data);
	return true;

    }

    private void addNode(Node next, T data) {
	Node p = new Node();
	Node previous = next.prev;
	p.data = data;
	previous.next = p;
	p.prev = previous;
	p.next = next;
	next.prev = p;
	size++;
	modCount++;
    }

    public void add(int index, T data) throws NullPointerException, IndexOutOfBoundsException {
	if (data == null) {
	    throw new NullPointerException();
	} else if ((index > size) || (index < 0)) {
	    throw new IndexOutOfBoundsException();
	} else {
	    Node old = getNth(index);
	    addNode(old, data);
	}

    }

    public T get(int i) throws IndexOutOfBoundsException {
	if ((i >= size) || (i < 0)) {
	    throw new IndexOutOfBoundsException();
	}
	Node p = getNth(i);
	return p.data;
    }

    public T set(int i, T data) throws IndexOutOfBoundsException, NullPointerException {
	if (data == null) {
	    throw new NullPointerException();
	} else if ((i >= size) || (i < 0)) {
	    throw new IndexOutOfBoundsException();
	} else {
	    Node p = getNth(i);
	    T oldData = p.data;
	    p.data = data;
	    modCount++;
	    return oldData;
	}
    }

    private void removeNode(Node n) {
	Node next = n.next;
	Node prev = n.prev;
	next.prev = prev;
	prev.next = next;
	size--;
	modCount++;
    }

    public T remove(int i) throws IndexOutOfBoundsException {
	if ((i >= size) || (i < 0)) {
	    throw new IndexOutOfBoundsException();
	} else {
	    Node removed = getNth(i);
	    removeNode(removed);
	    return removed.data;
	}
    }

    public void clear() {
	head.next = tail;
	tail.prev = head;
	modCount++;
    }

    public boolean isEmpty() {
	if (head.next == tail) {
	    return true;
	} else {
	    return false;
	}
    }

    public int size() {
	return size;
    }

    protected class MyListIterator implements ListIterator<T> {
	int position = 0;
	Node next = head.next;
	Node lastNode = null;
	int itModCount = modCount;

	public boolean hasNext() {
	    return position < size;

	}

	public T next() throws NoSuchElementException {
	    if ((hasNext()) && (modCount == itModCount)) {
		lastNode = next;
		next = lastNode.next;
		position++;
		return lastNode.data;
	    } else {
		throw new NoSuchElementException();
	    }

	}

	public boolean hasPrevious() {
	    return position > 0;
	}

	public T previous() throws NoSuchElementException {
	    if ((hasPrevious()) && (modCount == itModCount)) {
		lastNode = next.prev;
		next = lastNode;
		position--;
		return lastNode.data;
	    } else {
		throw new NoSuchElementException();
	    }
	}

	public int nextIndex() {
	    return position;
	}

	public int previousIndex() {
	    return position - 1;
	}

	public void set(T x) throws IllegalStateException {
	    if ((lastNode == null) || (modCount != itModCount)) {
		throw new IllegalStateException();
	    } else {
		lastNode.data = x;
		modCount++;
		itModCount++;
	    }
	}

	public void remove() throws IllegalStateException {
	    if ((lastNode == null) || (modCount != itModCount)) {
		throw new IllegalStateException();
	    } else {
		Node lastNodeNext = lastNode.next;
		removeNode(lastNode);
		if (next == lastNode) {
		    next = lastNodeNext;
		} else {
		    position--;
		}
		lastNode = null;
		itModCount++;
	    }
	}

	public void add(T x) {
	    addNode(next, x);
	    position++;
	    lastNode = null;
	    itModCount++;
	}

    }

    public ListIterator<T> listIterator() {
	return new MyListIterator();
    }

    public Iterator<T> iterator() {
	return new MyListIterator();
    }

    // TODO - your code here

}