import java.util.Arrays;

/**
 * You will write the Driver.java class which will implement the Driver Interface. 
 * 
 */

public class Driver implements DriverInterface {
	
	public Integer[] createArray(ArrayType arrayType, int arraySize) {
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
		
		Integer[] arrayToSort = new Integer[arraySize];
		
		switch (arrayType) {
		
		case Equal:
			Arrays.fill(arrayToSort, 25);
			
			break;
			
		case Random:
			for (int i = 0; i < arraySize; ++i) {
				arrayToSort[i] = (int)(Math.random() * 2147483647);
			}
			
			break;
			
		case Increasing:
			for (int i = 0; i < arraySize; ++i) {
				arrayToSort[i] = i;
			}
			
			break;
			
		case Decreasing:
			int index = 0;
			for (int i = arrayToSort.length - 1; i >= 0; --i) {
				arrayToSort[index] = i;
				++index;
			}
			
			break;
			
		case IncreasingAndRandom:
			int ninetyPercent = (int)(arraySize * 0.9);
			
			for (int i = 0; i < arraySize; ++i) {
				if (i > (ninetyPercent - 1)) {
					arrayToSort[i] = (int)(Math.random() * 2147483647);
				} else {
					arrayToSort[i] = i;
				}
			}
			
			break;
		}
		
		return arrayToSort;
	}
	
	public TestTimes[] runSorts(ArrayType arrayType, int arraySize, int numberOfTimes) {
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
		 * @return The method must return an array of TestTime instances. The array will contain the the following
		 * instances:
		 *  
		 *  MergeSort
		 *  QuickSort PivotType.FirstElement
		 *  QuickSort PivotType.RandomElement
		 *  QuickSort PivotType.MidOfFirstMidLastElement
		 *  HeapSort
		 *  
		 */
		
		int resetNumberOfTimes = numberOfTimes;
		
		TestTimes[] testTimeArr = new TestTimes[5];
		int testTimeArrIndex = 0;		
		
		for (SortType sortType : SortType.values()) {
			numberOfTimes = resetNumberOfTimes;
			
			switch(sortType) {
			
			case MergeSort:
				MergeSort<Integer> mergeSortObject = new MergeSort<Integer>();

				while(numberOfTimes > 0) {
					Integer[] arrayToSort = createArray(arrayType, arraySize);
					
					mergeSortObject.sort(arrayToSort);
					testTimeArr[testTimeArrIndex] = mergeSortObject;
			
					--numberOfTimes;
				}
				
				++testTimeArrIndex;
						
				break;
				
			case QuickSort:
				for (int i = 0; i <= 2; ++i) {
					numberOfTimes = resetNumberOfTimes;
					
					QuickSort<Integer> quickSortObject = new QuickSort<Integer>();
					
					while(numberOfTimes > 0) {

						Integer[] arrayToSort = createArray(arrayType, arraySize);
					
						if (i == 0) {
							quickSortObject.setPivotType(QuickSort.valueOf("FirstElement"));
						} else if (i == 1) {
							quickSortObject.setPivotType(QuickSort.valueOf("RandomElement"));
						} else {
							quickSortObject.setPivotType(QuickSort.valueOf("MidOfFirstMidLastElement"));
						}
						
						quickSortObject.sort(arrayToSort);
						testTimeArr[testTimeArrIndex] = quickSortObject;
				
						--numberOfTimes;
					}
					
					++testTimeArrIndex;
				}
				
				break;
				
			case HeapSort:
				HeapSort<Integer> heapSortObject = new HeapSort<Integer>();

				while(numberOfTimes > 0) {
					Integer[] arrayToSort = createArray(arrayType, arraySize);
					
					heapSortObject.sort(arrayToSort);
					testTimeArr[testTimeArrIndex] = heapSortObject;
			
					--numberOfTimes;
				}
				
				++testTimeArrIndex;
				
				break;
			}
		}
		
		return testTimeArr;
	}
	
