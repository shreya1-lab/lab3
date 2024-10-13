class StackException extends RuntimeException{    
		public StackException(String err) {
			super(err);
		}
}

public class Stack implements StackADT {
	
	private class Node{
		int element;
		Node next;
		
		public Node(int e, Node n){
			element = e;
			next = n;
		}
		
		@SuppressWarnings("unused")
		public int getValue() {
			return element;
		}
		
		@SuppressWarnings("unused")
		public Node getNext() {
			return next;
		}
	}
	
	// this is a reference to the head node of the linked list
	private Node top;
	// keep track of the number of elements in the stack
	private int size;
	
	public Stack(){
		top = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int size(){
		return size; 
	}
	
	// part 3: complete
	/** Adds a new element to the stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(1)
	 * 
	 * Because: Adding an element to the top of the stack only 
	 * 
	 * @param o the integer to add to the top of the stack
	 */
	public void push(int o){
		Node newNode = new Node (o, top);
		top = newNode;
		size ++;
	}
	
	// part 3: complete
	/** Removes an element from the top of the stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(1)
	 * 
	 * Because: Removing the top element only involves updating the top pointer 
	 *
	 * @return the integer that was at the top of the stack
	 * @throws StackException if the stack is empty
	 */
	public int pop() throws StackException{
		if (top == null)
			throw new StackException ("empty stack!");
		else { 
			int element = top.element;
			top = top.getNext();
			size --;
			return element; 
	}
}
	
	// part 3: complete
	/** Returns the integer at the top of the stack
	 * 
	 * TODO Where N is the number of elements in the stack the complexity is:
	 *
	 * O(1)
	 * 
	 * Because: Accessing top element does not involve traversal
	 * 
	 * @return the integer at the top of the stack
	 * @throws StackException is the stack is empty
	 */
	public int top() throws StackException{
		if (top == null)
			throw new StackException("stack is empty");
		else
			return top.getValue(); 
	}
}
