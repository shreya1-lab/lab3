class LinkedListException extends RuntimeException{    
	public LinkedListException(String err) {
		super(err);
	}
}


public class LinkedList {

	private class Node {
		private int value;
		private Node nextNode;

		public Node(int i) {
			value = i;
			nextNode = null; 
		}

		// returns the value stored in the node
		public int getValue() {
			return value;
		}

		// sets the value stored in the node
		public void setValue(int i) {
			value = i;
		}

		// Returns the Node that this Node links to
		// Note this may return null
		public Node getNextNode() {
			return nextNode;
		}

		// Sets the NextNode to the given Node
		public void setNextNode(Node n) {
			nextNode = n;
		}
		
		// adds Node n to the tail of the list
		public void addNodeAtTail(Node n) {
			if (this.nextNode == null) 
				this.nextNode = n;
			 else 
				this.nextNode.addNodeAtTail(n);
			
		}

		public Node removeAtTail(Node valueAtTail) {
			if (this.nextNode == null) { // if this is the last node
				valueAtTail.setValue(this.getValue()); // copy out the value
				return null; // return null
			} else { // move onto the next Node
				this.nextNode = this.nextNode.removeAtTail(valueAtTail);
				return this;
			}
		}
	} 
	// End of Node Class implementation

	private Node headNode;
	private Node tailNode;// Holds a reference to the head of the list

	public LinkedList() {
		headNode = null;
		tailNode = null;
	}
	public int size() {
		int count = 0;
		Node current = headNode;
		while (current != null) {
			count ++;
			current = current.getNextNode();
		}
		return count;
	}
	public int total() {
		int sum = 0; 
		Node current = headNode; 
		while (current != null) {
			sum += current.getValue();
			current = current.getNextNode();
		}
		return sum;
	}

	public void addAtHead(int i) {
		Node newNode = new Node(i); 
		newNode.setNextNode(headNode); 
		headNode = newNode;
	
	}

	public void addAtTail(int i) {
		Node newNode = new Node(i);
		if (headNode == null) 
			headNode = newNode;
			
		 else 
			tailNode.setNextNode(newNode);
	}
	

	/*
	 * removes and returns the value at the head of the list
	 */ 
	public int removeAtHead()throws LinkedListException {
		if (headNode == null) 
			throw new LinkedListException("Cannot remove from the head of an empty linked list");
		else { 
			Node returnedNode = headNode;
			headNode = headNode.getNextNode();
			return returnedNode.getValue();
	
		}	
	}

	/*
	 * See https://web.microsoftstream.com/video/5a15e714-bf98-4bf6-9124-573638723795
	 */
	public int removeAtTail() throws LinkedListException {
		if (headNode == null) {
			throw new LinkedListException("Cannot remove from the tail of an empty linked list");
			
		} 
		else {
			Node returnedNode = new Node (-1); //placeholder node
			headNode = headNode.removeAtTail(returnedNode);
			return returnedNode.getValue();
		}					
	}


	

	/*
	 * PART 2: complete the following methods
	 */
	

	/** The number of nodes in the linked list, and 0 for an empty linked list.
	 * 
	 * TODO Where N is the length of linked list the complexity is:
	 *
	 * O(n)
	 * 
	 * Because: traversing entire list to count the nodes
	 * 
	 * @return the number of nodes in the linked list
	 */
	
	
	
	/** The sum of all integer nodes in the linked list, and 0 for an empty linked list.
	 *
	 * TODO Where N is the length of linked list the complexity is:
	 *
	 * O(n)
	 * 
	 * Because: traversing entire list to get the sum
	 * 
	 * @return the sum of all nodes in the linked list
	 */


	/*
	 * Optional: reverse the linked lists so that the first element becomes
	 * the last, the second becomes the second last, and so on.
	 */
	

}
