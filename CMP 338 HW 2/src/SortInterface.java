/**
 * 
 * This interface will be used by various classes to sort an array Integer objects.
 * You will write three classes that implement this interface:
 * 
 * BubbleSort
 * InsertionSort
 * SelectionSort
 * 
 * @author Sameh A. Fakhouri
 *
 */

public interface SortInterface {

	/**
	 * 
	 * This method is called to sort the given array of Integer objects. At the
	 * completion of this method, the array will be sorted.
	 * 
	 * @param arrayToSort This is the array that contains all the Integer objects
	 * that need to be sorted.
	 */
	public void sort(Integer[] arrayToSort);
	
}

