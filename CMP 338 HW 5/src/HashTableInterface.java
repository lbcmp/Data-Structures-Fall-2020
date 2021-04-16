/**
 * 
 * This is the interface for creating a hash table.
 * 
 * @author Sameh Fakhouri
 *
 * @param <E>	This parameter is a generic for the type of elements that will be stored in the hash table.
 * 				Please note that all elements must implement the KeyedElement interface.
 * 				If the elements, themselves, do not implement the KeyedElement interface,
 * 				a super-class of element must implement the KeyedElement interface.
 * @param <K>	This parameter is a generic for the type of key each element must have. 
 * 				
 */
public interface HashTableInterface<E extends KeyedElementInterface<K>, K> extends Iterable<E> {

	/**
	 * 
	 * This method will return the size of the hash table. The size of the hash table
	 * is the number of elements that have been added to the hash table.
	 * 
	 * @return	The size of the hash table.
	 */
	public int size();
	
	/**
	 * 
	 * This method is used to determine if the hash table is empty.
	 * 
	 * @return	Return true if the hash table is empty, false otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * This method adds the specified element to the hash table. If another
	 * element with the same key exists in the hash table, that element
	 * will be removed before the new element is inserted. 
	 * 
	 * @param element	The element to be inserted into the hash table
	 * 
	 * @return	If this insertion replaced an existing element, this method will
	 * 			return the replaced element. Otherwise, the method will return null. 
	 */
	public E insert(E element);
	
	/**
	 * 
	 * This method is used to retrieve an element with the specified key from the
	 * hash table.
	 * 
	 * @param key	The key of the element being searched for in the hash table
	 * 
	 * @return	This method will return the element found in the hash table. If the element
	 * 			is not found, this method will return null.
	 */
	public E get(K key);
	
	/**
	 * 
	 * This method will remove the element with the specified key from the hash table. 
	 * 
	 * @param key	The key of the element to be removed from the hash table.
	 * 
	 * @return	This method will return the element that is being removed from the hash table.
	 * 			If the element is not found for removal, this method will return null.
	 */
	public E remove(K key);

	/**
	 * 
	 * This method will remove all elements from the hash table, leaving an empty hash table.
	 * 
	 */
	public void removeAll();

	/**
	 * 
	 * This method will look at all the buckets in the HashTable and return the size
	 * of the largest bucket.
	 * 
	 * @return	The size of the largest bucket in the HashTable.
	 */
	public int getSizeOfLargestBucket();

	/**
	 * 
	 * This method will look at all the buckets in the HashTable and return the average
	 * size of all the buckets.
	 * 
	 * @return	The average size of the buckets in the HashTable.
	 */
	public double getAverageBucketSize();
	
	
	/**
	 * 
	 * This method will be used for testing purposes.
	 * The method will return a reference to the buckets array.
	 * 
	 * @return	A reference to the buckets array.
	 */
	public LinkedList<E, K>[] getBuckets();
}