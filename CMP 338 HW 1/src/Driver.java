/**
 * You will write the Driver.java class to test your implementations of:
 * 1. TestTimes.java
 * 2. LinearSearch.java
 * 3. BinarySearch.java
 * 
 * Please note that, in addition to implementing the DriverInterface, you are also required to write your own public static main(String[] args)
 * method in Driver.java that tests all of your classes and methods before submitting your assignment on mimir.
 */

import java.util.Scanner;

public class Driver implements DriverInterface {

	public int[] getListOfNumbers() {
		/*
		 * This method will generate and return a sorted array of int values starting at 1 and ending at 10,000,000. 
		 * @return An int array containing the numbers from 1 to 10,000,000.
		 */
		
		int[] listOfNumbers = new int[10000000];
		for (int i = 0; i < 10000000; ++i) {
			listOfNumbers[i] = i + 1;
		}
		return listOfNumbers;
	}
	
	public int[] getTargets() {
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
		
		int[] targets = {500, 10000, 100000, 1000000, 5000000, 7500000, 10000000};
		return targets;
	}
	
	public TestTimes runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
		/*
		 * This method should create an instance of the LinearSearch.java class and run the search for the specified target in the listOfNumbers a total of numberOfTimes.
		 * 
		 * @param listOfNumbers	An int array containing the numbers to search through.
		 * @param target The number we will search for.
		 * @param numberOfTimes The number of times to conduct the search.
		 * 
		 * @return The method must return the TestTimes class that was used to save the measured test times for the linear searches performed.
		 */
		
		TestTimes testTimeTracker = new TestTimes();
		LinearSearch linSearchObj = new LinearSearch();
		long startTime;
		long endTime;
		long testTime;
		
		while (numberOfTimes > 0) {
			startTime = System.nanoTime();
			
			linSearchObj.search(listOfNumbers, target);
			
			endTime = System.nanoTime(); 
	        testTime = endTime - startTime;
			testTimeTracker.addTestTime(testTime);
			
			--numberOfTimes;
		}
		
		return testTimeTracker;
	}
	
	public TestTimes runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
		/*
		 * This method should create an instance of the BinarySearch.java class and run the search for the specified target in the listOfNumbers a total of numberOfTimes.
		 * 
		 * @param listOfNumbers	An int array containing the numbers to search through.
		 * @param target The number we will search for.
		 * @param numberOfTimes The number of times to conduct the search.
		 * 
		 * @return The method must return the TestTimes class that was used to save the measured test times for the binary searches performed.
		 */
		
		TestTimes testTimeTracker = new TestTimes();
		BinarySearch binSearchObj = new BinarySearch();
		long startTime;
		long endTime;
		long testTime;
        
		while (numberOfTimes > 0)  {
			startTime = System.nanoTime();
			
			binSearchObj.search(listOfNumbers, target);
			
			endTime = System.nanoTime(); 
	        testTime = endTime - startTime;
			testTimeTracker.addTestTime(testTime);
			
			--numberOfTimes;
		}
		
		return testTimeTracker;
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Driver driver = new Driver();
		TestTimes testTimesObj = new TestTimes();
		int[] listOfNumbers = driver.getListOfNumbers();
		int[] targets = driver.getTargets();
		int targetIndex;
		int numTimes;
		int binOrLin;
		
		System.out.println("\nDo you want to run a linear search (0) or a binary search (1)?");
		binOrLin = scnr.nextInt();
		
		if (binOrLin == 0) {
			System.out.println("\nRunning linear search. Which target do you want to look for? Indicate the index (0 - 6)");
			targetIndex = scnr.nextInt();
			System.out.println("\nHow many times do you want to run the search?");
			numTimes = scnr.nextInt();
			
			testTimesObj = driver.runLinearSearch(listOfNumbers, targets[targetIndex], numTimes);
			long[] testTimes = testTimesObj.getTestTimes();
			
			System.out.println("\nRunning linear search on " + targets[targetIndex] + " " + numTimes + " times. Here are the run times:\n");
			for (int i = 0; i < testTimes.length; ++i) {
				if (testTimes[i] != 0) {
					System.out.println(testTimes[i]);
				}
			}
		} else if (binOrLin == 1) {
			System.out.println("\nRunning binary search. Which target do you want to look for? Indicate the index (0 - 6)");
			targetIndex = scnr.nextInt();
			System.out.println("\nHow many times do you want to run the search?");
			numTimes = scnr.nextInt();
			
			testTimesObj = driver.runBinarySearch(listOfNumbers, targets[targetIndex], numTimes);
			long[] testTimes = testTimesObj.getTestTimes();
			
			System.out.println("\nRunning binary search on " + targets[targetIndex] + " " + numTimes + " times. Here are the run times:\n");
			for (int i = 0; i < testTimes.length; ++i) {
				if (testTimes[i] != 0) {
					System.out.println(testTimes[i]);
				}
			}
		} else {
			System.exit(0);
		}
		
		double averageTestTime = testTimesObj.getAverageTestTime();
		System.out.println("\nFound average of all the test times: " + averageTestTime);
		
		TestTimes newTestTimesObj = testTimesObj;
		System.out.println("\nCloned the previous test times object.");
		
		newTestTimesObj.addTestTime(10942);
		System.out.println("\nAdded new test time to the test times array: " + testTimesObj.getLastTestTime());
		
		System.out.println("\nRetrieved and printed list of test times: ");
		long[] newTestTimesArr = newTestTimesObj.getTestTimes();
		for (int i = 0; i < newTestTimesArr.length; ++i) {
			if (newTestTimesArr[i] != 0) {
				System.out.println(newTestTimesArr[i]);
			}
		}
		
		averageTestTime = newTestTimesObj.getAverageTestTime();
		System.out.println("\nFound NEW average of all the test times: " + averageTestTime);
		
		System.out.println("\nResetting new test times object.");
		newTestTimesObj.resetTestTimes();
		
		newTestTimesArr = newTestTimesObj.getTestTimes();
		for (int i = 0; i < newTestTimesArr.length; ++i) {
			System.out.println(newTestTimesArr[i]);
		}
		
	}
}
