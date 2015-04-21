package com.example.doublylinkedist;

import java.util.Comparator;

public class SortByStudentGpa implements Strategy<Student> {

	/*
	 * Adds the student in sorted manner with respect to their gpa.
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
	 * 
	 * Sorts the list with respect to their gpa.
	 */

	@Override
	public void changeStrategy(DoublyLinkedList<Student> list) {
		// TODO Auto-generated method stub
		list.sort(new Comparator<Student>() {

			@Override
			public int compare(Student student0, Student student1) {
				// TODO Auto-generated method stub
				if (student0.getGpa() < student1.getGpa())
					return -1;
				if (student0.getGpa() > student1.getGpa())
					return 1;
				return 0;
			}

		});

	}

	@Override
	public int compare(Student data) {
		// TODO Auto-generated method stub
		if (data.getGpa() < currentStudent.getGpa())
			return -1;
		if (data.getGpa() > currentStudent.getGpa())
			return 1;
		return 0;
	}

}
