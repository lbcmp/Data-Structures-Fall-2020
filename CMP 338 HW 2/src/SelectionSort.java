public class SelectionSort extends TestTimes /*implements SortInterface*/ {

	/*
	 * You will write the SelectionSort.java class which will inherit from TestTimes.java and implement the Sort Interface using the Selection Sort algorithm. 
	 * The interface may be downloaded from SortInterface.java
	 * Please note that your sort method must measure the run time and add it to the TestTimes class by using the addTestTime() method.
	 */
	
	public void sort(Integer[] arrayToSort) {
		/*
		 * This method is called to sort the given array of Integer objects. At the completion of this method, the array will be sorted.
		 * 
		 * @param arrayToSort This is the array that contains all the Integer objects that need to be sorted.
		 */
		
		for (int i = 0; i < arrayToSort.length - 1; ++i) {
			int smallestIndex = i;
			for (int j = i + 1; j < arrayToSort.length; ++j) {
				if (arrayToSort[j] < arrayToSort[smallestIndex]) {
					smallestIndex = j;
				}
			}
			int temp = arrayToSort[i];
			arrayToSort[i] = arrayToSort[smallestIndex];
			arrayToSort[smallestIndex] = temp;
		}
	}
	
}
