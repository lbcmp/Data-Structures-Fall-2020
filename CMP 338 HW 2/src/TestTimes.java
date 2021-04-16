/**
 * The TestTimes class will contain an array of 10 long values and a counter of how many values have been added using addTestTime(long testTime). 
 * Every time a new test time is added, the counter is incremented.
 */

public class TestTimes implements TestTimesInterface{
	
	//You will copy the TestTimes class that you created in Homework 1 to the project you are using for this assignment.
	
	public long[] testTimes = new long[10]; 
	public int numTestTimes = 0;
	
	public long getLastTestTime() {
		/* 
		 * This method is used to retrieve the last test time. If no test time has been added, the method will return a zero.
		 * @return The last test time, in nanoseconds, or zero
		 */
		
		for (int i = 9; i >= 0; --i) {
			if (testTimes[i] != 0) {
				return testTimes[i];
			}
		}
		return 0;
	}
	
	public long[] getTestTimes() {
		/*
		 * This method returns an array of long values representing the last 10 test times. 
		 * If less than 10 test times are available, the remaining test times should be zero. 
		 * If more than 10 test times have been added, the array should contain the last 10 test times. 
		 * @return An array of long values representing the last 10 test times.
		 */
		return testTimes.clone();
	}
	
	public void resetTestTimes() {
		//This method is used to reset all 10 linear search times to zero.
	
		numTestTimes = 0;
		for (int i = 0; i < testTimes.length; ++i) {
			testTimes[i] = 0;
		}
	}
	
	public void addTestTime(long testTime) {
		/*
		 * This method is used to add a test time.
		 * @param testTime a long value representing the test time in nanoseconds.
		 */
		
		if (numTestTimes == testTimes.length) {
			for (int i = 0; i < testTimes.length - 1; ++i) {
				testTimes[i] = testTimes[i + 1];
			}
			testTimes[numTestTimes - 1] = testTime;
		} else {
			testTimes[numTestTimes++] = testTime;
		}
	}
	
	public double getAverageTestTime() {
		/*
		 * This method is used to obtain the average test time. 
		 * The method should average all the non-zero test times that are available. If no test times are available, the method returns a zero.
		 * @return A double value representing the average of all the non-zero test times, or zero.
		 */
		
		if (testTimes[0] == 0) {
			return 0;
		}
		
		int sum = 0;
		int numValues = 0;
		for (int i = 0; i < testTimes.length; ++i) {
			if (testTimes[i] != 0) {
				sum += testTimes[i];
				++numValues;
			} else {
				break;
			}
		}
		return (double)sum / numValues;
	}
}


