//Esme Rubinstein
//I affirm that I have adhered to the Honor Code on this assignment.
import java.util.AbstractList;

public class MyArrayList<E> extends AbstractList<E> {
    private int size;
    private E[] data;

    public MyArrayList(int startSize) {
	// if abstractList had own constructor, super would call these
	super();
	int realSize = 2;
	while (realSize < startSize) {
	    realSize = realSize * 2;
	}
	this.size = 0;
	this.data = (E[]) new Object[realSize];
    }

    public MyArrayList() {
	this(2);
    }

    private void resize() {
	E[] biggerArray = (E[]) new Object[data.length * 2];
	for (int i = 0; i < data.length; i++) {
	    biggerArray[i] = data[i];
	}
	data = biggerArray;
    }

    // size is num of elements, data.length is num of spaces
    public int size() {
	return size;

    }

    public void add(int index, E element) {
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException(
		    "Index Out of Bounds! You tried to get " + index + " but the size is " + size);
	}
	size++;
	if (size > data.length) {
	    resize();
	}
	// loop from the end back
	for (int i = size - 2; i >= index; i--) {
	    data[i + 1] = data[i];
	}
	data[index] = element;
    }

    public boolean add(E element) {
	try {
	    add(size, element);
	    return true;
	} catch (IndexOutOfBoundsException e) {
	    System.out.println(e.getMessage());
	    return false;
	}

    }

    public E get(int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException(
		    "Index Out of Bounds! You tried to get " + index + " but the size is " + size);
	}
	return data[index];
    }

    public E set(int index, E element) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException(
		    "Index Out of Bounds! You tried to get " + index + " but the size is " + size);
	}
	E oldElement = data[index];
	data[index] = element;
	return oldElement;

    }

    public boolean isEmpty() {
	if (size == 0) {
	    return true;
	} else {
	    return false;
	}
    }

    public void clear() {
	for (int i = 0; i < size; i++) {
	    data[i] = null;
	    size = 0;
	}
    }

    public E remove(int index) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException(
		    "Index Out of Bounds! You tried to get " + index + " but the size is " + size);
	}
	E removedElement = data[index];
	for(int i = index+1;i<size;i++) {
	    data[i-1] = data[i];
	}
	data[size-1] = null;
	size--;
	return removedElement;
    }

}
