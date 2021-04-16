
public interface DriverInterface {
	
	/**
	 * 
	 * The QueueType enum has the following values:
	 * 
	 * ArrayBasedQueue
	 * LinkedQueue
	 * 
	 *
	 */
	public static enum QueueType {ArrayBasedQueue, LinkedQueue};

	
	
	/**
	 * 
	 * The QueueTestType enum has the following values:
	 * 
	 * Enqueue
	 * Dequeue
	 * Iterate
	 * 
	 *
	 */
	public static enum QueueTestType {Enqueue, Dequeue, Iterate};
	
	
	
	/**
	 * 
	 * The StackType enum has the following values:
	 * 
	 * ArrayBasedStack
	 * LinkedStack
	 * 
	 *
	 */
	public static enum StackType {ArrayBasedStack, LinkedStack};

	
	
	/**
	 * 
	 * The StackTestType enum has the following values:
	 * 
	 * Push
	 * Pop
	 * Iterate
	 * 
	 *
	 */
	public static enum StackTestType {Push, Pop, Iterate};

	
	
	/**
	 * 
	 * This method is used to create a new queue of the specified queueType. Depending on the 
	 * specified queueTestType, this method may need to initialize the queue with some entries.
	 * 
	 * @param queueType		This parameter specifies the type of queue to create. See the enum {@link QueueType}.
	 * 
	 * @param queueTestType	This parameter specifies the type of test that the queue is being created for. See the enum
	 * {@link QueueTestType}.
	 * 
	 * @return				The method will return the created queue as a QueueInterface&lt;String&gt;.
	 * 
	 */
	public QueueInterface<String> createQueue(QueueType queueType, QueueTestType queueTestType);

	
	
	/**
	 * 
	 * This method is used to create a new stack of the specified stackType. Depending on the 
	 * specified stackTestType, this method may need to initialize the queue with some entries.
	 * 
	 * @param stackType		This parameter specifies the type of stack to create. See the enum {@link StackType}.
	 * 
	 * @param stackTestType	This parameter specifies the type of test that the stack is being created for. See the enum
	 * {@link StackTestType}.
	 * 
	 * @return				The method will return the created stack as a StackInterface&lt;String&gt;.
	 * 
	 */
	public StackInterface<String> createStack(StackType stackType, StackTestType stackTestType);

	
	
	/**
	 * 
	 * This method is called to run a particular test case on a queue type the specified number of times. The run time
	 * and memory usage for each run is saved in the RunTime class.
	 * 
	 * @param 	queueType		The type of queue needed for the test case. See the enum {@link QueueType}.
	 * @param 	queueTestType	The type of test case being run. See the enum {@link QueueTestType}.
	 * @param 	numberOfTimes 	This parameter specifies the number of times to run the specified test.
	 * 
	 * @return	An instance of the TestTimes class containing the test times and memory usages.
	 * 
	 */
	public TestTimes runQueueTestCase(QueueType queueType, QueueTestType queueTestType, int numberOfTimes); 

	
	
	/**
	 * 
	 * This method is called to run a particular test case on a stack type the specified number of times. The run time
	 * and memory usage for each run is saved in the RunTime class.
	 * 
	 * @param 	stackType		The type of stack needed for the test case. See the enum {@link StackType}.
	 * @param 	stackTestType	The type of test case being run. See the enum {@link StackTestType}.
	 * @param 	numberOfTimes 	This parameter specifies the number of times to run the specified test.
	 * 
	 * @return	An instance of the TestTimes class containing the test times and memory usages.
	 * 
	 */
	public TestTimes runStackTestCase(StackType stackType, StackTestType stackTestType, int numberOfTimes); 
	
	
	
}
