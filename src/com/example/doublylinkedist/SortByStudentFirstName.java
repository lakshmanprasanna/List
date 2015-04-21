package com.example.doublylinkedist;

import java.util.Comparator;

public class SortByStudentFirstName implements Strategy<Student> {

	/*
	 * Adds the student lexicographically with respect to their first name
	 */

	private Student currentStudent;
	private StrategyAdd strategyAdd = new StrategyAdd(this);

	@Override
	public void add(DoublyLinkedList<Student> list, Student data) {
		// TODO Auto-generated method stub
		currentStudent = data;
		strategyAdd.add(list, data);
	}

	/*
	 * Sorts the list lexicographically with respect to their first name.
	 */

	@Override
	public void changeStrategy(DoublyLinkedList<Student> list) {
		// TODO Auto-generated method stub
		list.sort(new Comparator<Student>() {

			@Override
			public int compare(Student student0, Student student1) {
				// TODO Auto-generated method stub
				return student0.getFirstName().compareToIgnoreCase(
						student1.getFirstName());
			}

		});

	}

	@Override
	public int compare(Student data) {

		return data.getFirstName().compareToIgnoreCase(
				currentStudent.getFirstName());
	}

}
