/**
 * You will copy the TestTimes class that you enhanced in Homework 4 to the project you are using for this assignment.
 */

public class TestTimes implements TestTimesInterface {

	private long[] testTimes;
	private long[] memoryUsage;
	private int numTestTimes;
	private int numMemoryMeasurements;
	private TimeUnits timeUnit;
	private MemoryUnits memoryUnit;
	
	public TestTimes() {
		testTimes = new long[10];
		memoryUsage = new long[10];
		numTestTimes = 0;
		timeUnit = TimeUnits.valueOf("NanoSeconds");
		memoryUnit = MemoryUnits.valueOf("Bytes");
	}
	
	public TestTimes(String timeUnitString, String memoryUnitString) {
		testTimes = new long[10];
		memoryUsage = new long[10];
		numTestTimes = 0;
		this.timeUnit = TimeUnits.valueOf(timeUnitString);
		this.memoryUnit = MemoryUnits.valueOf(memoryUnitString);
	}
	
	public TimeUnits getTimeUnits() {
		/**
		 * 
		 * This method is used to obtain the current {@link TimeUnits} configured for the RunTime
		 * class. Please note that the default TimeUnits is NanoSeconds
		 * 
		 * @return The currently configured TimeUnits.
		 * 
		 */
		
		return timeUnit;
	}
	
	public void setTimeUnits(TimeUnits timeUnits) {
		/**
		 * 
		 * This method is used to configure the desired {@link TimeUnits}.
		 * 
		 * @param timeUnits The desired TimeUnits
		 * 
		 */
		
		this.timeUnit = timeUnits;
	}
	
	public MemoryUnits getMemoryUnits() {
		/**
		 * 
		 * This method is used to obtain the current {@link MemoryUnits} configured for the RunTime
		 * class. Please note that the default MemoryUnits is Bytes
		 * 
		 * @return The currently configured MemoryUnits.
		 * 
		 */
		
		return memoryUnit;
	}
	
	public void setMemoryUnits(MemoryUnits memoryUnits) {
		/**
		 * 
		 * This method is used to configure the desired {@link MemoryUnits}.
		 * 
		 * @param memoryUnits The desired MemoryUnits
		 * 
		 */
		
		this.memoryUnit = memoryUnits;
	}
	
	public double getLastTestTime() {
		/**
		 * 
		 * This method is used to retrieve the last test time. If no test time
		 * has been added, the method will return a zero.
		 * 
		 * @return The last test time, converted to the configured {@link TimeUnits},
		 * or 0.
		 *  
		 */
		
		for (int i = testTimes.length - 1; i >= 0; --i) {
			if (testTimes[i] != 0) {
				double convertedTestTime = testTimeConverter(testTimes[i]);
				return convertedTestTime;
			}
		}
		return 0.0;
	}
	
	public double getLastMemoryUsage() {
		/**
		 * 
		 * This method is used to retrieve the last test time. If no test time
		 * has been added, the method will return a zero.
		 * 
		 * @return The last test time, converted to the configured {@link MemoryUnits},
		 * or 0.0.
		 *  
		 */
		
		for (int i = memoryUsage.length - 1; i >= 0; --i) {
			if (memoryUsage[i] != 0) {
				double convertedMemoryMeasurement = memoryUsageConverter(memoryUsage[i]);
				return convertedMemoryMeasurement;
			}
		}
		return 0.0;
	}
	
	public double[] getTestTimes() {
		/**
		 * 
		 * This method returns an array of double values representing the last 10 test times
		 * converted to the configured {@link TimeUnits}. If less than 10 test times are available, 
		 * the remaining test times should be zero. If more than 10 test times have been added, the array
		 * should contain the last 10 test times. 
		 * 
		 * @return An array of double values representing the last 10 test times.
		 * 
		 */
		
		double[] newTestTimesArray = new double[testTimes.length];
		
		for (int i = 0; i < newTestTimesArray.length; ++i) {
			newTestTimesArray[i] = testTimeConverter(testTimes[i]);
		}
		
		return newTestTimesArray;
		
	}
	
