package com.example.doublylinkedist;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class IteratorList<E> implements ListIterator<E> {

	private Node<E> nextNode = new NullNode<E>();
	private Node<E> head = new NullNode<E>();
	private Node<E> previousNode = new NullNode<E>();
	private DoublyLinkedList<E> list;

	public IteratorList(DoublyLinkedList<E> list) {
		this.nextNode = list.getHead();
		this.head = list.getHead();
		this.list = list;
	}

	/*
	 * If index is passed it sets the current node at the given index position.
	 */
	public IteratorList(DoublyLinkedList<E> list, int index) {
		this.nextNode = list.getHead();
		this.head = list.getHead();
		this.list = list;
		for (int i = 0; i < index && hasNext(); i++) {
			nextNode = nextNode.getNext();
		}
	}

	@Override
	public void add(E arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();

	}

	/*
	 * Returns true if the list has next node.
	 */

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		checkForModification();
		return !nextNode.isNull();
	}

	/*
	 * Returns true if the list has previous node.
	 */

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		checkForModification();
		return !previousNode.isNull();
	}

	/*
	 * Returns current the node data and moves current node to next.
	 */

	@Override
	public E next() {
		checkForModification();
		if (hasNext()) {
			E data = nextNode.getData();
			previousNode = nextNode;
			nextNode = nextNode.getNext();
			return data;
		} else
			throw new NoSuchElementException();
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/*
	 * Returns the current node data and moves current node to previous.
	 */

	@Override
	public E previous() {
		checkForModification();
		if (hasPrevious()) {
			E data = previousNode.getData();
			nextNode = previousNode;
			previousNode = previousNode.getPrevious();
			return data;
		} else
			throw new NoSuchElementException();
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(E arg0) {
		checkForModification();
		head.setData(arg0);
		head = head.getNext();

	}

	/*
	 * This method checks for any list modification.If there is any modification
	 * it throws ConcurrentModificationException.
	 */
	private void checkForModification() {
		boolean hasModified = list.getHasModified();
		if (hasModified)
			throw new ConcurrentModificationException();
	}

}
