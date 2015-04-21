package com.example.doublylinkedist;

public class ListNode<E> extends Node<E> {

	/*
	 * Real Node holds data, pointer to the next node and pointer to the
	 * previous node.
	 */
	private E data;
	private Node<E> next, previous;

	public ListNode(E data) {
		this.data = data;
		this.next = new NullNode<E>();
		this.previous = new NullNode<E>();
	}

	public ListNode(E data, Node<E> next, Node<E> previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}

	/*
	 * Inserts a new node after the node calling this method.
	 */
	@Override
	public void insertAfter(E data, DoublyLinkedList<E> list) {
		next = new ListNode<E>(data, new NullNode<E>(), this);
	}

	/*
	 * Inserts a new node before the node calling and sets the previous pointer
	 * as null node.
	 */
	@Override
	public void insertFirst(E data, DoublyLinkedList<E> list) {
		previous = new ListNode<E>(data, this, new NullNode<E>());
	}

	/*
	 * Inserts a new node at the middle of the list.
	 */
	@Override
	public void insertMiddle(E data, DoublyLinkedList<E> list) {
		if (next.isNull()) {
			next = new ListNode<E>(data, new NullNode<E>(), this);
			list.setTail(next);

		} else {
			Node<E> nextNode = (ListNode<E>) next;
			next = new ListNode<E>(data, nextNode, this);
			if (!nextNode.isNull()) {
				@SuppressWarnings("unused")
				Node<E> previousNode = nextNode.getPrevious();
				previousNode = next;
			}
		}
	}

	/*
	 * isNull function returns false for the real node.It returns true for a
	 * null node
	 */
	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Inserts a new node before the node calling this method.
	 */
	@Override
	public void insertBefore(E data, DoublyLinkedList<E> list) {
		Node<E> prev = previous;
		previous = new ListNode<E>(data, this, prev);
		prev.setNext(previous);

	}

	@Override
	public E getData() {
		return this.data;
	}

	@Override
	public void setData(E data) {
		this.data = data;
	}

	@Override
	public void setNext(Node<E> next) {
		this.next = next;
	}

	@Override
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}

	@Override
	public Node<E> getNext() {
		return this.next;
	}

	@Override
	public Node<E> getPrevious() {
		return this.previous;
	}
}
