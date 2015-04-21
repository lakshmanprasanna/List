package com.example.doublylinkedist;

import java.util.Comparator;

public class SortByStudentLastName implements Strategy<Student> {

	/*
	 * Adds the student lexicographically with respect to their last name.
	 */

	private StrategyAdd strategyAdd = new StrategyAdd(this);
	private Student currentStudent;

	@Override
	public void add(DoublyLinkedList<Student> list, Student data) {
		// TODO Auto-generated method stub
		currentStudent = data;
		strategyAdd.add(list, data);
	}

	/*
	 * Sorts the list lexicographically with respect to their last name.
	 */

	@Override
	public void changeStrategy(DoublyLinkedList<Student> list) {
		// TODO Auto-generated method stub
		list.sort(new Comparator<Student>() {

			@Override
			public int compare(Student student0, Student student1) {
				// TODO Auto-generated method stub
				return student0.getLastName().compareToIgnoreCase(
						student1.getLastName());
			}

		});

	}

	@Override
	public int compare(Student data) {
		// TODO Auto-generated method stub
		return data.getLastName().compareToIgnoreCase(
				currentStudent.getLastName());
	}

}
