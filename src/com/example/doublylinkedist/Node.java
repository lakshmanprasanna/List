package com.example.doublylinkedist;

public abstract class Node<E> {

	public abstract void setData(E data);
	public abstract E getData();
	public abstract void setNext(Node<E> node);
	public abstract Node<E> getNext();
	public abstract void setPrevious(Node<E> node);
	public abstract Node<E> getPrevious();
	public abstract void insertAfter(E data, DoublyLinkedList<E> list);
	public abstract void insertMiddle(E data, DoublyLinkedList<E> list);
	public abstract void insertBefore(E data, DoublyLinkedList<E> list);
	public abstract void insertFirst(E data,DoublyLinkedList<E> list);
	public abstract boolean isNull();

}
