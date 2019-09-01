package Stack;

import LinkedList.Node;

public class Stack {
	
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

