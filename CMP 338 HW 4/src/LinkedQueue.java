import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * You will write the LinkedQueue.java class which will implement the Queue Interface. 
 * Please note that Queue Interface extends the Iterable Interface.
 * 
 * Also note that the Linked Queue Class should be a Doubly Linked Queue.
 */

public class LinkedQueue<E> implements QueueInterface<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LinkedQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		/**
		 * This method is called to determine if the queue is empty.
		 * 
		 * @return 	Returns <b>true</b> if the queue is empty, otherwise it returns <b>false</b>. 
		 */
		
		return (size == 0);
	}
	
	public int size() {
		/**
		 * This method is called to obtain the count of elements in the list.
		 * 
		 * @return 	Returns the numbers of elements that are currently in the queue.
		 */
		
		return this.size;
	}

	public void enqueue(E e) throws IllegalStateException, NullPointerException {
		/**
		 * 
		 * Adds the specified element into the stack if it is possible to do so immediately without 
		 * violating capacity restrictions, otherwise, throwing an IllegalStateException 
		 * if no space is currently available or NullPointerException if the specified element is null.
		 * 
		 * @param 	e	The element to add.
		 * 
		 * @throws 	IllegalStateException	If the element cannot be added at this time due to capacity restrictions.
		 * @throws 	NullPointerException	If the specified element being added is null. 
		 * 
		 */
		
		if (e == null) {
			throw new NullPointerException("The passed object to enqueue(E e) is null");
		}
		
		Node<E> node = new Node<E>(e);
		
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		
		++size;
	}
	
	public E peek() {
		/**
		 * 
		 * Retrieves, but does not remove, the head of this queue.
		 * 
		 * @return	The element at the head of the queue or null if the queue is empty.
		 * 
		 */
		
		if (isEmpty()) {
			return null;
		} else {
			return head.getElement();
		}
	}
	
	public E dequeue() {
		/**
		 * 
		 * Retrieves and removes the element at the head of this queue.
		 * 
		 * @return	The element at the head of the queue or null if the queue is empty.
		 * 
		 */
		
		if (isEmpty()) {
			return null;
		} else {
			Node<E> removedItem = head;
			head = head.getNext();
			--size;
			return removedItem.getElement();
		}
	}
	
	public E dequeue(int index) throws NoSuchElementException {
		/**
		 * 
		 * Retrieves and removes the element at the specified index.
		 * 
		 * @param	index	The index of the element to be removed.
		 * 
		 * @return	The element at the specified index.
		 * 
		 * @throws NoSuchElementException	If the specified index is invalid.
		 * 
		 */
		
		if (this.isEmpty()) {
			throw new NoSuchElementException("The queue is empty, no elements are available");
		}
		
		if (index < 0 || index >= size) {
			throw new NoSuchElementException("The passed index is invalid.");
		}
		
		if (index == 0) {
			E removedItem = head.getElement();
			head = head.getNext();
			--size;
			return removedItem;
		} else {
			Node<E> curNode = head;
			for (int i = 0; i < size; ++i) {
				if (i == index - 1) { 
					E removedItem = curNode.getNext().getElement();
					curNode.setNext(curNode.getNext().getNext());
					--size;
					return removedItem;
				}
				curNode = curNode.getNext();
			}
		}
		return null;
	}

	public void removeAll() {
		/**
		 * 
		 * Removes all elements from the queue.
		 * 
		 */
		
		head = null;
		tail = null;
		size = 0;
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
		Node<E> curNode = head;
		for (int i = 0 ; i < size; i++ ) {
			elements.add(curNode.getElement());
			curNode = curNode.getNext();
		}
		
		ElementIterator<E> elementIterator = new ElementIterator<E>(elements);
		return elementIterator;
	}
}
