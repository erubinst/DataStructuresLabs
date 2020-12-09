//Esme Rubinstein
//

import java.util.NoSuchElementException;

class Node<T> {
    Node<T> prev = null;
    Node<T> next = null;
    T dataSlot = null;

    void reset() {
	prev = null;
	next = null;
    }
}

public class MyQueue<T> implements QueueADT<T> {
    Node<T> header = new Node<T>();
    int size = 0;

    public MyQueue() {
	this.header.prev = this.header;
	this.header.next = this.header;
    }

    @Override
    public void enqueue(T item) {
	//
	Node<T> node = new Node<T>();
	node.dataSlot = item;
	node.next = header;
	node.prev = header.prev;
	header.prev.next = node;
	header.prev = node;
	size++;
    }

    @Override
    public T dequeue() throws NoSuchElementException {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	} else {
	    Node<T> removed = header.next;
	    header.next = removed.next;
	    removed.next.prev = header;
	    removed.reset();
	    size--;
	    return removed.dataSlot;
	}
    }

    @Override
    public T front() throws NoSuchElementException {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	} else {
	    return header.next.dataSlot;
	}
    }

    @Override
    public int size() {
	return size;
    }

    @Override
    public boolean isEmpty() {
	if (size == 0) {
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public void clear() {
	Node<T> node = header.next;
	while (node != header) {
	    Node<T> next = node.next;
	    node.reset();
	    node = next;
	}
	header.next = header;
	header.prev = header;
	size = 0;
    }

}
