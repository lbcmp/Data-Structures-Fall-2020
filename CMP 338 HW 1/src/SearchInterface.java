/**
 * This is a generalized search interface. You will write two classes that implement
 * this interface:
 * 
 * LinearSearch
 * BinarySearch
 */

public interface SearchInterface {
	
	/*
	 * This method is used for searching for a target value in an array representing a listOfNumbers.
	 * 
	 * @param listOfNumbers	An array of int values.
	 * @param target An int value representing the target we are searching for.
	 * 
	 * @return If the target value is found, the method will return the index of the target value in the listOfNumbers. Otherwise, the method will return -1.
	 */
	public int search(int[] listOfNumbers, int target);
 
}
