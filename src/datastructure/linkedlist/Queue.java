package datastructure.linkedlist;

public class Queue {
	Node first, last;
	
	public void enQueue(Node n) {
		if (first == null) {
			first = n;
			last = first;
		} else {
			last.next = n;
			last = n;
		}
	}
	public Node deQueue() {
		if (first == null) {
			return null;
		} else {
			Node temp = new Node(first.val);
			first = first.next;
			if (last == temp) 
				last = first;
			return temp;
		}
	}
}
