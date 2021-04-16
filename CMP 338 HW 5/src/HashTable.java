import java.util.Iterator;
import java.util.Vector;

/**
 * You will create the HashTable.java class to implement the HashTable Interface.
 * 
 * Your HashTable class must have the following definitions:
 * 
 * public static final int NUMBER_OF_BUCKETS = 1_069;
 * You may choose a different constant, but make sure that it is a prime number greater that 1,000.
 * 
 * private LinkedList<E, K>[] buckets;
 * See the Hints section below on how to initialize this instance variable.
 * 
 * private int size = 0;
 * An int corresponding to the number of elements in the HashTable, initially set to 0.
 * 
 * 
 * 
 * In addition, Your HashTable class must have the following constructor:
 * 
 * public HashTable(LinkedList<Person<Integer>, Integer>[] buckets) throws InstantiationException
 * The constructor will have to verify that the array being passed into the constructor is of the correct size by making sure it has
 * NUMBER_OF_BUCKETS. If not, your constructor must throw an InstantiationException. If the size is correct, your constructor will do:
 * 
 * this.buckets = buckets.clone();
 */

public class HashTable<E extends KeyedElementInterface<K>, K> implements HashTableInterface<E, K> {

	public static final int NUMBER_OF_BUCKETS = 1069;
	private LinkedList<E, K>[] buckets;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public HashTable(LinkedList<Person<Integer>, Integer>[] buckets) throws InstantiationException {
		if (buckets.length != NUMBER_OF_BUCKETS) {
			throw new InstantiationException("The passed array is not of the correct size");
		}
		
		this.buckets = (LinkedList<E, K>[]) buckets.clone();
	}

	public int size() {
		/**
		 * 
		 * This method will return the size of the hash table. The size of the hash table
		 * is the number of elements that have been added to the hash table.
		 * 
		 * @return	The size of the hash table.
		 */
		
		return size;
	}
	
	public boolean isEmpty() {
		/**
		 * 
		 * This method is used to determine if the hash table is empty.
		 * 
		 * @return	Return true if the hash table is empty, false otherwise.
		 */
		
		return (size == 0);
	}
	
	public E insert(E element) {
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
		
		if (element != null) {
			K key = element.getKey();
			int bucketNumber = key.hashCode() % NUMBER_OF_BUCKETS;
			
			E removedElement = buckets[bucketNumber].add(element);
			++size;
			
			return removedElement;
		}
		
		return null;
	}
	
	public E get(K key) {
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
		
		for (int i = 0; i < NUMBER_OF_BUCKETS; ++i) {
			E retrievedElement = buckets[i].get(key);
			
			if (retrievedElement != null) {
				return retrievedElement;
			}
		}
		
		return null;
	}
	
	public E remove(K key) {
		/**
		 * 
		 * This method will remove the element with the specified key from the hash table. 
		 * 
		 * @param key	The key of the element to be removed from the hash table.
		 * 
		 * @return	This method will return the element that is being removed from the hash table.
		 * 			If the element is not found for removal, this method will return null.
		 */
		
		for (int i = 0; i < NUMBER_OF_BUCKETS; ++i) {
			E removedElement = buckets[i].remove(key);
			
			if (removedElement != null) {
				--size;
				return removedElement;
			}
		}
		
		return null;
	}

	public void removeAll() {
		/**
		 * 
		 * This method will remove all elements from the hash table, leaving an empty hash table.
		 * 
		 */
				
		for (int i = 0; i < NUMBER_OF_BUCKETS; ++i) {
			buckets[i].removeAll();
		}
		
		size = 0;
	}

	public int getSizeOfLargestBucket() {
		/**
		 * 
		 * This method will look at all the buckets in the HashTable and return the size
		 * of the largest bucket.
		 * 
		 * @return	The size of the largest bucket in the HashTable.
		 */
		
		int maxSize = -1;
		
		for (int i = 0; i < NUMBER_OF_BUCKETS; ++i) {
			if (buckets[i].size() > maxSize) {
				maxSize = buckets[i].size();
			}
		}
		
		return maxSize;
	}

	public double getAverageBucketSize() {
		/**
		 * 
		 * This method will look at all the buckets in the HashTable and return the average
		 * size of all the buckets.
		 * 
		 * @return	The average size of the buckets in the HashTable.
		 */
		
		double sum = 0;
		
		for (int i = 0; i < NUMBER_OF_BUCKETS; ++i) {
			sum += buckets[i].size();
		}
		
		return (double) sum / NUMBER_OF_BUCKETS;
	}
	
	public LinkedList<E, K>[] getBuckets() {
		/**
		 * 
		 * This method will be used for testing purposes.
		 * The method will return a reference to the buckets array.
		 * 
		 * @return	A reference to the buckets array.
		 */
		
		return buckets;
	}

	@SuppressWarnings("unchecked")
	public Iterator<E> iterator() {
		Vector<LinkedList<E, K>> elements = new Vector<LinkedList<E, K>>(size);
		for (int i = 0 ; i < size; ++i ) {
			elements.add(buckets[i]);
		}
				
		return (Iterator<E>) elements;
	}
}
