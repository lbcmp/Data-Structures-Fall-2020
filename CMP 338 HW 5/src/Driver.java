/**You will write the Driver.java class which will implement the Driver Interface.*/

/**
 * Hints:
 * 
 * a. Your Driver will create an Array for LinkedList<Person<Integer>, Integer> objects (See the Person class below) like this:
 *    LinkedList<Person<Integer>, Integer>[] myBuckets = new LinkedList[HashTable.NUMBER_OF_BUCKETS];
 * 
 * b. You will then have to populate this new array with LinkedList<Person<Integer>, Integer> objects that you create.
 * 
 * c. Your Driver will then instantiate the HashTable as follows:
 *    HashTable<Person<Integer>, Integer> hashTable = new HashTable<Person<Integer>, Integer>(myBuckets);
 */

public class Driver implements DriverInterface {
	
	public Person<Integer>[] createPersons(int numPeople) {
		/**
		 *
		 * This method is used to create array with the specified number of Person<Integer> instances.
		 * 
		 * @param numPeople	The number of Person<Integer> instances to create.
		 * 
		 * @return	This method returns a Vector<Person<Integer>> with the specified number of Person<Integer> instances.
		 */
		
		@SuppressWarnings("unchecked")
		Person<Integer>[] personArray = new Person[numPeople];
		
		for (int i = 0; i < numPeople; ++i) {
			personArray[i] = new Person<Integer>(i);
		}
		
		return personArray;
	}
	
	public LinkedList<Person<Integer>, Integer>[] createBuckets(int numBuckets) {
		/**
		 * 
		 * This method create the buckets that are needed for the
		 * HashTable<Person<Integer>, Integer>.
		 * 
		 * @param numBuckets	The number of buckets needed for the HashTable<Person<Integer>, Integer>.
		 * 	
		 * @return	An array of LinkedList<Person<Integer>, Integer> containing the specified number
		 * 			of LinkedList<Person<Integer>, Integer> instances.
		 */
		
		@SuppressWarnings("unchecked")
		LinkedList<Person<Integer>, Integer>[] myBuckets = new LinkedList[numBuckets];
		
		for (int i = 0; i < numBuckets; ++i) {
			myBuckets[i] = new LinkedList<Person<Integer>, Integer>();
		}
		
		return myBuckets;
	}
	
