package com.example.doublylinkedist;

import java.util.Arrays;
import java.util.Iterator;

public class OnProbationDecorator extends AbstractDecorator {

	public OnProbationDecorator(DoublyLinkedList<Student> list) {
		super(list);
	}

	/*
	 * Returns the OnProbationFilter iterator of the list
	 */
	@Override
	public Iterator<Student> iterator() {
		// TODO Auto-generated method stub
		Iterator<Student> iterator = new OnProbationFilter<Student>(
				list.iterator());
		return iterator;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Iterator<Student> iterator = iterator();
		String str = "[";
		while (iterator.hasNext()) {
			String item = iterator.next().toString();
			if (iterator.hasNext())
				str = str + item.toString() + ", ";
			else
				str = str + item.toString();

		}
		str = str + "]";
		return str;
	}

	/*
	 * Returns the array of Student elements who are in probation from the list.
	 */

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] students = new Object[getSize()];
		Iterator<Student> iterator = iterator();
		int counter = 0;
		while (iterator.hasNext()) {
			students[counter] = iterator.next();
			counter++;
		}
		return students;
	}

	/*
	 * Saves the student elements who are in probation into the array passed to
	 * the method and returns it. If the argument array length is less than the
	 * size it creates a new array.
	 */

	@Override
	public Student[] toArray(Student[] array) {
		// TODO Auto-generated method stub
		int counter = 0;
		Iterator<Student> itr = iterator();
		while (itr.hasNext()) {
			if (array.length == counter)
				array = Arrays.copyOf(array, getSize());
			array[counter] = itr.next();
			counter++;
		}
		return array;
	}

	private int getSize() {
		Iterator<Student> iterator = iterator();
		int counter = 0;
		while (iterator.hasNext()) {
			iterator.next();
			counter++;
		}
		return counter;
	}

}
