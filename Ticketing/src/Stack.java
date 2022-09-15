
public class Stack implements IQueuable{
	int capacity, top = -1;
	String stack[];
	
	Stack(int num){
		capacity = num;
		stack = new String[capacity];
	}
	
	public String[] enqueue(String value) {
		// check capacity of stack
        if (top == capacity - 1) { 
            return null; 
        } 
   
        // insert element on top 
        else { 
            top++;
            stack[top] = value;
            return stack;
        } 
	}
		
	//removes item from queue, and returns the item removed
	public String dequeue() {
		String item;
		if (top == -1) {
			return null;
		}
		else {
			item = stack[top];
			top--;
		}
		return item;
	}
		
	//returns a list of all the items in the queue
	public String[] getQueue() {
		return stack;
	}
		
	//returns the number of items in the queue
	public int size() {
		return stack.length;
	}
}
