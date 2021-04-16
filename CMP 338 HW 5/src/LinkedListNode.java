/**
 * You will write the LinkedListNode class. Please see the Linked List Node Documentation for all the methods you will need. 
 */

public class LinkedListNode<E> {
	
	private E element;
	private LinkedListNode<E> next;
	
	LinkedListNode() {
		this.element = null;
		this.next = null;
	}
	
	LinkedListNode(E element) {
		this.element = element;
		this.next = null;
	}
	
	public E getElement() {
		/**
		 * Getter method to obtain a reference to the Object held by the LinkedListNode.
		 * 
		 * @return The Object held by the Node.
		 */
		
		return element;
	}

	public LinkedListNode<E> getNext() {
		/**
		 * Getter method to obtain a reference to the next LinkedListNode in the Linked List.
		 * 
		 * @return The next LinkedListNode in the Linked List
		 */
		
		return next;
	}

	public void setElement(E element) {
		/**
		 * Setter method to set the reference to the Object held by the LinkedListNode.
		 * 
		 * @param element - The reference to the Object to be held by the LinkedListNode. 
		 */
		
		this.element = element;
	}

	public void setNext(LinkedListNode<E> next) {
		/**
		 * Setter method to set the reference to the next LinkedListNode in the Linked List.
		 * 
		 * @param next - The reference to the next LinkedListNode in the Linked List
		 */
		
		this.next = next;
	}

}
