
import java.util.LinkedList;
import java.util.Queue;

public class Customer {
	
	public Queue<Integer> queue = new LinkedList<>();
	public int num = 0;
	public int size = 0;
	
	// take a number
	int takeNum() {
		num++;
		queue.add(num);
		size++;
		return num;
	}
	
	// now serving
	int nowServing() {
		return queue.peek();
	}
	
	// last issued number
	int lastNum() {
		if (queue.isEmpty()) {
			return 0;
		}
		return num;
	}
}