	public double[] getMemoryUsages() {
		/**
		 * 
		 * This method returns an array of double values representing the last 10 memory usages
		 * converted to the configured {@link MemoryUnits}. 
		 * If less than 10 memory usages are available, the remaining
		 * memory usages should be zero. If more than 10 memory usages have been added, the array
		 * should contain the last 10 memory usages. 
		 * 
		 * @return An array of double values representing the last 10 memory usages.
		 * 
		 */
		
		double[] newMemoryUsageArray = new double[memoryUsage.length];
		
		for (int i = 0; i < newMemoryUsageArray.length; ++i) {
			newMemoryUsageArray[i] = memoryUsageConverter(memoryUsage[i]);
		}
		
		return newMemoryUsageArray;
	}
	
	public void resetTestTimes() {
		//This method is used to reset all 10 linear search times to zero.
	
		numTestTimes = 0;
		for (int i = 0; i < testTimes.length; ++i) {
			testTimes[i] = 0;
		}
	}
	
	public void addTestTime(long runTime) {
		/**
		 * 
		 * This method is used to add a test time and capture the current memory usage.
		 * 
		 * @param runTime a long value representing the test time in nanoseconds.
		 * 
		 */
		
		if (numTestTimes == testTimes.length) {
			for (int i = 0; i < testTimes.length - 1; ++i) {
				testTimes[i] = testTimes[i + 1];
			}
			testTimes[numTestTimes - 1] = runTime;
		} else {
			testTimes[numTestTimes++] = runTime;
		}
		
		if (numMemoryMeasurements == memoryUsage.length) {
			for (int i = 0; i < memoryUsage.length - 1; ++i) {
				memoryUsage[i] = memoryUsage[i + 1];
			}
			double memoryInUse = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			memoryUsage[numMemoryMeasurements - 1] = (long) memoryInUse;
		} else {
			double memoryInUse = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			memoryUsage[numMemoryMeasurements++] = (long) memoryInUse;
		}
	}
	
	public double getAverageTestTime() {
		/**
		 * 
		 * This method is used to obtain the average test time. The method should average all
		 * the non-zero test times that are available. If no test times are available, the method
		 * returns a zero.
		 * 
		 * @return A double value representing the average of all the non-zero test times, 
		 * converted to the configured {@link TimeUnits} or 0.
		 */
		
		if (testTimes[0] == 0) {
			return 0.0;
		}
		
		double sum = 0;
		for (int i = 0; i < testTimes.length; ++i) {
			if (testTimes[i] != 0) {
				sum += testTimeConverter(testTimes[i]);
			} else {
				break;
			}
		}
		
		return	sum / numTestTimes;
	}
	
	public double getAverageMemoryUsage() {
		/**
		 * 
		 * This method is used to obtain the average memory usage. The method should average all
		 * the non-zero memory usages that are available. If no memory usages are available, the method
		 * returns a zero.
		 * 
		 * @return A double value representing the average of all the non-zero memory usages, 
		 * converted to the configured {@link MemoryUnits}, or 0.0.
		 * 
		 */
		
		if (memoryUsage[0] == 0) {
			return 0.0;
		}
		
		double sum = 0;
		for (int i = 0; i < memoryUsage.length; ++i) {
			if (memoryUsage[i] != 0) {
				sum += memoryUsageConverter(memoryUsage[i]);
			} else {
				break;
			}
		}
		
		return	sum / numTestTimes;
	}
	
	public double testTimeConverter(long testTime) {
		double convertedTestTime = (double) testTime;
		
		switch(timeUnit) {
		case Seconds:
			convertedTestTime /= 1000000000.0;
			break;
		
		case MilliSeconds:
			convertedTestTime /= 1000000.0;
			break;
			
		case MicroSeconds:
			convertedTestTime /= 1000.0;
			break;
			
		case NanoSeconds:
			break;
		}
			
		return convertedTestTime;
	}
	
	public double memoryUsageConverter(long memoryMeasurement) {
		double convertedMemoryMeasurement = (double) memoryMeasurement;
		
		switch (memoryUnit) {
		case KiloBytes:
			convertedMemoryMeasurement /= 1024.0;
			break;
		case MegaBytes:
			convertedMemoryMeasurement /= (1024.0 * 1024.0);
			break;
		case Bytes:
			break;
		}
		
		return convertedMemoryMeasurement;
	}
}