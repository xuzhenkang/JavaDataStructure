package datastructure.graph;

public class Queue {
	GraphNode first, last;
	public void enQueue(GraphNode n) {
		if (first == null) {
			first = n;
			last = first;
		} else {
			last.next = n;
			last = n;
		}
	}
	public GraphNode deQueue() {
		if (first == null) {
			return null;
		} else {
			GraphNode temp = new GraphNode(first.val, first.neighbors);
			first = first.next;
			return temp;
		}
	}
}
