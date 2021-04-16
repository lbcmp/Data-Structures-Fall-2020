public interface DriverInterface {
	
	/**
	 * 
	 * This enum is used to specify which test scenario will be executed.
	 * 
	 * The TestType enum has the following choices:
	 * 							
	 * 								Insert
	 * 								Get
 	 * 								Remove
	 * 							
	 *
	 */
	public static enum TestType {Insert, Get, Remove};
	
	/**
	 *
	 * This method is used to create array with the 
	 * specified number of Person&lt;Integer&gt; instances.
	 * 
	 * @param numPeople	The number of Person&lt;Integer&gt; instances to create.
	 * 
	 * @return	This method returns a Vector&lt;Person&lt;Integer&gt;&gt; with the 
	 * 			specified number of Person&lt;Integer&gt; instances.
	 */
	public Person<Integer>[] createPersons(int numPeople);
	
	/**
	 * 
	 * This method create the buckets that are needed for the
	 * HashTable&lt;Person&lt;Integer&gt;, Integer&gt;.
	 * 
	 * @param numBuckets	The number of buckets needed for the HashTable&lt;Person&lt;Integer&gt;, Integer&gt;.
	 * 	
	 * @return	An array of LinkedList&lt;Person&lt;Integer&gt;, Integer$gt; containing the specified number
	 * 			of LinkedList&lt;Person&lt;Integer&gt;, Integer$gt; instances.
	 */
	public LinkedList<Person<Integer>, Integer>[] createBuckets(int numBuckets);
	
	/**
	 * 
	 * This method is used to create a HashTable&lt;Person&lt;Integer&gt;, Integer&gt;
	 * for the specified testType</b>.
	 * 
	 * @param testType	The type of test for the created HashTable.
	 * 					
	 * 						
	 * 							Insert
	 * 						
	 * 						
	 * 							The returned HashTable must be empty
	 * 						
	 * 						
	 * 							Get
	 * 						
	 * 						
	 * 							The returned HashTable must contain the specified number of 
	 * 							Person&lt;Integer&gt; instances.
	 * 						
	 * 						
	 * 							Remove
	 * 						
	 * 						
	 * 							The returned HashTable must contain the specified number of 
	 * 							Person&lt;Integer&gt; instances.
	 * 						
	 * 					
	 * @param numPeople	The number of Person&lt;Integer&gt; instances to include in
	 * 					the returned HashTable.
	 * 
	 * @return			This method will return an instance of HashTable&lt;Person&lt;Integer&gt;, Integer&gt;
	 * 					containing the specified number of Person&lt;Integer&gt; instances
	 */
	public HashTable<Person<Integer>, Integer> createHashTable(TestType testType, int numPeople);
	
	/**
	 * This method is called to run a particular test case on the HashTable&lt;Person&lt;Integer&gt;, Integer&gt;
	 * the specified number of times. The run time 	 * and memory usage for each run is saved in the TestTimes class.
	 * 
	 * @param testType		The test type to be run.
	 * @param numPeople		The number of Person&lt;Integer&gt; instances to include 
	 * 						in the test.
	 * @param numberOfTimes The type of test case being run. See the enum {@link TestType}.
	 * @return	An instance of the TestTimes class containing the test times and memory usages.
	 */
	public TestTimes runTestCase(TestType testType, int numPeople, int numberOfTimes);
}