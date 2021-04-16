import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * You will write the ArrayBasedQueue.java class which will implement the Queue Interface. 
 * Please note that Queue Interface extends the Iterable Interface.
 */

public class ArrayBasedQueue<E> implements QueueInterface<E> {

	private final int ARRAY_QUEUE_INITIAL_SIZE = 10000;
	@SuppressWarnings("unchecked")
	private E[] arrayQueue = (E[])new Object[ARRAY_QUEUE_INITIAL_SIZE];
	
	private int size = 0;
	
	private int front = -1;
	private int back = -1;
	

	private int incrementIndex(int index) {
		return ((index + 1) % arrayQueue.length);
	}
	
	private int decrementIndex(int index) {
		int result = -1;
		
		if (index == 0) {
			result = this.arrayQueue.length - 1;
		} else {
			result = index - 1;
		}
		
		return result;
	}
 	
	private int findIndex(int index) {
		int result = -1;
		
		if (!this.isEmpty() && (index < this.size)) {
			result = ((this.front) + index) % this.arrayQueue.length;
		}
		
		return result;
	}
	
	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void enqueue(E e) throws IllegalStateException, NullPointerException {
		if (e == null) {
			throw new NullPointerException("The passed object to enqueue(E e) is null");
		}

		if (this.size == this.arrayQueue.length) {
			throw new IllegalStateException("The array is full, cannot add more elements");
		}
		
		if (this.isEmpty()) {
			// the queue is empty, just put the element in the first slot
			this.arrayQueue[0] = e;
			this.front = 0;
			this.back = 0;
		} else {
			// the queue is not empty
			this.back = incrementIndex(this.back);
			this.arrayQueue[back] = e;
		}
		 
		this.size++;
	}

	@Override
	public E peek() {
		if (this.isEmpty()) {
			return null;
		} else {
			return this.arrayQueue[this.front];
		}
	}

	@Override
	public E dequeue() {
		if (this.isEmpty()) {
			return null;
		} else {
			E element = this.arrayQueue[this.front];
			front = this.incrementIndex(this.front);
			this.size--;
			return element;
		}
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The array queue is empty, no elements are available");
		} else {
			int foundIndex = this.findIndex(index);
			if (foundIndex == -1) {
				throw new NoSuchElementException("The array queue only contains " + this.size + " elements, index = " + index + 
						" is not a valid index");
			}
			
			E element = this.arrayQueue[foundIndex];
			
			for ( int i = foundIndex, j = this.incrementIndex(i) ; i != this.back ; i = this.incrementIndex(i), j = this.incrementIndex(j)) {
				this.arrayQueue[i] = this.arrayQueue[j];
			}
			
			this.back = this.decrementIndex(this.back);
			this.size--;
			
			return element;
		}
	}

	@Override
	public void removeAll() {
		this.size = 0;
		this.front = -1;
		this.back = -1;
	}

	@Override
	public Iterator<E> iterator() {
		/**
		 * Returns an iterator over elements of type E
		 * 
		 * @returns an iterator
		 */
		
		/** The iterator that you build will actually be an ElementIterator. */
		
		Vector<E> elements = new Vector<E>(size);
		for (int i = 0 ; i < size; ++i ) {
			elements.add(arrayQueue[i]);
		}
		
		ElementIterator<E> elementIterator = new ElementIterator<E>(elements);
		return elementIterator;
	}
}
