package LinkedList;

public class linkedList {

	public static void main(String[] args){
		Node head = null;
		int[] arr = {1,3,4,5,6,7,9,10};
		int n = arr.length;
		
		for(int i=0;i<n;i++)
			head = insert(arr[i],head);
		
		print(head);
		
		int k=10; // node with value k
		
		search(head,k);
		print(head);
		
		removeKthNode(head,k);
		print(head);
		
		head = reverse(head);
		print(head);
		
		getLastNode(head);
		
		//reverse every K nodes
		head = reverseKNode(head,3);
		System.out.println("Reversed K Nodes");
		print(head);
		//make it circular
		
		head = changeLinkedlisttoCircularAt(3,head);
		//find if circular linked and also get first Node forming circle.
		
		if(isCircular(head)){
			System.out.println("Circular starting node "+ getCircularStartNode(head).data);
		}
		
	}
	
	private static Node getCircularStartNode(Node head) {
		Node slowPtr = head,fastPtr=head;
		
		while(fastPtr!=null && fastPtr.next!=null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr){
				return findStartingNode(fastPtr,head); 
			}
		}
		return null;
	}

	private static Node findStartingNode(Node fastPtr, Node slowPtr) {
		while(fastPtr!=null){
			if(slowPtr==fastPtr)
				return slowPtr;
			fastPtr = fastPtr.next;
			slowPtr = slowPtr.next;
		}
		return null;
	}

	private static boolean isCircular(Node head) {
		Node slowPtr = head,fastPtr=head;
		
		while(fastPtr!=null && fastPtr.next!=null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr){
				return true; 
			}
		}
		return false;
	}

	private static Node getLastNode(Node head) {
		if(head==null)
			return null;
		
		while(head.next!=null){
			head = head.next;
		}
		return head;
		
	}

	private static Node changeLinkedlisttoCircularAt(int i, Node head) {
		Node circularStart = getNthNode(head,i);
		Node last = getLastNode(head);
		if(last!=null){
			last.next = circularStart;
		}
		return head;
	}

	private static Node getNthNode(Node head, int i) {
		int k=1;
		while(head!=null){
			head = head.next;
			k++;
			if(k==i)
				return head;
		}
		return null;
	}

	private static Node reverseKNode(Node head,int k) {
		int i=0;
		Node prev = null;
		Node last = head;
		Node current = head;
		Node next = null;
		
		while(current!=null && i < k){
			next = current.next;
			current.next = prev;
			i++;
			if(i==k){
				last.next = reverseKNode(next,k);
				return current;
			}
			//next iteration
			prev = current;
			current = next;
			
		}
		
		return prev;
	}
	
	private static Node reverse(Node head) {
		Node prev = head;
		Node last = prev;
		Node current = head.next;
		Node next =null;
		while(current!=null){
			next = current.next;
			current.next = prev;
			//next iteration
			prev = current;
			current = next;
		}
		last.next = null;
		
		return prev;
	}

	private static void print(Node head) {
		while(head!=null){
			System.out.print(head.data +" -> ");
			head = head.next;
		}
		System.out.println();
	}

	private static Node search(Node head,int k) {
		Node prev = head;
		while(prev!=null && prev.next!=null){
			if(prev.next.data == k)
				return prev;
			prev = prev.next;
		}
		return null;
	}

	private static void removeKthNode(Node head, int k) {
		Node prev = search(head,k);
		if(prev!=null){
			Node current = prev.next;
			prev.next = current.next;
			current = null; //GC collected
		}
	}

	public static Node insert(int val,Node head){
		if(head == null){
			head = new Node(val,null);
		}else{
			Node next = head;
			while(next!=null && next.next != null){
				next = next.next;
			}
			if(next!=null)
				next.next = new Node(val,null);
		}
		return head;
		
	}
}