	public HashTable<Person<Integer>, Integer> createHashTable(TestType testType, int numPeople) {
		/**
		 * 
		 * This method is used to create a HashTable<Person<Integer>, Integer> for the specified testType.
		 * 
		 * @param testType	The type of test for the created HashTable.
		 * 					
		 * 		Insert: The returned HashTable must be empty				
		 * 						
		 * 		Get: The returned HashTable must contain the specified number of Person<Integer> instances.
		 * 						
		 * 		Remove: The returned HashTable must contain the specified number of Person<Integer> instances.
		 * 						
		 * 
		 * @param numPeople	The number of Person<Integer> instances to include in
		 * 					the returned HashTable.
		 * 
		 * @return	This method will return an instance of HashTable<Person<Integer>, Integer>
		 * 			containing the specified number of Person<Integer> instances
		 */
		
		LinkedList<Person<Integer>, Integer>[] myBuckets = createBuckets(HashTable.NUMBER_OF_BUCKETS);
		Person<Integer>[] personArray = createPersons(numPeople);
		HashTable<Person<Integer>, Integer> hashTable = null;
		
		try {
			hashTable = new HashTable<Person<Integer>, Integer>(myBuckets);
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		switch (testType) {
		
		case Insert:			
			break;
		
		case Get:
			for (int i = 0; i < numPeople; ++i) {
				hashTable.insert(personArray[i]);
			}
			
			break;
			
		case Remove:
			for (int i = 0; i < numPeople; ++i) {
				hashTable.insert(personArray[i]);
			}
			
			break;
		}
		
		return hashTable;
	}
	
	public TestTimes runTestCase(TestType testType, int numPeople, int numberOfTimes) {
		/**
		 * This method is called to run a particular test case on the HashTable<Person<Integer>, Integer>
		 * the specified number of times. The run time 	 * and memory usage for each run is saved in the TestTimes class.
		 * 
		 * @param testType		The test type to be run.
		 * @param numPeople		The number of Person<Integer> instances to include in the test.
		 * @param numberOfTimes The type of test case being run. See the enum {@link TestType}.
		 * 
		 * @return	An instance of the TestTimes class containing the test times and memory usages.
		 */
		
		/**
		 * You will be creating 100,000 instances of the Person<Integer> class for insertion into the HashTable<Person<Integer>, Integer>.
		 * Save all your generated Person<Integer> objects in a Vector<Person<Integer>>. Your test cases will be:
		 * 
		 * 1. Create an empty HashTable<Person<Integer>, Integer> and insert all the Person objects into your HashTable.
		 * 
		 * 2. Create a fully populated HashTable<Person<Integer>, Integer> with all 100,000 Person<Integer> objects and use the get method to find
		 * all the Person objects in your HashTable.
		 * 
		 * 3. Create a fully populated HashTable<Person<Integer>, Integer> with all 100,000 Person<Integer> objects and use the remove method to remove
		 * all the Person objects from your HashTable one at a time.
		 */
		
		TestTimes testTimeTracker = new TestTimes("MicroSeconds", "KiloBytes");
		long startTime;
		long endTime;
		long testTime;
		
		Person<Integer>[] personsArray = createPersons(numPeople);
        
		while (numberOfTimes > 0)  {
			startTime = System.nanoTime();
			
			HashTable<Person<Integer>, Integer> hashTable = createHashTable(testType, numPeople);
			
			switch (testType) {
			
			case Insert:
				for (int i = 0; i < numPeople; ++i) {
					hashTable.insert(personsArray[i]);
				}
				
				break;
			
			case Get:
				for (int i = 0; i < numPeople; ++i) {
					hashTable.get(personsArray[i].getKey());
				}
				
				break;
				
			case Remove:
				for (int i = 0; i < numPeople; ++i) {
					hashTable.remove(personsArray[i].getKey());
				}
				
				break;
			}
			
			endTime = System.nanoTime(); 
	        testTime = endTime - startTime;
			testTimeTracker.addTestTime(testTime);
						
			--numberOfTimes;
		}
		
		return testTimeTracker;
	}
	
	public void print(TestType testType, int numPeople, TestTimes testTimesTracker) {
		double[] testTimes = testTimesTracker.getTestTimes();
		double[] memoryUsage = testTimesTracker.getMemoryUsages();
		
		//TestTimes
		System.out.print("    ");
		
		for (int i = 1; i <= testTimes.length; ++i) {
			System.out.print("    Run " + i);
		}
		
		System.out.print("   Average\n\t");
		
		for (int i = 0; i < testTimes.length; ++i) {
			System.out.print(testTimes[i] + "  ");
		}
		
		System.out.print(testTimesTracker.getAverageTestTime() + "\n\t");
		
		for (int i = 0; i < testTimes.length; ++i) {
			System.out.print(testTimesTracker.getTimeUnits() + "  ");
		}
		
		System.out.println("\n" + testType.toString() + "\n\n");
		
		//MemoryUsage
		System.out.print("    ");
		
		for (int i = 1; i <= memoryUsage.length; ++i) {
			System.out.print("    Run " + i + "    ");
		}
		
		System.out.print("   Average\n\t");
		
		for (int i = 0; i < memoryUsage.length; ++i) {
			System.out.print(memoryUsage[i] + "  ");
		}
		
		System.out.print(testTimesTracker.getAverageMemoryUsage() + "\n\t");
		
		for (int i = 0; i < memoryUsage.length; ++i) {
			System.out.print(testTimesTracker.getMemoryUnits() + "  ");
		}
		
		System.out.println("\n" + testType.toString() + "\n");
		
		System.out.println("---------------------------------------------------------------------------------------------\n");

	}
	
	public static void main(String[] args) {
		/**
		 * Please note that, in addition to implementing the DriverInterface, you are also required to write your own 
		 * public static main(String[] args) method in Driver.java.
		 * 
		 * Your main() method will have to call the runTestCase() method for each of test cases listed above a total of ten times for each test case:
		 * 
		 * For each call to the runTestCase() method your main() method will output a table with the following output:

			 Run 1   Run 2   Run 3   Run 4   Run 5   Run 6   Run 7   Run 8   Run 9  Run 10 Average
		         Micro   Micro   Micro   Micro   Micro   Micro   Micro   Micro   Micro   Micro   Micro
			Seconds Seconds Seconds Seconds Seconds Seconds Seconds Seconds Seconds Seconds Seconds
			------- -------	------- -------	------- -------	------- -------	------- -------	-------
		Insert
		Get
		Remove
			
			   Run 1      Run 2      Run 3      Run 4      Run 5      Run 6      Run 7      Run 8      Run 9     Run 10     Average
			Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes Kilo Bytes
			---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ----------
		Insert
		Get
		Remove
			
		 * Please note that the test times are in Micro Seconds and the memory usages are in Kilo Bytes.
		 */
		
		Driver driver = new Driver();
		int numPeople = 50;
		
		for (TestType testType : TestType.values()) {
			TestTimes testTimesTracker = driver.runTestCase(testType, numPeople, 10);
			driver.print(testType, numPeople, testTimesTracker);
		}
	}
}
