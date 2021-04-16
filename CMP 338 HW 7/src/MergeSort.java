import java.util.Arrays;

/**
 * You will write the MergeSort.java class which will inherit from TestTimes.java and implement the Sort Interface using the Merge Sort algorithm.
 * 
 * Please note that your sort method must measure the run time and add it to the TestTimes class by using the addTestTime() method.
 */

public class MergeSort<T extends Comparable <? super T>> extends TestTimes implements SortInterface<T> {

	public void sort(T[] arrayToSort) {
		/**
		 * This is the method that users will call to sort the specified array of Objects of type T.
		 * 
		 * This method creates a tempArray and initializes it to contain arrayToSort.size() null elements.
		 * 
		 * This method will call the mergesort method to perform the recursive sort.
		 * 
		 * The Comparable interface must either be implemented by T or a superclass of T.
		 * 
		 * When this method is done, the specified array is sorted.
		 * 
		 * This method will measure the runtime of the sort and add it to the TestTimes class.
		 * 
		 * @param arrayToSort - The array of Objects of type T to be sorted.
		 */
		
		if (arrayToSort.length > 1) {
			int first = 0;
			int last = arrayToSort.length - 1;
			
			Object[] tempArray = new Object[arrayToSort.length];
			Arrays.fill(tempArray, null);
			
			//if the array is big enough to be sorted, begin the sort
			setTimeUnits(TimeUnits.MicroSeconds);
			setMemoryUnits(MemoryUnits.KiloBytes);
			
			long startTime = System.nanoTime();
			
			mergeSort(arrayToSort, tempArray, first, last);
			
			long endTime = System.nanoTime(); 
			long testTime = endTime - startTime;
			addTestTime(testTime);
		}
		
	}
	
	private void mergeSort(T[] arrayToSort, Object[] tempArray, int first, int last) {
		/**
		 * This is the recursive method that does the merge sort of array, which has Objects of type T.
		 * 
		 * @param array - The array of Objects of type T to be sorted
		 * 		  tempArray - The temporary array of Objects used in the merge
		 * 		  first - Index of the first entry of the array
		 * 		  last - Index of the last entry of the array
		 */
		
		if (first < last) {
			int mid = (first + last) / 2;
			
			//sort first partition
			mergeSort(arrayToSort, tempArray, first, mid);
			
			//sort last partition
			mergeSort(arrayToSort, tempArray, mid + 1, last);
			
			//merge the sorted partitions
			merge(arrayToSort, tempArray, first, mid, last);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void merge(T[] arrayToSort, Object[] tempArray, int first, int mid, int last) {
		/**
		 * This method is called to merge two portions of array that are already in sorted order. 
		 * The indices of these portions are specified by first, mid and last. All the elements of array are Objects of type T.
		 * 
		 * The merge operation first merges all the elements in proper sorted order from the two portions of array into tempArray. 
		 * When the merge is complete, all the elements are then copied back into array.
		 * 
		 * @param array - The array of Objects of type T to be sorted
		 * 		  tempArray - The temporary array of Objects used in the merge
		 * 		  first - The index of the beginning of the first section of array to be merged.
		 * 		  mid - The index of the end of the first section of array to be merged.
		 * 		  last - The index of the end of the second section of array to be merged. Please note that the index of the beginning of the second section of array to be merged is at index = mid + 1
		 */
		
		int first1 = first;
		int last1 = mid;
		int first2 = mid + 1;
		int last2 = last;
		int index = first1;
		
		//merge first and last partitions into tempArray (until there are no more elements to merge in either partition)
		while ((first1 <= last1) && (first2 <= last2)) {
			if (arrayToSort[first1].compareTo(arrayToSort[first2]) < 0) {
				tempArray[index] = arrayToSort[first1];
				++first1;
			} else {
				tempArray[index] = arrayToSort[first2];
				++first2;
			}
			
			++index;
		}
		
		//if there are elements left to merge in the first partition, add them to the tempArray
		while (first1 <= last1) {
			tempArray[index] = arrayToSort[first1];
			++first1;
			++index;
		}
		
		//if there are elements left to merge in the last partition, add them to the tempArray
		while (first2 <= last2) {
			tempArray[index] = arrayToSort[first2];
			++first2;
			++index;
		}
		
		//copy tempArray to arrayToSort
		for (int i = first; i <= last; ++i) {
			arrayToSort[i] = (T) tempArray[i];
		}
	}
	
	/*public static void main(String[] args) {
		MergeSort<Integer> mergeSortObject = new MergeSort<Integer>();
		Integer[] array = {14, 3, 8, 10, 21, 122, 1, 94, 329, 29, 20, 2, 30};
		
		mergeSortObject.sort(array);
		
		for(int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}*/
}
