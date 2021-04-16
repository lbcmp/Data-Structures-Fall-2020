/**
 * 
 * @author Sameh A. Fakhouri
 *
 */

public interface DriverInterface {

	/**
	 * This enum is used to specify the type of Array. All arrays used in this assignment will be arrays of Integer:
	 * 
	 * Equal - The elements in the array are all equal.
	 * Random - The elements in the array are randomly generated.
	 * Increasing - The elements of the array are arranged in increasing order.
	 * Decreasing - The elements of the array are arranged in decreasing order.
	 * IncreasingAndRandom - The first 90% of the elements are arranged in increasing order and the last 10%
	 * of the elements are randomly generated.
	 * 
	 *
	 */
	public static enum ArrayType {Equal, Random, Increasing, Decreasing, IncreasingAndRandom};
	
	/**
	 * This enum is used to specify the desired sort algorithm:
	 * 
	 * 
	 * BubbleSort - Indicates the Bubble Sort algorithm.
	 * SelectionSort - Indicates the Selection Sort algorithm.
	 * InsertionSort - Indicates the Insertion Sort algorithm.
	 * 
	 *
	 */
	public static enum SortType {BubbleSort, SelectionSort, InsertionSort};
	
	/**
	 * 
	 * This method is used to create a new array of Integer objects of the type and size
	 * specified.
	 * 
	 * @param arrayType	This parameter specifies the type of array to create. See the enum {@link ArrayType}.
	 * 
	 * @param arraySize This parameter specifies the size of array to create.
	 * 
	 * @return	The method will return the array of Integer objects that was created.
	 * 
	 */
	public Integer[] createArray(ArrayType arrayType, int arraySize);
	
	/**
	 * 
	 * This method will run the specified sort type a specified number of times. Each time the sort run
	 * the method will obtain a new array to sort. The array will be of the specified type and size.
	 * 
	 * @param sortType This parameter specifies the sort algorithm that will be used. See {@link SortType}.
	 * 
	 * @param arrayType This parameter specifies the type of array to create each time the sort is run. 
	 * See the enum {@link ArrayType}.
	 * 
	 * @param arraySize This parameter specifies the size of array to create each time the sort is run.
	 * 
	 * @param numberOfTimes This parameter specifies the number of times to run the specified sort.
	 * 
	 * @return The method must return the TestTimes class that was used to save the measured run times for the 
	 * sort performed.
	 * 
	 */
	public TestTimes runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes);

}
