package com.example.doublylinkedist;

import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class DoublyLinkedList<E> extends AbstractSequentialList<E> {

	private Node<E> head, tail;
	private int counter = 0;
	private boolean hasModified = false;
	private Strategy<E> strategy;

	public DoublyLinkedList() {
		this.head = new NullNode<E>();
		this.tail = new NullNode<E>();
		this.strategy = null;
	}

	public DoublyLinkedList(Strategy<E> strategy) {
		this.head = new NullNode<E>();
		this.tail = new NullNode<E>();
		this.strategy = strategy;
	}

	/*
	 * Adds a new node one after another node. If list had any strategy it calls
	 * the add method of respective strategy
	 */

	@Override
	public boolean add(E data) {
		hasModified = true;
		if (strategy != null) {
			strategy.add(this, data);
		} else {
			tail.insertAfter(data, this);
			tail = tail.getNext();
		}
		counter++;
		return true;
	}

	/*
	 * Adds a new node at the certain index given by user.Throws
	 * IndexOutOfBoundsException for the out of bound indices. Throws
	 * UnsupportedOperationException if list had any strategy
	 */
	@Override
	public void add(int index, E data) {
		if (strategy != null)
			throw new UnsupportedOperationException();

		hasModified = true;
		Node<E> current = head;
		if (index == 0) {
			head.insertFirst(data, this);
			head = head.getPrevious();
		} else {
			if (index < 0 || index > size())
				throw new IndexOutOfBoundsException("Requested Index: " + index
						+ ", " + "Current size: " + size());
			for (int i = 0; i < index - 1; i++)
				current = current.getNext();
			current.insertMiddle(data, this);
		}

		counter++;

	}

	/*
	 * Gets the element at certain index given by user.Throws
	 * IndexOutOfBoundsException for the out of bound indices
	 */

	@Override
	public E get(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Requested Index: " + index
					+ ", " + "Current size: " + size());
		Node<E> current = head;
		for (int i = 0; i < index; i++)
			current = current.getNext();
		E data = current.getData();
		return data;
	}

	@Override
	public int size() {
		return counter;
	}

	@Override
	public boolean isEmpty() {
		return head.isNull();
	}

	/*
	 * Returns the iterator of the list.
	 */

	@Override
	public Iterator<E> iterator() {
		hasModified = false;
		return new IteratorNormal<E>(this);
	}

	/*
	 * Returns the List iterator of the list.
	 */

	@Override
	public ListIterator<E> listIterator() {
		hasModified = false;
		return new IteratorList<E>(this);
	}

	/*
	 * Returns the array of elements from the list.
	 */

	@Override
	public Object[] toArray() {
		Node<E> current = head;
		Object[] object = new Object[size()];
		for (int i = 0; i < size(); i++) {
			object[i] = current.getData();
			current = current.getNext();
		}
		return object;

	}

	/*
	 * Saves the list elements into the array passed to the method and returns
	 * it. If the argument array length is less than the size it creates a new
	 * array with length of the list size.
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <E> E[] toArray(E[] array) {
		int length = array.length;
		Node<E> current = (ListNode<E>) head;
		for (int i = 0; i < size(); i++) {
			if (length == i)
				array = Arrays.copyOf(array, size());
			array[i] = current.getData();
			current = current.getNext();
		}
		return array;
	}

	@Override
	public String toString() {
		Node<E> current = head;
		String str = "[";
		for (int i = 0; i < size(); i++) {
			if (i != size() - 1)
				str = str + current.getData().toString() + ", ";
			else
				str = str + current.getData().toString();
			current = current.getNext();
		}
		str = str + "]";
		return str;
	}

	/*
	 * Returns the iterator of the list starting at given index.
	 */

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		hasModified = false;
		if (index > size() - 1 || index < 0)
			throw new IndexOutOfBoundsException();
		return new IteratorList<E>(this, index);
	}

	/*
	 * This method is used to change the strategy in run time. If the strategy
	 * is null it removes the strategy.
	 */

	public void changeStrategy(Strategy<E> strategy) {
		Node<E> current = head;
		this.strategy = strategy;
		if (strategy == null) {
			for (int i = 0; i < size() - 1; i++) {
				current = current.getNext();
			}
			setTail(current);
		} else {
			strategy.changeStrategy(this);
		}
	}

	public void removeStrategy() {
		changeStrategy(null);
	}

	protected boolean getHasModified() {
		return hasModified;
	}

	protected void setHasModified(boolean hasMod) {
		hasModified = hasMod;
	}

	protected void setHead(Node<E> head) {
		this.head = head;
	}

	protected void setTail(Node<E> tail) {
		this.tail = tail;
	}

	protected Node<E> getHead() {
		return head;
	}

}
