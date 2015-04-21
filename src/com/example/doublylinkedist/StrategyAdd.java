package com.example.doublylinkedist;

public class StrategyAdd {

	private Node<Student> currentNode, temprorayNode;
	private Strategy<Student> strategy = null;

	public StrategyAdd(Strategy<Student> strategy) {
		this.strategy = strategy;
	}

	/*
	 * Adds the the student in list with respect to the strategy set to the
	 * list.
	 */
	public void add(DoublyLinkedList<Student> list, Student data) {
		// TODO Auto-generated method stub
		currentNode = list.getHead();

		if (currentNode.isNull()) {
			currentNode = new ListNode<Student>(data, new NullNode<Student>(),
					new NullNode<Student>());
			list.setHead(currentNode);
		} else {
			boolean isHead = true, isTail = true;
			while (!currentNode.isNull()) {
				if (strategy.compare(currentNode.getData()) > 0) {
					isTail = false;
					if (isHead) {
						currentNode.insertFirst(data, list);
						list.setHead(currentNode.getPrevious());
					} else {
						currentNode.insertBefore(data, list);
					}
					break;
				} else {
					temprorayNode = currentNode;
					currentNode = currentNode.getNext();
					isHead = false;
				}
			}
			if (isTail) {
				temprorayNode.insertMiddle(data, list);
			}

		}
	}

}
