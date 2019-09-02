package Tree;

import java.util.Queue;

import LinkedList.LinkedList;
import LinkedList.Node;

public class BinaryTree {

	public static void main(String[] args){
		Node head = null;
		LinkedList ll = new LinkedList();
		int[] arr = {1,3,4,5,6,7,9,10};
		int n = arr.length;
		
		for(int i=0;i<n;i++)
			head = ll.insert(arr[i],head);
		
		LinkedList.print(head);
		
		Tree root = insert(head);
		
		preOrder(root);
		
		Tree lca = leastCommonAncestor(root,3,6);
		
		System.out.println("leastCommonAncestor is "+lca.data);
		
		//delete
		
	}
	
	private static Tree leastCommonAncestor(Tree root, int a, int b) {
		Tree left, right;
		if(root==null)
			return null;
		
		if(root.data == a || root.data == b)
			return root;
		
		left = leastCommonAncestor(root.left, a, b);
		right = leastCommonAncestor(root.right, a, b);
		
		if(left!=null && right!=null)
			return root;
		else
			return left==null ? right:left;
	}

	private static Tree insert(Node head) {
		Queue<Tree> queue = new java.util.LinkedList<Tree>();
		if(head==null)
			return null;
		
		Tree root = new Tree(head.data);
		queue.add(root);
		queue.add(null);
		
		while(head!=null && head.next!=null){
			Tree val = queue.remove();
			
			if(val!=null){
				if(head.next!=null){
					head = head.next;
					val.left = new Tree(head.data);
					queue.add(val.left);
				}
				if(head.next!=null){
					head = head.next;
					val.right = new Tree(head.data);
					queue.add(val.right);
				}
				queue.add(val.left);
			}else{
				queue.add(null);
			}
		}
		
		return root;
	}

	public void lineOrder(Tree root){
		Queue<Tree> queue = new java.util.LinkedList<Tree>();
		int i=0;
		
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()){
			Tree val = queue.remove();
			if(val!=null){
				System.out.println(val.data);
				queue.add(root.left);
				queue.add(root.right);
				
			}else{
				queue.add(null);	
			}
		}
		
	}
	
	public static void preOrder(Tree root){
		if(root!=null){
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public void inOrder(Tree root){
		if(root!=null){
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	public void postOrder(Tree root){
		if(root!=null){
			postOrder(root.left);
			System.out.println(root.data);
			postOrder(root.right);
		}
	}
}

class Tree{
	int data;
	Tree left,right;
	
	Tree(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
