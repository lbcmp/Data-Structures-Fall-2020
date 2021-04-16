import java.util.Arrays;

public class Driver /*implements DriverInterface*/ {
	
	//You will write the Driver.java class which will implement the Driver Interface . The interface may be downloaded from DriverInterface.java
	
	public static enum ArrayType {Equal, Random, Increasing, Decreasing, IncreasingAndRandom};
		/*
		 * This enum is used to specify the type of Array. All arrays used in this assignment will be arrays of Integer:
		 * 
		 * Equal - The elements in the array are all equal.
		 * Random - The elements in the array are randomly generated.
		 * Increasing - The elements of the array are arranged in increasing order.
		 * Decreasing - The elements of the array are arranged in decreasing order.
		 * IncreasingAndRandom - The first 90% of the elements are arranged in increasing order and the last 10%
		 * of the elements are randomly generated.
		 */
	
	public static enum SortType {BubbleSort, SelectionSort, InsertionSort};
		/*
		 * This enum is used to specify the desired sort algorithm:
		 * 
		 * BubbleSort - Indicates the Bubble Sort algorithm.
		 * SelectionSort - Indicates the Selection Sort algorithm.
		 * InsertionSort - Indicates the Insertion Sort algorithm.
		 */
	
	public Integer[] createArray(ArrayType arrayType, int arraySize) {
		/*
		 * This method is used to create a new array of Integer objects of the type and size specified.
		 * 
		 * @param arrayType	This parameter specifies the type of array to create. See the enum {@link ArrayType}.
		 * @param arraySize This parameter specifies the size of array to create.
		 * 
		 * @return	The method will return the array of Integer objects that was created.
		 * 
		 */
		
		Integer[] array = new Integer[arraySize];
		
		switch (arrayType) {
		case Equal:
			Arrays.fill(array, 25);
			break;
		case Random:
			for (int i = 0; i < arraySize; ++i) {
				array[i] = (int)(Math.random() * 2147483647);
			}
			break;
		case Increasing:
			for (int i = 0; i < arraySize; ++i) {
				array[i] = i;
			}
			break;
		case Decreasing:
			int index = 0;
			for (int i = array.length - 1; i >= 0; --i) {
				array[index] = i;
				++index;
			}
			break;
		case IncreasingAndRandom:
			for (int i = 0; i < arraySize; ++i) {
				array[i] = (int)(Math.random() * 2147483647);
			}
			Arrays.sort(array);
			break;
		}
		
		return array;
	}
	
	public TestTimes runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {
		/*
		 * This method will run the specified sort type a specified number of times. Each time the sort run the method will obtain a new array to sort. 
		 * The array will be of the specified type and size.
		 * 
		 * @param sortType This parameter specifies the sort algorithm that will be used. See {@link SortType}.
		 * @param arrayType This parameter specifies the type of array to create each time the sort is run. See the enum {@link ArrayType}.
		 * @param arraySize This parameter specifies the size of array to create each time the sort is run.
		 * @param numberOfTimes This parameter specifies the number of times to run the specified sort.
		 * 
		 * @return The method must return the TestTimes class that was used to save the measured run times for the sort performed.
		 * 
		 */
		
		Integer[] arrayToSort = createArray(arrayType, arraySize);
		
		TestTimes testTimeTracker = new TestTimes();
		long startTime;
		long endTime;
		long testTime;
        
		while (numberOfTimes > 0)  {
			startTime = System.nanoTime();
			
			switch(sortType) {
			case BubbleSort:
				BubbleSort bubbleSortObject = new BubbleSort();
				bubbleSortObject.sort(arrayToSort);
				break;
			case SelectionSort:
				SelectionSort selectionSortObject = new SelectionSort();
				selectionSortObject.sort(arrayToSort);
				break;
			case InsertionSort:
				InsertionSort insertionSortObject = new InsertionSort();
				insertionSortObject.sort(arrayToSort);
				break;
			}
			
			endTime = System.nanoTime(); 
	        testTime = endTime - startTime;
			testTimeTracker.addTestTime(testTime);
			
			--numberOfTimes;
		}
		
		return testTimeTracker;
	}
	
	public static void print(SortType sortType, ArrayType arrayType, int arraySize, TestTimes testTimeTracker) {
		long[] testTimes = testTimeTracker.getTestTimes();
		
		System.out.println(sortType.toString() + " " + arrayType.toString() + " " + arraySize);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < testTimes.length; ++i) {
			System.out.print(testTimes[i] + " ");
		}
		System.out.println("--- " + testTimeTracker.getAverageTestTime() + "\n");
	}
	
	public static void main(String[] args) {
		/*
		 * Please note that, in addition to implementing the DriverInterface, you are also required to write your own
		 * public static main(String[] args) method in Driver.java. Your main() method will have to call the runSort() method to sort each of the 
		 * following array types ten times for each sort algorithm:
		 * 
		 * 1,000 equal Integers.
		 * 1,000 random Integers.
		 * 1,000 increasing Integers.
		 * 1,000 decreasing Integers.
		 * 1,000 increasing and random Integers.
		 * 10,000 equal Integers.
		 * 10,000 random Integers.
		 * 10,000 increasing Integers.
		 * 10,000 decreasing Integers.
		 * 10,000 increasing and random Integers.
		 * 
		 * For each call to the runSort() method to sort an ArrayType using a SortType ten times, your main() method will produce the following output:
		 * 
		 * SortType, ArrayType, Array Size
		 * -------------------------------------------------------------------------------------------------------------------------
		 * testTime1 testTime2 testTime3 testTime4 testTime5 testTime6 testTime7 testTime8 testTime9 testTime10 --- Average testTime
		 */
		Driver driver = new Driver();
		
		for (SortType sortMethods : SortType.values()) {
			for (ArrayType arrays : ArrayType.values()) {
				TestTimes testTimeTracker = driver.runSort(sortMethods, arrays, 1000, 10);
				driver.print(sortMethods, arrays, 1000, testTimeTracker);
			}
		}
		
		for (SortType sortMethods : SortType.values()) {
			for (ArrayType arrays : ArrayType.values()) {
				TestTimes testTimeTracker = driver.runSort(sortMethods, arrays, 10000, 10);
				driver.print(sortMethods, arrays, 10000, testTimeTracker);
			}
		}
		
		
		
		
	}

}
