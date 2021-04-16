/**
 *
 *  This is the interface for creating a list of elements
 * 
 * @author Sameh Fakhouri
 *
 * @param <E>	This parameter is a generic for the type of elements that will be stored in the list.
 * 				Please note that all elements must implement the KeyedElement interface.
 * 				If the elements, themselves, do not implement the KeyedElement interface,
 * 				a super-class of element must implement the KeyedElement interface.
 * @param <K>	This parameter is a generic for the type of key each element must have. 
 * 				
 */

public interface ListInterface<E extends KeyedElementInterface<K>, K> {
	
	
	/**
	 * This method is called to obtain the count of elements in the list.
	 * 
	 * @return 	Returns the numbers of Elements that are currently in the list.
	 */
	
	public int size();

	
	
	/**
	 * This method is called to determine if the list is empty.
	 * 
	 * @return 	Returns true if the list is empty, otherwise it returns false. 
	 */
	
	public boolean isEmpty();

	
	
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
	public E add(E element);
	
	
	
	/**
	 * This method is called to retrieve the Element at the specified index.
	 * 
	 * @param 	key		The key of the element being retrieved
	 * 
	 * @return	Returns a reference to the element with the given key, or nullL
	 * 			if an element with the given key is not found.
	 */
	public E get(K key);
		
	
	
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
	public E replace(E element);

	
	
	/**
	 * This method is called to remove the Element at the specified index
	 * 
	 * @param 	key		Indicates the key of the element to remove.
	 * 
	 * @return	Returns the element that was successfully removed, 
	 * 			or null if an element with the specified key was not found.
	 */
	public E remove(K key);

	
	
	/**
	 * This method removes all Elements from the list, making the list empty.
	 */
	public void removeAll();
	
}