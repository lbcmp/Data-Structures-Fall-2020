/**Please note that your search method must measure the run time and add it to the TestTimes class by using the addTestTime() method.*/

public class BinarySearch extends TestTimes implements SearchInterface {

	public int search(int[] listOfNumbers, int target) {
		/*
		 * This method is used for searching for a target value in an array representing a listOfNumbers.
		 * 
		 * @param listOfNumbers	An array of int values.
		 * @param target An int value representing the target we are searching for.
		 * 
		 * @return If the target value is found, the method will return the index of the target value in the listOfNumbers. Otherwise, the method will return -1.
		 */
		
		int low = 0;
		int high = listOfNumbers.length - 1;
		int mid;
		int returnIndex = -1;
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			if (listOfNumbers[mid] == target) {
				returnIndex = mid;
				break;
			} else if (listOfNumbers[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
        
		return returnIndex;
	}
}
