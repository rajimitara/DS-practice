package Stack;

import LinkedList.Node;

public class Stack {
	static java.util.Stack<Integer> stackBase = new java.util.Stack<Integer>();
	static java.util.Stack<Integer> stackTemp = new java.util.Stack<Integer>();
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};

		int n = arr.length;
		Node head = null;
		for(int i=0;i<n;i++)
			head = push(head,arr[i]);
		
		System.out.println("head of stack "+head.data);
		for(int i=0;i<3;i++)
			try {
				head = pop(head);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		try {
			top(head);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//towers of Hanoi
		towersOfHanoi(3,'A','B','C');
		
		addToQueue(2);addToQueue(3);addToQueue(4);addToQueue(5);addToQueue(6);
		
		peek();
		try {
			System.out.println(getTopFromQueue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		peek();
	}



	private static void peek() {
		if(stackTemp.isEmpty()){
			while(!stackBase.isEmpty())
				stackTemp.add(stackBase.pop());
		}
		System.out.println("Queue top value "+ stackTemp.peek());
	}



	private static Integer getTopFromQueue() throws Exception {
		if(stackTemp.isEmpty()){
			if(stackBase.isEmpty()) throw new Exception("Queue is empty");
			while(!stackBase.isEmpty())
				stackTemp.add(stackBase.pop());
		}
		return stackTemp.pop();
	}



	private static void addToQueue(int val) {
		stackBase.add(val);
	}



	private static void createQueue(java.util.Stack<Integer> stack) {
		
		java.util.Stack<Integer> stack1 = new java.util.Stack<Integer>();
			
		stack1.addAll(stack);
		
	}
	
	



	private static void towersOfHanoi(int n, char from_rod, char aux_rod, char to_rod) {
		if(n == 1){
			System.out.println("Moving 1 rod from "+from_rod+" to rod "+to_rod);
			return;
		}
		towersOfHanoi(n-1,from_rod,  aux_rod,  to_rod);
		System.out.println("Moving "+n+"th rod from "+ from_rod +" to "+to_rod);
		towersOfHanoi(n-1,aux_rod,  from_rod,  to_rod);
	}



	private static void top(Node head) throws Exception {
		if(head == null)
			throw new Exception("Empty");
		System.out.print(head.data);
	}

	private static Node pop(Node head) throws Exception {
		if(head == null)
			throw new Exception("Empty");
		Node head1 = head;
		head = head.next;
		head1 = null;
		return head;
	}

	private static void print(Node head) {
		
	}

	private static Node push(Node head, int i) {
		if(head==null){
			head = new Node(i,null);
		}else{
			Node newNode =new Node(i,head);
			head = newNode;
		}
		return head;
	}
	
}

