import java.util.Iterator;
import java.util.Vector;

/**
 * You will write the ArrayBasedStack.java class which will implement the Stack Interface. 
 * Please note that Stack Interface extends the Iterable Interface.
 */

public class ArrayBasedStack<E> implements StackInterface<E> {

	private final int INITIAL_STACK_SIZE = 10;
	private Object[] arrayStack = new Object[this.INITIAL_STACK_SIZE];
	
	private int size = 0;
	private int top = -1;
	
	
	
	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void push(E e) throws IllegalStateException, NullPointerException {
		if (this.size == this.arrayStack.length) {
			Object[] newArray = new Object[this.arrayStack.length + this.INITIAL_STACK_SIZE];
			for ( int i = 0 ; i < this.arrayStack.length ; i++ ) {
				newArray[i] = arrayStack[i];
			}
			this.arrayStack = newArray;
		}
		this.arrayStack[++this.top] = e;
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		E element = null;
		if (this.isEmpty()) {
			return element;
		} else {
			element = (E) this.arrayStack[this.top];
			return element;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		E element = null;
		if (this.isEmpty()) {
			return element;
		} else {
			element = (E) this.arrayStack[this.top--];
			size--;
			return element;
		}
	}

	@Override
	public void clear() {
		this.size = 0;
		this.top = -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		Vector<E> elements = new Vector<E>(size);
		for (int i = size - 1 ; i >= 0 ; --i) {
			elements.add((E) arrayStack[i]);
		}
		ElementIterator<E> elementIterator = new ElementIterator<E>(elements);
		return elementIterator;
	}

}
