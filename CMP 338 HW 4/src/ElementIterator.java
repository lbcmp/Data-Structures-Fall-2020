/**
 * You will write the ElementIterator.java class which will implement the Iterator Interface. 
 * Please note, you only need to implement two methods from the Iterator interface: boolean hasNext() and E next()
 */

import java.util.Iterator;
import java.util.Vector;

public class ElementIterator<E> implements Iterator<E> {
	
	private Vector<E> elements;
	
	public ElementIterator(Vector<E> elements) {
		this.elements = elements;
	}

	@Override
	public boolean hasNext() {
		if (this.elements.size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public E next() {
		E element = this.elements.get(0);
		this.elements.remove(0);
		return element;
	}

}
