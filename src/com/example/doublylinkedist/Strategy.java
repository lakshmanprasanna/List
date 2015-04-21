package com.example.doublylinkedist;

public interface Strategy<E> {
	
	public void add(DoublyLinkedList<E> list,E data);
	public void changeStrategy(DoublyLinkedList<E> list);
	public int compare(E data);

}