	public void print(TestTimes[] testTimesArr, ArrayType arrayType, int arraySize) {
		
		/**
		 * For each call to the runSort() method to sort an ArrayType using a SortType ten times, your main() method will produce the following output:

ArrayType, Array Size
---------------------
                                    Run 1   Run 2   Run 3   Run 4   Run 5   Run 6   Run 7   Run 8   Run 9  Run 10 Average               
                                    Micro   Micro   Micro   Micro   Micro   Micro   Micro   Micro   Micro   Micro   Micro
		                   Seconds Seconds Seconds Seconds Seconds Seconds Seconds Seconds Seconds Seconds Seconds
                    		   ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- -------
                         MergeSort
            QuickSort FirstElement
           QuickSort RandomElement
QuickSort MidOfFirstMidLastElement
                          HeapSort
	
		                      Run 1      Run 2      Run 3      Run 4      Run 5      Run 6      Run 7      Run 8      Run 9     Run 10     Average
		                   Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes
				   ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ----------
                         MergeSort
            QuickSort FirstElement
           QuickSort RandomElement
QuickSort MidOfFirstMidLastElement
                          HeapSort
		 * 
		 * 
		 */
		
		int timesQSTracker = 0;
		int memoryQSTracker = 0;
		
		for (int testTimesArrIndex = 0; testTimesArrIndex < testTimesArr.length; ++testTimesArrIndex) {
			double[] testTimes = testTimesArr[testTimesArrIndex].getTestTimes();
			double[] memoryUsage = testTimesArr[testTimesArrIndex].getMemoryUsages();
			
			System.out.println(arrayType.toString() + " " + arraySize);
			System.out.println("------------------------\n");
			
			//TestTimes
			System.out.print("    ");
			
			for (int i = 1; i <= testTimes.length; ++i) {
				System.out.print("      Run " + i);
			} 
			
			System.out.print("   Average\n\t");
			
			for (int i = 0; i < testTimes.length; ++i) {
				System.out.print(testTimes[i] + "  ");
			}
			
			System.out.print(testTimesArr[testTimesArrIndex].getAverageTestTime() + "\n\t");
			
			for (int i = 0; i < testTimes.length; ++i) {
				System.out.print(testTimesArr[testTimesArrIndex].getTimeUnits() + "  ");
			}
						
			System.out.println("\n");
			
			if (testTimesArrIndex == 0) {
				System.out.println(SortType.MergeSort.toString() + "\n");
			} else if (testTimesArrIndex == 4) {
				System.out.println(SortType.HeapSort.toString() + "\n");
			} else {
				System.out.print(SortType.QuickSort.toString() + ", ");
				
				if (timesQSTracker == 0) {
					System.out.println(QuickSort.valueOf("FirstElement").toString() + "\n");
				} else if (timesQSTracker == 1) {
					System.out.println(QuickSort.valueOf("RandomElement").toString() + "\n");
				} else {
					System.out.println(QuickSort.valueOf("MidOfFirstMidLastElement").toString() + "\n");
				}
				
				++timesQSTracker;
			}
			
			//MemoryUsage
			System.out.print("    ");
			
			for (int i = 1; i <= memoryUsage.length; ++i) {
				System.out.print("      Run " + i);
			}
			
			System.out.print("   Average\n\t");
			
			for (int i = 0; i < memoryUsage.length; ++i) {
				System.out.print(memoryUsage[i] + "  ");
			}
			
			System.out.print(testTimesArr[testTimesArrIndex].getAverageMemoryUsage() + "\n\t");
			
			for (int i = 0; i < memoryUsage.length; ++i) {
				System.out.print(testTimesArr[testTimesArrIndex].getMemoryUnits() + "  ");
			}
						
			System.out.println("\n");
			
			if (testTimesArrIndex == 0) {
				System.out.println(SortType.MergeSort.toString() + "\n");
			} else if (testTimesArrIndex == 4) {
				System.out.println(SortType.HeapSort.toString() + "\n");
			} else {
				System.out.print(SortType.QuickSort.toString() + ", ");
				
				if (memoryQSTracker == 0) {
					System.out.println(QuickSort.valueOf("FirstElement").toString() + "\n");
				} else if (memoryQSTracker == 1) {
					System.out.println(QuickSort.valueOf("RandomElement").toString() + "\n");
				} else {
					System.out.println(QuickSort.valueOf("MidOfFirstMidLastElement").toString() + "\n");
				}
				
				++memoryQSTracker;
			}
		}
		
		System.out.println("--------------------------------------------------------------------------------------\n");
	}
	
	public static void main(String[] args) {
		/**
		 * 
		 * Please note that, in addition to implementing the DriverInterface, you are also required to write your own 
		 * public static main(String[] args) method in Driver.java.
		 * 
		 * Your main() method will have to call the runSort() method to sort each of the following array types ten times for each sort algorithm:
		 * 
		 * 		1. 1,000 equal Integers.
		 * 		2. 1,000 random Integers.
		 * 		3. 1,000 increasing Integers.
		 * 		4. 1,000 decreasing Integers.
		 * 		5. 1,000 increasing and random Integers.
		 * 		6. 10,000 equal Integers.
		 * 		7. 10,000 random Integers.
		 * 		8. 10,000 increasing Integers.
		 * 		9. 10,000 decreasing Integers.
		 * 		10. 10,000 increasing and random Integers.
		 */
		
		Driver driver = new Driver();
		int numberOfTimes = 10;
		
		System.out.println("/*********** arraySize: 1000 ***********/\n");
		
		for (ArrayType arrayType : ArrayType.values()) {
			int arraySize = 1000;
			TestTimes[] testTimesArr = driver.runSorts(arrayType, arraySize, numberOfTimes);
			driver.print(testTimesArr, arrayType, arraySize);
		}
		
		System.out.println("\n/*********** arraySize: 10000 ***********/\n");
		
		for (ArrayType arrayType : ArrayType.values()) {
			int arraySize = 10000;
			TestTimes[] testTimesArr = driver.runSorts(arrayType, arraySize, numberOfTimes);
			driver.print(testTimesArr, arrayType, arraySize);
		}
		
	}

}
