package com.list.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.doublylinkedist.*;

public class DoublyLinkedListStrategyTest {

	private DoublyLinkedList<Student> list;
	private Object[] ascendingFirstName, ascendingLastName, ascendingGpa;
	private Student alex, bob, clark, don, elisa, felix, gary;

	@Before
	public void intializeList() {
		alex = new Student("Alex", "Zander", 816, 3);
		bob = new Student("Bob", "Yale", 654, 2);
		clark = new Student("Clark", "Xavier", 444, 3.5);
		don = new Student("Don", "Warner", 545, 2.5);
		elisa = new Student("Elisa", "Veer", 345, 2.8);
		felix = new Student("Felix", "Ulrike", 898, 4);
		gary = new Student("Gary", "Tom", 567, 2.2);

		ascendingFirstName = new Student[] { alex, bob, clark, don, elisa,
				felix, gary };
		ascendingLastName = new Student[] { gary, felix, elisa, don, clark,
				bob, alex };
		ascendingGpa = new Student[] { bob, gary, don, elisa, alex, clark,
				felix };

	}

	@Test
	public void sortByFirstNameTest() {
		list = new DoublyLinkedList<Student>(new SortByStudentFirstName());
		list.add(don);
		list.add(gary);
		list.add(clark);
		list.add(alex);
		list.add(bob);
		list.add(elisa);
		list.add(felix);

		assertArrayEquals(ascendingFirstName, list.toArray());
	}

	@Test
	public void sortByLastNameTest() {
		list = new DoublyLinkedList<Student>(new SortByStudentLastName());
		list.add(don);
		list.add(gary);
		list.add(clark);
		list.add(alex);
		list.add(bob);
		list.add(elisa);
		list.add(felix);

		assertArrayEquals(ascendingLastName, list.toArray());
	}

	@Test
	public void sortByGpaTest() {
		list = new DoublyLinkedList<Student>(new SortByStudentGpa());
		list.add(don);
		list.add(gary);
		list.add(clark);
		list.add(alex);
		list.add(bob);
		list.add(elisa);
		list.add(felix);
		assertArrayEquals(ascendingGpa, list.toArray());
	}

	@Test
	public void dynamicStrategyChangeTest() {
		list = new DoublyLinkedList<Student>();
		list.add(don);
		list.add(gary);
		list.add(clark);
		list.add(alex);
		list.add(bob);
		list.add(elisa);
		list.add(felix);
		list.changeStrategy(new SortByStudentFirstName());
		Student aadarsh = new Student("Aadarsh", "jack", 567, 5.0);
		list.add(aadarsh);
		Object[] student = new Student[] { aadarsh, alex, bob, clark, don,
				elisa, felix, gary };
		assertArrayEquals(student, list.toArray());

		list.changeStrategy(new SortByStudentLastName());
		Student zander = new Student("zander", "alex", 567, 6.0);
		Object[] studentLastName = new Student[] { zander, aadarsh, gary,
				felix, elisa, don, clark, bob, alex };
		list.add(zander);
		assertArrayEquals(studentLastName, list.toArray());

		list.changeStrategy(new SortByStudentGpa());
		Student victor = new Student("victor", "alex", 567, 7.0);
		list.add(victor);
		Object[] ascendingGpaDynamic = new Student[] { bob, gary, don, elisa,
				alex, clark, felix, aadarsh, zander, victor };
		assertArrayEquals(ascendingGpaDynamic, list.toArray());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void stratergyAddIndexTest() {
		list = new DoublyLinkedList<Student>(new SortByStudentGpa());
		list.add(don);
		list.add(0, gary);
	}

}
