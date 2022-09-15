
public class Management {
	static Customer customer;
	static Counter counter1, counter2, counter3, counter4;
	static int takenNum, toServe;
	
	public static void main(String[]args) {
				
		// ACTION TRIGGER for "Take Number"
		takenNum = customer.takeNum();
		
		
		// ACTION TRIGGER for counter toggle button
		// toggle "Go Offline"
		// counter.setCurrNum("Offline")
		// disable counter
		// -----------------------------
		// toggle "Go Online"
		// remove "disabled" view
		
		
		// ACTION TRIGGER for "Complete Current" 
		// counter.setServing(false);
		// red dot --> green dot
		
		
		// ACTION TRIGGER for "Call Next"
		if (customer.size > 0) {
			
			toServe = customer.nowServing();
			
			/* if (counter.online() && !counter.isServing()) {
			 	counter.setCurrNum(String.valueOf(toServe));
				counter.setServing(true);
				// green dot --> red dot
			}*/
			
			customer.queue.remove();
		}
		else {
			// no more tickets in waiting queue
		}
		
	}
}
