
public class Queue implements IQueuable{
	
	int front, rear, capacity;
	String queue[];
	
	Queue(int num){
		front = 0;
		rear = -1;
		capacity = num;
		queue = new String[capacity];
	}
	
	public String[] enqueue(String value) {
		// check capacity of queue
        if (size() == capacity) { 
            return null; 
        } 
   
        // insert element at rear position
        else { 
            queue[rear] = value; 
            rear++; 
            if (rear == capacity - 1) {
                rear = 0;
            }
            return queue;
        } 
	}
		
	//removes item from queue, and returns the item removed
	public String dequeue() {
		String item;
		if (size() == 0) {
			return null;
		}
		else {
			item = queue[front];
			front++;
			if (front == capacity - 1) {
				front = 0;
			}
		}
		return item;
	}
		
	//returns a list of all the items in the queue
	public String[] getQueue() {
		return queue;
	}
		
	//returns the number of items in the queue
	public int size() {
		return queue.length;
	}
}
