package com.example.doublylinkedist;

import java.util.Iterator;
import java.util.ListIterator;

public abstract class AbstractDecorator extends DoublyLinkedList<Student> {

	protected DoublyLinkedList<Student> list;

	public AbstractDecorator(DoublyLinkedList<Student> list) {
		this.list = list;
	}

	public abstract Iterator<Student> iterator();

	public abstract String toString();

	public abstract Object[] toArray();

	public abstract Student[] toArray(Student[] a);

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean add(Student data) {
		list.add(data);
		return true;
	}

	@Override
	public void add(int index, Student data) {
		list.add(index, data);
	}

	@Override
	public Student get(int index) {
		return list.get(index);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public ListIterator<Student> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<Student> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void changeStrategy(Strategy<Student> strategy) {
		list.changeStrategy(strategy);
	}

	@Override
	public void removeStrategy() {
		list.removeStrategy();
	}

}
