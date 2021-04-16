/**
 * @author Sameh A. Fakhouri
 */

public interface DriverInterface {

	/**
	 * 
	 * This enum is used to specify the type of Array. All arrays used in this
	 * assignment will be arrays of Integer:
	 * 
	 * 
	 * Equal - The elements in the array are all equal.
	 * Random - The elements in the array are randomly generated.
	 * Increasing - The elements of the array are arranged in increasing order.
	 * Decreasing - The elements of the array are arranged in decreasing order.
	 * IncreasingAndRandom - The first 90% of the elements are arranged in increasing order and the last 10%
	 * of the elements are randomly generated.
	 *
	 */
	public static enum ArrayType {Equal, Random, Increasing, Decreasing, IncreasingAndRandom};
	
	/**
	 * 
	 * This enum is used to specify the desired sort algorithm:
	 * 
	 * 
	 * MergeSort - Indicates the Merge Sort algorithm.
	 * QuickSort - Indicates the Quick Sort algorithm.
	 * HeapSort - Indicates the Heap Sort algorithm.
	 *
	 */
	public static enum SortType {MergeSort, QuickSort, HeapSort};
	
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
	 * This method will run all the possible sorts a specified number of times. Each time a sort is run,
	 * the method will obtain a new array to sort. The array will be of the specified type and size.
	 * 
	 * @param arrayType This parameter specifies the type of array to create each time the sort is run. 
	 * See the enum {@link ArrayType}.
	 * @param arraySize This parameter specifies the size of array to create each time the sort is run.
	 * @param numberOfTimes This parameter specifies the number of times to run the specified sort.
	 * 
	 * @return The method must return an array of RunTime instances. The array will contain the the following
	 * instances:
	 * 
	 *  
	 *  MergeSort
	 *  QuickSort PivotType.FirstElement
	 *  QuickSort PivotType.RandomElement
	 *  QuickSort PivotType.MidOfFirstMidLastElement
	 *  HeapSort
	 *  
	 */
	public TestTimes[] runSorts(ArrayType arrayType, int arraySize, int numberOfTimes);

}
