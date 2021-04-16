public class BubbleSort extends TestTimes /*implements SortInterface*/ {
	
	/*
	 * You will write the BubbleSort.java class which will inherit from TestTimes.java and implement the Sort Interface using the Bubble Sort algorithm. 
	 * The interface may be downloaded from SortInterface.java
	 * Please note that your sort method must measure the run time and add it to the TestTimes class by using the addTestTime() method.
	 */
	
	public void sort(Integer[] arrayToSort) {
		/*
		 * This method is called to sort the given array of Integer objects. At the completion of this method, the array will be sorted.
		 * 
		 * @param arrayToSort This is the array that contains all the Integer objects that need to be sorted.
		 */
		
		int lastIndex = arrayToSort.length - 1;
		
		while (lastIndex > 0) {
			int i = 0;
			
			while (i < lastIndex) {
				if (arrayToSort[i] > arrayToSort[i + 1]) {
					int temp = arrayToSort[i];
					arrayToSort[i] = arrayToSort[i + 1];
					arrayToSort[i + 1] = temp;
				}
				++i;
			}
			--lastIndex;
		}
	}

}
