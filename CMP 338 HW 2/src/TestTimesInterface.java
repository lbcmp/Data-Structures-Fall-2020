/**
 * 
 * This interface will be used to organize and manage test times that are measured for specific operations.
 * 
 * The user will utilize System.nanoTime() to measure the time it takes to complete an operation.
 * 
 * Before the operation is started, you can obtain the start time: startTime = System.nanoTime().
 * After the operation is completed, you can obtain the end time: endTime = System.nanoTime().
 * Test Time is then: testTime = endTime - startTime. 
 *
 */
public interface TestTimesInterface {
	
	/* 
	 * This method is used to retrieve the last test time. If no test time has been added, the method will return a zero.
	 * @return The last test time, in nanoseconds, or zero
	 */
	public long getLastTestTime();
	
	/*
	 * This method returns an array of long values representing the last 10 test times. 
	 * If less than 10 test times are available, the remaining test times should be zero. 
	 * If more than 10 test times have been added, the array should contain the last 10 test times. 
	 * @return An array of long values representing the last 10 test times.
	 */
	public long[] getTestTimes();

	//This method is used to reset all 10 linear search times to zero.
	public void resetTestTimes();

	/*
	 * This method is used to add a test time.
	 * @param testTime a long value representing the test time in nanoseconds.
	 */
	public void addTestTime(long testTime);
	
	/*
	 * This method is used to obtain the average test time. 
	 * The method should average all the non-zero test times that are available. If no test times are available, the method returns a zero.
	 * @return A double value representing the average of all the non-zero test times, or zero.
	 */
	public double getAverageTestTime();
	
}

