/**
 * You will write the HeapSort.java class which will inherit from TestTimes.java and implement the Sort Interface using the Heap Sort algorithm. 
 * 
 * Please note that your sort method must measure the run time and add it to the TestTimes class by using the addTestTime() method.
 */

public class HeapSort<T extends Comparable <? super T>> extends TestTimes implements SortInterface<T> {
	
	T[] heap;
	int heapSize;
	int lastIndex;

	public void sort(T[] arrayToSort) {
		/**
		 * This is the method that users will call to sort the specified array of Objects of type T using HeapSort.
		 * 
		 * This method will call the heapSort method to perform the sort.
		 * 
		 * The Comparable interface must either be implemented by T or a superclass of T.
		 * 
		 * When this method is done, the specified array is sorted.
		 * 
		 * @param arrayToSort - The array of Objects of type T to be sorted.
		 */
		
		this.heap = arrayToSort;
		this.heapSize = heap.length;
		this.lastIndex = heapSize - 1;
		
		setTimeUnits(TimeUnits.MicroSeconds);
		setMemoryUnits(MemoryUnits.KiloBytes);
		
		long startTime = System.nanoTime();
		
		heapSort();
		
		long endTime = System.nanoTime(); 
		long testTime = endTime - startTime;
		addTestTime(testTime);
	}
	
	private void heapSort() {
		/**
		 * This is the method that performs the HeapSort.
		 */
		
		heapify();
		
		while (lastIndex >= 0) {
			T temp = heap[0];
			heap[0] = heap[lastIndex];
			heap[lastIndex] = temp;
			--lastIndex;
			
			heapify();
		}
	}
	
	private void heapify() {
		/**
		 * This method is used to transform the array being sorted into a heap.
		 */
		
		int parent = (lastIndex - 1) / 2;
		
		while (parent >= 0) {
			siftDown(parent);
			--parent;
		}
		
	}
	
	private void siftDown(int node) {
		/**
		 * This method will compare the node specified by its index in the heap to both the left and right child. 
		 * If it is smaller it will be swapped with the smaller child. If is swap occurs, the method will continue to 
		 * sift the node down the heap until it reaches a place that guarantees the array to be a heap.
		 * 
		 * @param node - The index of the node being compared to its children.
		 */
		
		while (node < lastIndex) {
			int leftChild = (2 * node) + 1;
			int rightChild = leftChild + 1;
			int swap = node;
			
			if ((leftChild <= lastIndex) && (heap[node].compareTo(heap[leftChild]) <= 0)) {
				swap = leftChild;
			}
			
			if ((rightChild <= lastIndex) && (heap[swap].compareTo(heap[rightChild]) <= 0)) {
				swap = rightChild;
			}
			
			if (swap == node) {
				return;
			} else {
				T temp = heap[node];
				heap[node] = heap[swap];
				heap[swap] = temp;
				node = swap;
			}
		}
	}
	
	/*public static void main(String[] args) {
		HeapSort<Integer> object = new HeapSort<Integer>();
		System.out.println(object.heapSize);
		
		Integer[] array = {17, 9, 5, 7, 2, 28, 0, 129, 231, 34, 8, 23, 10, 32, 42, 52, 62, 22, 230124235};
		
		object.sort(array);	
		
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}*/
}
