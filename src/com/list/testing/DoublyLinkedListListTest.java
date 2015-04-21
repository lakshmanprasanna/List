package com.list.testing;

import static org.junit.Assert.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

import com.example.doublylinkedist.*;

public class DoublyLinkedListListTest {

	private DoublyLinkedList<Student> list;
	private Student alex, bob, clark, don, elisa, felix, gary;

	// List<String> list = new StudentInformationList<String>(new
	// SortedList<>(new NameComparator()));

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

	}

	@Test
	public void testAdd() {

		assertTrue(list.isEmpty());
		list.add(alex);
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
		assertEquals(alex, list.get(0));

		list.add(gary);
		assertEquals(2, list.size());
		assertEquals(gary, list.get(1));

		list.add(0, clark);
		assertEquals(3, list.size());
		assertEquals(clark, list.get(0));

		list.add(3, don);
		assertEquals(4, list.size());
		assertEquals(don, list.get(3));

		list.add(elisa);
		assertEquals(5, list.size());
		assertEquals(elisa, list.get(4));

		list.add(0, felix);
		assertEquals(6, list.size());
		assertEquals(felix, list.get(0));

		list.add(bob);
		assertEquals(7, list.size());
		assertEquals(bob, list.get(6));

	}

	@Test
	public void toArrayTest() {
		list.add(alex);
		list.add(bob);
		list.add(clark);

		Object[] students = new Student[] { alex, bob, clark };
		Object[] listElementArray = list.toArray();
		assertArrayEquals(students, listElementArray);
		assertEquals(list.get(0), listElementArray[0]);
		assertEquals(list.get(1), listElementArray[1]);
		assertEquals(list.get(2), listElementArray[2]);
	}

	@Test
	public void toArrayParametarizedTest() {
		list.add(alex);
		list.add(bob);
		list.add(clark);

		Object[] students = new Student[] { alex, bob, clark };
		Object[] exactLengthArray = new Student[3];
		Student[] smallerLengthArray = new Student[1];

		list.toArray(exactLengthArray);

		Student[] elementsFromList = list.toArray(smallerLengthArray);

		assertArrayEquals(students, exactLengthArray);
		assertArrayEquals((Student[]) students, elementsFromList);
		assertArrayEquals(elementsFromList, exactLengthArray);
	}

	@Test
	public void iteratorTest() {
		list.add(alex);
		list.add(bob);
		list.add(clark);

		Object[] students = new Student[] { alex, bob, clark };
		Object[] listElementArray = list.toArray();

		Iterator<Student> iterator = list.iterator();
		Object[] elemetsFromIterator = new Student[3];
		int counter = 0;
		while (iterator.hasNext()) {
			elemetsFromIterator[counter] = iterator.next();
			counter++;
		}

		assertArrayEquals(elemetsFromIterator, students);
		assertArrayEquals(elemetsFromIterator, listElementArray);
		assertEquals(elemetsFromIterator[0], students[0]);
	}

	@Test
	public void listIteratorTest() {
		list.add(alex);
		list.add(bob);
		list.add(clark);

		Object[] students = new Student[] { alex, bob, clark };
		Object[] studentsReverseOrder = new Student[] { clark, bob, alex };

		ListIterator<Student> iterator = list.listIterator();
		Object[] elemetsFromIterator = new Student[3];
		Object[] elemetsFromIteratorReverse = new Student[3];
		int counter = 0;
		while (iterator.hasNext()) {
			elemetsFromIterator[counter] = iterator.next();
			counter++;
		}

		int counterForReverse = 0;
		while (iterator.hasPrevious()) {
			elemetsFromIteratorReverse[counterForReverse] = iterator.previous();
			counterForReverse++;
		}

		assertArrayEquals(elemetsFromIterator, students);
		assertArrayEquals(elemetsFromIteratorReverse, studentsReverseOrder);

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void outOfIndexAdd() {
		list.add(-1, don);
		list.add(89, gary);
	}

	@Test(expected = ConcurrentModificationException.class)
	public void IteratorconcurrentModificationTest() {
		list.add(don);
		list.add(gary);
		Iterator<Student> iterator = list.iterator();
		list.add(alex);
		iterator.hasNext();
	}

	@Test(expected = ConcurrentModificationException.class)
	public void listIteratorconcurrentModificationTest() {
		list.add(don);
		list.add(gary);
		ListIterator<Student> iterator = list.listIterator();
		list.add(alex);
		iterator.hasNext();
	}
	
	@Test
	public void forEachAndStream()
	{
		
		list.add(alex);
		list.stream().forEach((elements) -> {
			assertEquals(alex,elements);
		});
		
	}

}
