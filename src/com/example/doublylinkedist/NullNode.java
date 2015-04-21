package com.example.doublylinkedist;

public class NullNode<E> extends Node<E> {

	/*
	 * NullObject class implements all the operations of the real object, But
	 * these operations do nothing or the correct thing for NUllObject
	 */
	private Node<E> next = null, previous = null;
	private E data = null;

	@Override
	public void setData(E data) {
		// TODO Auto-generated method stub

	}

	@Override
	public E getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setNext(Node<E> node) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<E> getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public void setPrevious(Node<E> node) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<E> getPrevious() {
		// TODO Auto-generated method stub
		return previous;
	}

	@Override
	public void insertAfter(E data, DoublyLinkedList<E> list) {
		next = new ListNode<E>(data, new NullNode<E>(), new NullNode<E>());
		list.setHead(next);
	}

	@Override
	public void insertMiddle(E data, DoublyLinkedList<E> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBefore(E data, DoublyLinkedList<E> list) {
		// TODO Auto-generated method stub
		previous = new ListNode<E>(data, new NullNode<E>(), new NullNode<E>());
		list.setTail(previous);
	}

	@Override
	public void insertFirst(E data, DoublyLinkedList<E> list) {
		// TODO Auto-generated method stub
		previous = new ListNode<E>(data, new NullNode<E>(), new NullNode<E>());
		list.setTail(previous);

	}

	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return true;
	}

}
