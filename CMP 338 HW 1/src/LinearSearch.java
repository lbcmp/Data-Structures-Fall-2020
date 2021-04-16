/**Please note that your search method must measure the run time and add it to the TestTimes class by using the addTestTime() method.*/

public class LinearSearch extends TestTimes implements SearchInterface {

	public int search(int[] listOfNumbers, int target) {
		/*
		 * This method is used for searching for a target value in an array representing a listOfNumbers.
		 * 
		 * @param listOfNumbers	An array of int values.
		 * @param target An int value representing the target we are searching for.
		 * 
		 * @return If the target value is found, the method will return the index of the target value in the listOfNumbers. Otherwise, the method will return -1.
		 */
		
		int returnIndex = -1;
		
		for (int i = 0; i < listOfNumbers.length; ++i) {
			if (listOfNumbers[i] == target) {
				returnIndex = i;
			}
		}
        
		return returnIndex;
	}
}
