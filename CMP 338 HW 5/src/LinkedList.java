/**
 * You will create a new LinkedList.java class to implement the modified List Interface. This interface provides the functionality needed 
 * to handle collision chaining.
 */

public class LinkedList<E extends KeyedElementInterface<K>, K> implements ListInterface<E, K> {
	
	private int size = 0;
	private LinkedListNode<E> head = null;
	private LinkedListNode<E> tail = null;

	public int size() {
		/**
		 * This method is called to obtain the count of elements in the list.
		 * 
		 * @return 	Returns the numbers of Elements that are currently in the list.
		 */		
		
		return size;
	}

	public boolean isEmpty() {
		/**
		 * This method is called to determine if the list is empty.
		 * 
		 * @return 	Returns true if the list is empty, otherwise it returns false. 
		 */
		
		return (size == 0);
	}

	public E add(E element) {
		/**
		 * This method is called to add the specified Element to the end of the list. If an
		 * element with the same key already exists in the list, it must be removed
		 * so that you cannot have multiple elements with the same key in the list.
		 * 
		 * @param 	element	A reference to the element to be added to the end of the list.
		 * 					All Elements being added to the list must implement the 
		 * 					KeyedElement interface.
		 * 
		 * @return	If this add displaces a previous element with the same key, the method
		 * 			will return the replaced element, otherwise, the method returns null
		 * 
		 * @see		KeyedElementInterface
		 */
				
		if (element != null) {
			LinkedListNode<E> newNode = new LinkedListNode<E>();
			newNode.setElement(element);
			K newElementKey = element.getKey();
			
			if (size == 0) {
				head = newNode;
				tail = newNode;
				++size;
			} else if (size == 1) {
				E headElement = head.getElement();
				K headKey = headElement.getKey();
				if (headKey.equals(newElementKey)) {
					remove(headKey);
					head = newNode;
					tail = newNode;
					++size;
					return headElement;
				}
				head.setNext(newNode);
				tail = newNode;
				++size;
				
			} else {	
				LinkedListNode<E> curNode = head;
				
				while(curNode != null) {
					E curNodeElement = curNode.getElement();
					K curNodeElementKey = curNodeElement.getKey();
					
					if (curNodeElementKey.equals(newElementKey)) {
						remove(curNodeElementKey);
						tail.setNext(newNode);
						tail = newNode;
						++size;
						return curNodeElement;
					}
					curNode = curNode.getNext();
				}
				
				tail.setNext(newNode);
				tail = newNode;
				++size;
			}
		}
		
		return null;
	}

	public E get(K key) {
		/**
		 * This method is called to retrieve the Element at the specified index.
		 * 
		 * @param 	key		The key of the element being retrieved
		 * 
		 * @return	Returns a reference to the element with the given key, or nullL
		 * 			if an element with the given key is not found.
		 */		
		
		LinkedListNode<E> curNode = head;
		
		while (curNode != null) {
			E curNodeElement = curNode.getElement();
			K curNodeElementKey = curNodeElement.getKey();
			
			if (curNodeElementKey.equals(key)) {
				return curNodeElement;
			}
			
			curNode = curNode.getNext();
		}
		
		return null;
	}

	public E replace(E element) {
		/**
		 * 
		 * This method will use the key of the specified element to find an already existing member of the
		 * LinkedList and will replace the existing element with the specified one.
		 * 
		 * @param element	A reference to the new element that will replace the current element
		 * 					in the list.
		 * 
		 * @return		If the replacement is successful, the method will return a reference to the replaced
		 * 				element. Otherwise, the method will return null, indicating that no replacement took place.
		 */
		
		if (element != null) {
			K replacementElementKey = element.getKey();
			LinkedListNode<E> curNode = head;
			
			while (curNode != null) {
				E curNodeElement = curNode.getElement();
				K curNodeElementKey = curNodeElement.getKey();
				
				if (curNodeElementKey.equals(replacementElementKey)) {
					curNode.setElement(element);
					return curNodeElement;
				}
				
				curNode = curNode.getNext();
			}
		}
		
		return null;
	}

	public E remove(K key) {
		/**
		 * This method is called to remove the Element at the specified key
		 * 
		 * @param 	key		Indicates the key of the element to remove.
		 * 
		 * @return	Returns the element that was successfully removed, 
		 * 			or null if an element with the specified key was not found.
		 */
				
		if (size == 1) {
			//Check head/tail
			E headElement = head.getElement();
			K headKey = headElement.getKey();
			if (headKey.equals(key)) {
				head = null;
				tail = null;
				size = 0;
				return headElement;
			}
		} else if (size > 1) {
			//Check head
			E headElement = head.getElement();
			K headKey = headElement.getKey();
			if (headKey.equals(key)) {
				head = head.getNext();
				--size;
				return headElement;
			}
			
			//Check everything else
			LinkedListNode<E> curNode = head;
			LinkedListNode<E> sucNode = curNode.getNext();
			
			while (sucNode != null) {
				E sucNodeElement = sucNode.getElement();
				K sucNodeKey = sucNodeElement.getKey();
				
				if (sucNodeKey.equals(key)) {
					curNode.setNext(sucNode.getNext());
					--size;
					return sucNodeElement;
				}
				
				curNode = curNode.getNext();
				sucNode = sucNode.getNext();
			}
		}
		
		return null;
	}

	public void removeAll() {
		/**
		 * This method removes all Elements from the list, making the list empty.
		 */
		
		head = null;
		tail = null;
		size = 0;
	}
	
	/*public void print() {
		LinkedListNode<E> curNode = head;
		
		while (curNode != null) {
			System.out.println(curNode.getElement());
			curNode = curNode.getNext();
		}
	}
	
	public static void main(String[] args) {
		Person<Integer> person1 = new Person<Integer>(2349892);
		Person<Integer> person2 = new Person<Integer>(2348239);
		Person<Integer> person3 = new Person<Integer>(2342934);
		Person<Integer> person4 = new Person<Integer>(2348231);
		
		LinkedList<Person<Integer>, Integer> list = new LinkedList<Person<Integer>, Integer>();
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		System.out.println("\nPrinting list:");
		list.print();
		System.out.println("Current size: " + list.size());
		
		System.out.println("Retrieved element: " + list.get(2348239));
		
		System.out.println("-----------------------------------------");
		list.replace(person4);
		System.out.println("Printing new list:");
		list.print();
		System.out.println("New size: " + list.size());
	}*/
}
