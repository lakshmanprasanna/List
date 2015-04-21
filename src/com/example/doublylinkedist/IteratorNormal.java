package com.example.doublylinkedist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorNormal<E> implements Iterator<E> {

	private Node<E> nextNode = new NullNode<E>();
	private DoublyLinkedList<E> list;

	public IteratorNormal(DoublyLinkedList<E> list) {
		nextNode = list.getHead();
		this.list = list;
	}

	/*
	 * Returns true if the list has next node.
	 */
	@Override
	public boolean hasNext() {
		checkForModification();
		return !nextNode.isNull();
	}

	/*
	 * Returns current the node data and moves current node to next.
	 */
	@Override
	public E next() {
		checkForModification();
		if (hasNext()) {
			E data = nextNode.getData();
			nextNode = nextNode.getNext();
			return data;
		} else
			throw new NoSuchElementException();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();

	}

	/*
	 * This method checks for any list modification.If there is any modification
	 * it throws ConcurrentModificationException.
	 */
	protected void checkForModification() {
		boolean hasModified = list.getHasModified();
		if (hasModified)
			throw new ConcurrentModificationException();
	}

}
