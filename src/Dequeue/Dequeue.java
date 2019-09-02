package Dequeue;

import LinkedList.Node;

public class Dequeue {
	
	static Deque front,rear;
	
	public static void main(String[] args){
		int[] arr = {1,45,6,24,52,2};
		int n = arr.length;
		
		for(int i=0;i<n;i++){
			if(i%2==0)
				addToFront(arr[i]);
			else
				addToRear(arr[i]);
		} //52 6 1 45 24 2
		print();
		for(int i=0;i<2;i++){
			if(i%2==0)
				removeFromFront();
			else
				removeFromRear();
		}
		print();
	}
	
		
	private static void print() {
		if(front==null)
			System.out.println("Empty");
		
		Deque itr = front;
		
		while(itr!=null){
			System.out.print(itr.data + "->");
			itr = itr.next;
		}
		System.out.println();
	}


	private static void removeFromRear() {
		if(rear==null)
			return;
		
		if(front==rear){
			front = null; rear = null;
		}
		Deque itr = front;
		while(itr !=null){
			itr = itr.next;
			if(itr!=null && itr.next == rear){
				itr.next = null;
				rear = itr;
			}
		}
		
	}


	private static void removeFromFront() {
		if(rear==null)
			return;
		
		if(front==rear){
			front = null; rear = null;
		}
		Deque nextFront = front.next;
		front.next = null;front = null;
		
		front = nextFront;
		
	}


	private static void addToRear(int val) {
		Deque newNode = new Deque(val);
		if(rear==null){
			rear = newNode;
			front = rear;
		}else{
			rear.next = newNode;
			rear = rear.next;
		}
		
	}


	private static void addToFront(int val) {
		Deque newNode = new Deque(val);
		if(front==null){
			rear = newNode;
			front = rear;
		}else{
			newNode.next = front;
			front = newNode;
		}
		
	}


	
	

}
class Deque{
	int data;
	Deque next =null;
	Deque(int data){
		this.data = data;
		this.next = null;
	}
}
