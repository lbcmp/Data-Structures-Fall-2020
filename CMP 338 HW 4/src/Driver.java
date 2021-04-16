import java.util.Iterator;

/**
 * You will write the Driver.java class which will implement the Driver Interface.
 * Please note that you do not inherit from the TestTimes class. However, you do have to use the TestTimes class to 
 * measure test times and memory usages.
 */

public class Driver implements DriverInterface {
	
	public QueueInterface<String> createQueue(QueueType queueType, QueueTestType queueTestType) {
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
		
		QueueInterface<String> queue = null;
		
		switch(queueType) {
		
		case ArrayBasedQueue:
			queue = new ArrayBasedQueue<String>();
			break;
	
		case LinkedQueue:
			queue = new LinkedQueue<String>();
			break;
		}
		
		switch(queueTestType) {
		
		case Enqueue:
			break;
			
		case Dequeue:
			for (int i = 1; i <= 10000; ++i) {
				Integer tempInteger = Integer.valueOf(i);
				String tempString = tempInteger.toString();
				queue.enqueue(tempString);
			}
			break;
			
		case Iterate:
			for (int i = 1; i <= 10000; ++i) {
				Integer tempInteger = Integer.valueOf(i);
				String tempString = tempInteger.toString();
				queue.enqueue(tempString);
			}
			break;
		}
		
		return queue;
	}

	public StackInterface<String> createStack(StackType stackType, StackTestType stackTestType) {
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
		
		StackInterface<String> stack = null;
		
		switch(stackType) {
		
		case ArrayBasedStack:
			stack = new ArrayBasedStack<String>();			
			break;
			
		case LinkedStack:
			stack = new LinkedStack<String>();			
			break;
		}
		
		switch(stackTestType) {
			
		case Push:
			break;
			
		case Pop:
			for (int i = 1; i <= 10000; ++i) {
				Integer tempInteger = Integer.valueOf(i);
				String tempString = tempInteger.toString();
				stack.push(tempString);
			}
			break;
			
		case Iterate:
			for (int i = 1; i <= 10000; ++i) {
				Integer tempInteger = Integer.valueOf(i);
				String tempString = tempInteger.toString();
				stack.push(tempString);
			}
			break;
		}
	
		return stack;
	}

