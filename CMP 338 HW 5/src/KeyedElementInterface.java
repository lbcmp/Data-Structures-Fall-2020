/**
 * 
 * This is the interface that all elements to be inserted into a hash table or
 * a list must implement.
 * 
 * @author Sameh Fakhouri
 *
 * @param <K>	This parameter is a generic for the type of key each element must have.
 */
public interface KeyedElementInterface<K> {

	/**
	 * 
	 * This method returns the key to be used by elements that will be used by 
	 * classes implementing the ListInterface and the HashTableInterface.
	 * 
	 * @return	This method returns the key of the enclosing object.
	 */
	public K getKey();

}
