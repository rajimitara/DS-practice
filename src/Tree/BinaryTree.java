package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	public static void main(String[] args){
		
		//insert(head);
	}
	
	public void lineOrder(Tree root){
		Queue<Tree> queue = new LinkedList<Tree>();
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
	
	public void preOrder(Tree root){
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