	public TestTimes runQueueTestCase(QueueType queueType, QueueTestType queueTestType, int numberOfTimes) {
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
		
		TestTimes testTimeTracker = new TestTimes("MicroSeconds", "KiloBytes");
		long startTime;
		long endTime;
		long testTime;
        
		while (numberOfTimes > 0)  {
			startTime = System.nanoTime();
			
			QueueInterface<String> queue = createQueue(queueType, queueTestType);
			
			switch(queueTestType) {
			case Enqueue:
				for (int i = 1; i <= 10000; ++i) {
					Integer tempInteger = Integer.valueOf(i);
					String tempString = tempInteger.toString();
					queue.enqueue(tempString);
				}
				break;
				
			case Dequeue:
				for (int i = 0; i < queue.size(); ++i) {
					queue.dequeue();
				}
				break;
				
			case Iterate:
				Iterator<String> iterator = queue.iterator();
				
				while (iterator.hasNext()) {
					iterator.next();
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

	public TestTimes runStackTestCase(StackType stackType, StackTestType stackTestType, int numberOfTimes) {
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
		
		TestTimes testTimeTracker = new TestTimes("MicroSeconds", "KiloBytes");
		long startTime;
		long endTime;
		long testTime;
        
		while (numberOfTimes > 0)  {
			startTime = System.nanoTime();
			
			StackInterface<String> stack = createStack(stackType, stackTestType);
			
			switch(stackTestType) {
			case Push:
				for (int i = 1; i <= 10000; ++i) {
					Integer tempInteger = Integer.valueOf(i);
					String tempString = tempInteger.toString();
					stack.push(tempString);
				}
				break;
				
			case Pop:
				for (int i = 0; i < stack.size(); ++i) {
					stack.pop();
				}
				break;
				
			case Iterate:
				Iterator<String> iterator = stack.iterator();
				
				while (iterator.hasNext()) {
					iterator.next();
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
	
	public void printQueue(QueueType queueType, QueueTestType queueTestType, TestTimes testTimesTracker) {
		double[] testTimes = testTimesTracker.getTestTimes();
		double[] memoryUsage = testTimesTracker.getMemoryUsages();
		
		//TestTimes
		
		System.out.print("Running test = " + queueTestType.toString() + "\n\t");
		
		for (int i = 1; i <= testTimes.length; ++i) {
			System.out.print("  Run " + i + "   ");
		}
		
		System.out.print("   Average\n\t");
		
		for (int i = 0; i < testTimes.length; ++i) {
			System.out.print(testTimes[i] + "  ");
		}
		
		System.out.print(testTimesTracker.getAverageTestTime() + "\n\t");
		
		for (int i = 0; i < testTimes.length; ++i) {
			System.out.print(testTimesTracker.getTimeUnits() + "  ");
		}
		
		System.out.println("\n" + queueType.toString() + "\n\n");
		
		//MemoryUsage
		
		System.out.print("Running test = " + queueTestType.toString() + "\n\t");
		
		for (int i = 1; i <= memoryUsage.length; ++i) {
			System.out.print("  Run " + i + "   ");
		}
		
		System.out.print("   Average\n\t");
		
		for (int i = 0; i < memoryUsage.length; ++i) {
			System.out.print(memoryUsage[i] + "  ");
		}
		
		System.out.print(testTimesTracker.getAverageMemoryUsage() + "\n\t");
		
		for (int i = 0; i < memoryUsage.length; ++i) {
			System.out.print(testTimesTracker.getMemoryUnits() + "  ");
		}
		
		System.out.println("\n" + queueType.toString() + "\n");
		
		System.out.println("---------------------------------------------------------------------------------------------\n");
	}
	
	public void printStack(StackType stackType, StackTestType stackTestType, TestTimes testTimesTracker) {
		double[] testTimes = testTimesTracker.getTestTimes();
		double[] memoryUsage = testTimesTracker.getMemoryUsages();
		
		//TestTimes
		
		System.out.print("Running test = " + stackTestType.toString() + "\n\t");
		
		for (int i = 1; i <= testTimes.length; ++i) {
			System.out.print("  Run " + i + "   ");
		}
		
		System.out.print("   Average\n\t");
		
		for (int i = 0; i < testTimes.length; ++i) {
			System.out.print(testTimes[i] + "  ");
		}
		
		System.out.print(testTimesTracker.getAverageTestTime() + "\n\t");
		
		for (int i = 0; i < testTimes.length; ++i) {
			System.out.print(testTimesTracker.getTimeUnits() + "  ");
		}
		
		System.out.println("\n" + stackType.toString() + "\n\n");
		
		//MemoryUsage
		
		System.out.print("Running test = " + stackTestType.toString() + "\n\t");
		
		for (int i = 1; i <= memoryUsage.length; ++i) {
			System.out.print("  Run " + i + "   ");
		}
		
		System.out.print("   Average\n\t");
		
		for (int i = 0; i < memoryUsage.length; ++i) {
			System.out.print(memoryUsage[i] + "  ");
		}
		
		System.out.print(testTimesTracker.getAverageMemoryUsage() + "\n\t");
		
		for (int i = 0; i < memoryUsage.length; ++i) {
			System.out.print(testTimesTracker.getMemoryUnits() + "  ");
		}
		
		System.out.println("\n" + stackType.toString() + "\n");
		
		System.out.println("---------------------------------------------------------------------------------------------\n");
	}
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		System.out.println("Running Queue Test Cases:\n");
		for (QueueType queueType : QueueType.values()) {
			for (QueueTestType queueTestType : QueueTestType.values()) {
				TestTimes testTimesTracker = driver.runQueueTestCase(queueType, queueTestType, 10);
				driver.printQueue(queueType, queueTestType, testTimesTracker);
			}
		}
		
		System.out.println("Running Stack Test Cases:\n");
		for (StackType stackType : StackType.values()) {
			for (StackTestType stackTestType : StackTestType.values()) {
				TestTimes testTimesTracker = driver.runStackTestCase(stackType, stackTestType, 10);
				driver.printStack(stackType, stackTestType, testTimesTracker);
			}
		}
	}
}


