import java.util.Iterator;

/**
 * The Iterable Interface requires you to implement one method Iterator iterator(). 
 * So, all your Queue and Stack classes must implement this interface.
 */

public interface IterableInterface<E> {
	
	/**
	 * Returns an iterator over elements of type T
	 * 
	 * @returns an iterator
	 */
	public Iterator<E> iterator();
	
}
