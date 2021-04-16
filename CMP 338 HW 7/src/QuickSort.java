/**
 * You will write the QuickSort.java class which will inherit from TestTimes.java and implement the Sort Interface using the Quick Sort algorithm.
 * 
 * Please note that your sort method must measure the run time and add it to the TestTimes class by using the addTestTime() method.
 * 
 * For your implementation of QuickSort, you must have three different ways of choosing the pivot as specified by the PivotType enum 
 * which will be defined in QuickSort.
 */

public class QuickSort<T extends Comparable <? super T>> extends TestTimes implements SortInterface<T> {
	
	public static final PivotType FirstElement = PivotType.FirstElement;
	public static final PivotType RandomElement = PivotType.RandomElement;
	public static final PivotType MidOfFirstMidLastElement = PivotType.MidOfFirstMidLastElement;
	private PivotType pivotType = FirstElement;
	
	/**
	 * This enum specifies the pivot type that QuickSort will use. The PivotType enum has the following values:
	 * 
	 * 		1. FirstElement: The pivot is always the first element of the array to be sorted.
	 * 		2. RandomElement: The pivot is chosen at random from any element in the array to be sorted
	 * 		3. MidOfFirstMidLastElement: The pivot is chosen to be the element whose value is in the middle among the
	 *    	   {first, middle and Last} elements in the array to be sorted
	 */
	public static enum PivotType {FirstElement, RandomElement, MidOfFirstMidLastElement};
	
	public static PivotType[] values() {
		/**
		 * Returns an array containing the constants of this enum type, in the order they are declared. 
		 * This method may be used to iterate over the constants as follows:
		 * 
		 * for (QuickSort.PivotType c : QuickSort.PivotType.values())
		 * System.out.println(c);
		 * 
		 * @return an array containing the constants of this enum type, in the order they are declared
		 */
		
		PivotType[] enums = {FirstElement, RandomElement, MidOfFirstMidLastElement};
		return enums;
	}
	
	public static PivotType valueOf(String name) {
		/**
		 * Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare
		 * an enum constant in this type. (Extraneous whitespace characters are not permitted.)
		 *  
		 *  @param name - the name of the enum constant to be returned.
		 *  @return the enum constant with the specified name
		 *  @throw java.lang.IllegalArgumentException - if this enum type has no constant with the specified name
		 *  	   java.lang.NullPointerException - if the argument is null
		 */
		
		if (name == null) {
			throw new NullPointerException("Error: String passed is null.");
		}
		
		if (name.equals(FirstElement.toString())) {
			return FirstElement;
		} else if (name.equals(RandomElement.toString())) {
			return RandomElement;
		} else if (name.equals(MidOfFirstMidLastElement.toString())) {
			return MidOfFirstMidLastElement;
		} else {
			throw new IllegalArgumentException("Error: This enum type has no constant with the specified name");
		}
	}
	
	public PivotType getPivotType() {
		/**
		 * A getter for the PivotType being used. The default is FirstElement See QuickSort.PivotType
		 * 
		 * @return The current PivotType being used.
		 */
		
		return pivotType;
	}
	
	public void setPivotType(PivotType pivotType) {
		/**
		 * The setter for the PivotType being used.
		 * 
		 * @param pivotType - The PivotType to use.
		 */
		
		this.pivotType = pivotType;
	}
	
	public void choosePivot(T[] arrayToSort, int first, int last) {
		/**
		 * This method selects the pivot according to the type of pivot specified.
		 * 
		 * The chosen pivot will end up as the first element in the specified array.
		 * 
		 * @param array - The array of Objects of type T to be sorted.
		 * 		  first - Index of the first entry of the array
		 * 		  last - Index of the last entry of the array
		 */
		
		T temp;
		
		switch(pivotType) {
		
		case FirstElement:
			break;
			
		case RandomElement:
			int range = (last - first) + 1;
			int randomIndex = (int) ((Math.random() * range) + 1);
			temp = arrayToSort[first];
			arrayToSort[first] = arrayToSort[randomIndex];
			arrayToSort[randomIndex] = temp;
			
			break;
			
		case MidOfFirstMidLastElement:
			int middle = (first + last) / 2;
			
			T min = arrayToSort[first];
			T max = arrayToSort[first];
			
			int minIndex = first;
			int maxIndex = first;
			
			if (arrayToSort[middle].compareTo(min) < 0) {
				min = arrayToSort[middle];
				minIndex = middle;
			}
		    
			if (arrayToSort[last].compareTo(min) < 0) {
				min = arrayToSort[last];
				minIndex = last;
			}
		    
		    if (arrayToSort[middle].compareTo(max) > 0) {
				max = arrayToSort[middle];
				maxIndex = middle;
			}
		    
			if (arrayToSort[last].compareTo(max) > 0) {
				max = arrayToSort[last];
				maxIndex = last;
			}
			
			if (first != minIndex && first != maxIndex) {
				temp = arrayToSort[first];
				arrayToSort[first] = arrayToSort[first];
				arrayToSort[first] = temp;
			} else if (middle != minIndex && middle != maxIndex) {
				temp = arrayToSort[first];
				arrayToSort[first] = arrayToSort[middle];
				arrayToSort[middle] = temp;
			} else {
				temp = arrayToSort[first];
				arrayToSort[first] = arrayToSort[last];
				arrayToSort[last] = temp;
			}
			
			break;
		}
	}

