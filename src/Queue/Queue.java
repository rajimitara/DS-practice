package Queue;

import javax.print.attribute.Size2DSyntax;

import LinkedList.Node;

public class Queue {
	static int size = 10;
	static int rear1 = 0;
	static int front1 = 0;
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6};
		int n = arr.length;
		Node rear =null,front=null;
		
		for(int i=0;i<n;i++)
			enqueue(rear,front,arr[i]);
		
		for(int i=0;i<3;i++)
			dequeue(rear,front);
		
		
		//Array Impl
		
		int[] queue = new int[size];
		
		for(int i=0;i<n;i++)
			try {
				enqueue(arr[i],queue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		System.out.println("Next element in queue " + queue[front1-1]);
		System.out.println("Capacity of queue "+(Math.abs(rear1-front1)));
		
		for(int i=0;i<3;i++)
			try {
				dequeue(queue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("Next element in queue " + queue[front1-1]);
		System.out.println("Capacity of queue "+(Math.abs(rear1-front1)));
	}
	
	private static void dequeue(int[] queue) throws Exception {
		if(front1 == 0)
			throw new Exception("Queue is empty");
		else if(front1== rear1){
			front1=0;
			rear1=0;
		}
		queue[front1] = 0;
		front1++;
	}

	private static void enqueue(int val, int[] queue) throws Exception {
		if(rear1 == size)
			throw new Exception("Queue is full");
		
		if(rear1 == front1){
			queue[rear1++] = val;
			front1++;
		}else{
			queue[rear1++] = val;	
		}
	}

	private static void dequeue(Node rear, Node front) {
		if(front ==null)
			return;
		if(front.next!=null){
			front = front.next;
		}else{
			front = null;
			rear = null;
		}
		
	}

	public static void enqueue(Node rear,Node front, int val){
		Node queue = new Node(val,null);
		if(rear==null){
			rear = queue;
			front = queue;
		}else{
			rear.next = queue;
			rear = rear.next;
		}
	}
	
} 