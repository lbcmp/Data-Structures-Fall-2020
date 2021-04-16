public class InsertionSort extends TestTimes /*implements SortInterface*/ {
	
	/*
	 * You will write the InsertionSort.java class which will inherit from TestTimes.java and implement the Sort Interface using the Insertion Sort algorithm. 
	 * The interface may be downloaded from SortInterface.java
	 * Please note that your sort method must measure the run time and add it to the TestTimes class by using the addTestTime() method.
	 */
	
	public void sort(Integer[] arrayToSort) {
		/*
		 * This method is called to sort the given array of Integer objects. At the completion of this method, the array will be sorted.
		 * 
		 * @param arrayToSort This is the array that contains all the Integer objects that need to be sorted.
		 */
		
		for (int i = 1; i < arrayToSort.length; ++i) {
			int j = i;
			while (j > 0 && arrayToSort[j] < arrayToSort[j - 1]) {
		         
				int temp = arrayToSort[j];
				arrayToSort[j] = arrayToSort[j - 1];
				arrayToSort[j - 1] = temp;
				--j;
			}
		}
		
		
	}

}