	public void sort(T[] arrayToSort) {
		/**
		 * This is the method that users will call to sort the specified array of Objects of type T using QuickSort. 
		 * The method of choosing the pivot is specified by properly setting the pivotType instance variable.
		 * 
		 * This method will call the quickSort method to perform the recursive sort.
		 * 
		 * The Comparable interface must either be implemented by T or a superclass of T.
		 * 
		 * When this method is done, the specified array is sorted.
		 * 
		 * @param arrayToSort - The array of Objects of type T to be sorted.
		 */
		
		if (arrayToSort.length > 1) {
			int first = 0;
			int last = arrayToSort.length - 1;
			
			//if the array is big enough to be sorted, begin the sort
			setTimeUnits(TimeUnits.MicroSeconds);
			setMemoryUnits(MemoryUnits.KiloBytes);
			
			long startTime = System.nanoTime();
			
			quickSort(arrayToSort, first, last);
			
			long endTime = System.nanoTime(); 
			long testTime = endTime - startTime;
			addTestTime(testTime);
		}
	}
	
	private void quickSort(T[] arrayToSort, int first, int last) {
		/**
		 * This is the recursive method that implements the QuickSort algorithm.
		 * 
		 * @param array - The array of Objects of type T to be sorted.
		 * 		  first - Index of the first entry of the array
		 * 		  last - Index of the last entry of the array
		 */
		
		//base case: if first >= last, partition is already sorted
		if (first < last) {
			
			//partitions the array into first and last partitions
			int partitionIndex = partition(arrayToSort, first, last);
			
			//recursively sort first and last partitions
			quickSort(arrayToSort, first, partitionIndex - 1);
			quickSort(arrayToSort, partitionIndex + 1, last);
		}
	}

	private int partition(T[] arrayToSort, int first, int last) {
		/**
		 * This method first finds the pivot p by calling choosePivot and then partitions and rearranges the elements of the
		 * array in the following manner:
		 * 
		 *  { [ elements < p ] p [ elements ≥ p] }.
		 * 
		 * @param array - The array of Objects of type T to be sorted
		 * 		  first - Index of the first entry of the array
		 * 		  last - Index of the last entry of the array
		 * 
		 * @return The index of the location of the pivot p after the partition.
		 */
		
		choosePivot(arrayToSort, first, last);
		T pivot = arrayToSort[first];
		int lastIndexOfP1 = first; //last index of first partition
		
		//put all values less than the pivot in the first partition
		for (int unknown = first + 1; unknown <= last; ++unknown) {
			if (arrayToSort[unknown].compareTo(pivot) < 0) {
				++lastIndexOfP1;
				T temp = arrayToSort[unknown];
				arrayToSort[unknown] = arrayToSort[lastIndexOfP1];
				arrayToSort[lastIndexOfP1] = temp;
			}
		}
		
		//put the pivot in the middle
		T temp = arrayToSort[first];
		arrayToSort[first] = arrayToSort[lastIndexOfP1];
		arrayToSort[lastIndexOfP1] = temp;
		
		return lastIndexOfP1;
	}
	
	/*public static void main(String[] args) {
		QuickSort<Integer> quickSortObject = new QuickSort<Integer>();
		Integer[] array = {14, 3, 8, 10, 21, 122, 1, 94, 329, 29, 20, 2, 30};
		
		quickSortObject.sort(array);
		
		for(int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}*/
}
