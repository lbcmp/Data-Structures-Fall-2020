import java.util.Iterator;
import java.util.Vector;

/**
 * You will write the LinkedStack.java class which will implement the Stack Interface. 
 * Please note that Stack Interface extends the Iterable Interface.
 * 
 * Also note that the Linked Stack Class should be a Doubly Linked Stack.
 */

public class LinkedStack<E> implements StackInterface<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LinkedStack() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		/**
		 * This method is called to determine if the stack is empty.
		 * 
		 * @return 	Returns <b>true</b> if the stack is empty, otherwise it returns <b>false</b>. 
		 */
		
		return (size == 0);
	}
	
	public int size() {
		/**
		 * This method is called to obtain the count of elements in the stack.
		 * 
		 * @return 	Returns the numbers of elements that are currently in the stack.
		 */
		
		return size;
	}

	public void push(E e) throws IllegalStateException, NullPointerException {
		/**
		 * 
		 * Pushed the specified element into this queue if it is possible to do so immediately without 
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
			throw new NullPointerException("The passed object to push(E e) is null");
		}
		
		Node<E> node = new Node<E>(e);
		
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			node.setNext(head);
			head = node;
		}
		
		++size;		
	}
	
	public E peek() {
		/**
		 * 
		 * Retrieves, but does not remove, the top of the stack.
		 * 
		 * @return	The element at the top of the stack or null if the stack is empty.
		 * 
		 */
		
		return head.getElement();
	}
	
	public E pop() {
		/**
		 * 
		 * Retrieves and removes the element at the top of the stack.
		 * 
		 * @return	The element at the top of the stack or null if the queue is empty.
		 * 
		 */
		
		if (isEmpty()) {
			return null;
		} else {
			Node<E> poppedItem = head;
			head = head.getNext();
			--size;
			return poppedItem.getElement();
		}
	}

	public void clear() {
		/**
		 * 
		 * Removes all elements from the stack.
		 * 
		 */
		
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		Vector<E> elements = new Vector<E>(size);
		Node<E> curNode = head;
		for (int i = size - 1; i >= 0; --i) {
			elements.add(curNode.getElement());
			curNode = curNode.getNext();
		}
		
		ElementIterator<E> elementIterator = new ElementIterator<E>(elements);
		return elementIterator;
	}
}
