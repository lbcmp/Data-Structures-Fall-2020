import java.util.Random;

/**
 * You will use the provided Person.java class as the element that will be inserted into our HashTable.
 * 
 * For this assignment, the Key type will be Integer, so you will be creating instances of the Person class as follows:
 * 
 * Person<Integer> person = new Person(new Integer(x));
 * 
 * Where x is a unique int for each Person instance.
 */

/**
 * 
 * This class will be used as the element type that will be inserted into our HashTable.
 * 
 * @author Sameh Fakhouri
 *
 * @param <K>	This generic parameter specifies the Key type that will be used for
 *				the HashTable.
 */
public class Person<K> implements KeyedElementInterface<K> {
	
	private static final int NAME_LENGTH = 5;
	private static final Random randomNumberGenerator = new Random();
	
	private String firstName;
	private String lastName;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private K id;
	
	/**
	 * 
	 * This is the constructor for the class.
	 * 
	 * @param id	This parameter will be specified by the user. It is intended to be a 
	 * 				unique ID for each instance of the Person class. It is up to the user
	 * 				to assure the uniqueness of the ID.
	 */
	public Person(K id) {
		this.firstName	= createRandomName(NAME_LENGTH);
		this.lastName	= createRandomName(NAME_LENGTH);
		this.birthYear	= createRandomBirthYear();
		this.birthMonth = createRandomBirthMonth();
		this.birthDay   = createRandomBirthDay(this.birthMonth, this.birthYear);
		this.id			= id;
	}

	/**
	 * 
	 * This method is the implementation of the KeyedElement interface
	 * 
	 * @return	This method returns the unique key for this class instance.
	 * 
	 */
	@Override
	public K getKey() {
		return id;
	}
	
	@Override
	public String toString() {
		return "First Name: " + this.firstName + 
			   " | Last Name: " + this.lastName +
			   " | Birth Year: " + this.birthYear +
			   " | Birth Month: " + this.birthMonth +
			   " | Birth Day: " + this.birthDay +
			   " | ID Number: " + this.id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birthYear;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person<K> other = (Person<K>) obj;
			
			if (this.birthYear != other.birthYear) {
				return false;
			} else if ((this.firstName == null) && (other.firstName != null)) {
				return false;
			} else if (!this.firstName.equals(other.firstName)) {
				return false;
			} else if ((this.id == null) && (other.id != null)) {
				return false;
			} else if (!this.id.equals(other.id)) {
				return false;
			} else if ((this.lastName == null) && (other.lastName != null)) {
				return false;
			} else if (!this.lastName.equals(other.lastName)) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	private static String createRandomName(int length) {
		char[] chars = new char[length];

		for ( int i = 0 ; i < length ; i++ ) {
			int randomLetterIndex = randomNumberGenerator.nextInt(26);
			chars[i] = (char)(((int) 'a') + randomLetterIndex);
		}
		chars[0] = Character.toUpperCase(chars[0]);
		return new String(chars);
	}
	
	private static int createRandomBirthYear() {
		return 1930 + randomNumberGenerator.nextInt(70);
	}
	
	private static int createRandomBirthMonth() {
		return randomNumberGenerator.nextInt(12) + 1;
	}
	
	private static int createRandomBirthDay(int month, int year) {
		if ((month == 1) || (month == 3) || (month == 5) || 
			(month == 7) || (month == 8) || (month == 10) || (month == 12)) {
			return randomNumberGenerator.nextInt(31) + 1;
		} else if (month == 2) {
 			if (isLeapYear(year)) {
 	 			return randomNumberGenerator.nextInt(29) + 1;
 			} else {
 	 			return randomNumberGenerator.nextInt(28) + 1;
 			}
		} else {
			return randomNumberGenerator.nextInt(30) + 1;
		}
	}
	
	private static boolean isLeapYear(int year) {
		if ((year % 4) != 0) {
			return false;
		} else if ((year % 25) != 0) {
			return true;
		} else if ((year % 16) != 0) {
			return false;
		} else {
			return true;
		}
	}
}
