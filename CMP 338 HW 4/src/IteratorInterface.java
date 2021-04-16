/**
 * The Iterable Interface requires you to iimplement one method Iterator iterator(). 
 * So, all your Queue and Stack classes must implement this interface.
 */

public interface IteratorInterface<E> {
	
	/**
	 * Returns true if the iteration has more elements. 
	 * (In other words, returns true if next() would return an element rather than throwing an exception.)
	 * 
	 * @return true if the iteration has more elements
	 */
	public boolean hasNext();
	
	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return the next element in the iteration
	 * 
	 * @throws NoSuchElementException - if the iteration has no more elements
	 */
	public E next();
}
