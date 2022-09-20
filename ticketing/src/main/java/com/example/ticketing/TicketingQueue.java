package com.example.ticketing;

import java.util.LinkedList;
import java.util.Queue;

public class TicketingQueue {
	
	private Queue<Integer> queue = new LinkedList<>();
	private int num = 0;
	private int size = 0;
	public String demo = "Hello from Java";
	
	// take a number RETURN last issued number
	public int takeNum() {
		num++;
		size++;
		queue.add(num);
		return num;
	}

	// now serving
	public int nowServing() {
		return queue.peek();
	}
	
	// return number to serve and update queue
	public int callNext() {
		int to_serve = nowServing();
		if (to_serve != 0) {
			queue.remove(to_serve);
		}
		return to_serve;
	}
	
	/** 
	 * Getters and Setters
	 */
	public Queue<Integer> getQueue() {
		return queue;
	}

	public void setQueue(Queue<Integer> queue) {
		this.queue = queue;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}


