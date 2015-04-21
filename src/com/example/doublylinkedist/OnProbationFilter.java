package com.example.doublylinkedist;

import java.util.Iterator;

public class OnProbationFilter<E> implements Iterator<Student> {

	private Iterator<E> iterator = null;
	private Student student = null;

	public OnProbationFilter(Iterator<E> iterator) {
		this.iterator = iterator;
	}

	/*
	 * Returns true if the list has any next student object whose gpa is less
	 * than 2.85
	 */

	@Override
	public boolean hasNext() {

		checkForModification();
		if (student == null) {
			student = next();
			if (student == null)
				return false;
			else
				return true;
		} else {
			return true;
		}

	}

	/*
	 * Returns the current probation student data and sets current student to
	 * the next student in probation.
	 */

	@Override
	public Student next() {

		checkForModification();
		// student = getStudentsOnProbation();
		if (student != null) {
			Student s = student;
			student = getStudentsOnProbation();
			return s;

		} else {
			student = getStudentsOnProbation();
			return student;
		}
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();

	}

	private Student getStudentsOnProbation() {
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			if (student.isOnProbation()) {
				return student;
			}
		}
		return null;
	}

	/*
	 * This method checks for any list modification.If there is any modification
	 * it throws ConcurrentModificationException.
	 */

	@SuppressWarnings("unchecked")
	private void checkForModification() {
		IteratorNormal<Student> it = (IteratorNormal<Student>) iterator;
		it.checkForModification();
	}

}
