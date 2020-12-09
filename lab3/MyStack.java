import java.util.ArrayList;
import java.util.NoSuchElementException;

//Esme Rubinstein
public class MyStack<T> implements StackADT<T> {

    ArrayList<T> stack = new ArrayList<T>();
    int size = 0;

    @Override
    public void push(T item) {
	stack.add(item);
	size++;
    }

    @Override
    public T pop() throws NoSuchElementException {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	} else {
	    size--;
	    T removed = stack.get(size);
	    stack.remove(size);
	    return removed;
	}
    }

    @Override
    public T top() throws NoSuchElementException {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	} else {
	    return stack.get(size-1);
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
	for(int i = 0; i <=size; i++) {
	    stack.remove(i);
	}
	size = 0;

    }

}
