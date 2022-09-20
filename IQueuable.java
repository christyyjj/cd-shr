
public interface IQueuable {
	//adds value to queue and returns new queue
	String[] enqueue(String value);
	
	//removes item from queue, and returns the item removed
	String dequeue();
	
	//returns a list of all the items in the queue
	String[] getQueue();
	
	//returns the number of items in the queue
	int size();
}
