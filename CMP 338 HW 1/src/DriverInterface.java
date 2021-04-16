/** These are the methods that you will use to exercise your LinearSearch.java and BinarySearch classes.*/

public interface DriverInterface {
		
	/*
	 * This method will generate and return a sorted array of int values starting at 1 and ending at 10,000,000. 
	 * @return An int array containing the numbers from 1 to 10,000,000.
	 */
	public int[] getListOfNumbers();
	
	/*
	 * This method will return an int array containing the following values:
	 * 
	 * 500
	 * 10,000
	 * 100,000
	 * 1,000,000
	 * 5,000,000
	 * 7,500,000
	 * 10,000,000
	 * 
	 * @return An int array containing the values specified above.
	 */
	public int[] getTargets();
	
	/*
	 * This method should create an instance of the LinearSearch.java class and run the search for the specified target in the listOfNumbers a total of numberOfTimes.
	 * 
	 * @param listOfNumbers	An int array containing the numbers to search through.
	 * @param target The number we will search for.
	 * @param numberOfTimes The number of times to conduct the search.
	 * 
	 * @return The method must return the TestTimes class that was used to save the measured test times for the linear searches performed.
	 */
	public TestTimes runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes);
	
	/*
	 * This method should create an instance of the BinarySearch.java class and run the search for the specified target in the listOfNumbers a total of numberOfTimes.
	 * 
	 * @param listOfNumbers	An int array containing the numbers to search through.
	 * @param target The number we will search for.
	 * @param numberOfTimes The number of times to conduct the search.
	 * 
	 * @return The method must return the TestTimes class that was used to save the measured test times for the binary searches performed.
	 */
	public TestTimes runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes);
}
