package com.list.testing;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.example.doublylinkedist.DoublyLinkedList;
import com.example.doublylinkedist.OnProbationDecorator;
import com.example.doublylinkedist.Student;

public class OnProbationDecoratorTest {

	private DoublyLinkedList<Student> list;
	private Student alex, bob, clark, don, elisa, felix, gary;
	private Object[] studentsInProbation;

	@Before
	public void intializeList() {
		list = new DoublyLinkedList<Student>();
		alex = new Student("Alex", "Zander", 816, 3);
		bob = new Student("Bob", "Yale", 654, 2);
		clark = new Student("Clark", "Xavier", 444, 3.5);
		don = new Student("Don", "Warner", 545, 2.5);
		elisa = new Student("Elisa", "Veer", 345, 2.8);
		felix = new Student("Felix", "Ulrike", 898, 4);
		gary = new Student("Gary", "Tom", 567, 2.2);

		studentsInProbation = new Student[] { bob, don, elisa, gary };

	}

	@Test
	public void onProbationDecoratorTest() {
		list.add(alex);
		list.add(bob);
		list.add(clark);
		list.add(don);
		list.add(elisa);
		list.add(felix);
		list.add(gary);

		DoublyLinkedList<Student> decoratorList = new OnProbationDecorator(list);

		Object[] probationArray = decoratorList.toArray();

		Iterator<Student> iterator = decoratorList.iterator();

		Object[] iteratorProbationArray = new Student[4];
		int counter = 0;

		while (iterator.hasNext()) {
			iteratorProbationArray[counter] = iterator.next();
			counter++;
		}

		assertArrayEquals(probationArray, studentsInProbation);
		assertArrayEquals(studentsInProbation, iteratorProbationArray);
		assertArrayEquals(probationArray, iteratorProbationArray);

	}
}
