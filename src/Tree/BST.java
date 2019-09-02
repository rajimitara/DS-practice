package Tree;

public class BST {
	
	public static void main(String[] args){
		int[] arr = {2,4,50,1,90,3};
		int n = arr.length;
		Tree root = null;
		for(int i=0;i<n;i++)
			root = insert(arr[i],root);
		
		BinaryTree bt = new BinaryTree();
		
		bt.inOrder(root);
		
		Tree lca = leastCommonAncestor(root,1,50);
		
		System.out.println("leastCommonAncestor is "+lca.data);
		
		//delete
		
	}

	private static Tree leastCommonAncestor(Tree root, int a, int b) {
		Tree left = null, right = null;
		if(root==null)
			return null;
		
		if(root.data == a || root.data == b)
			return root;
		
		
		if(root.data > a && root.data > b)
			left = leastCommonAncestor(root.left, a, b);
		else if(root.data < a && root.data < b){
			right = leastCommonAncestor(root.right, a, b);
		}else{
			left = leastCommonAncestor(root.left, a, b);
			right = leastCommonAncestor(root.right, a, b);
		}
		
		if(left!=null && right!=null)
			return root;
		else
			return left==null ? right:left;
		
	}

	private static Tree insert(int val, Tree root) {
		if(root==null)
			return new Tree(val);
		
		
		if(val < root.data ){
			if(root.left!=null)
				insert(val,root.left);
			else
				root.left = insert(val,root.left);
		}
		else if(val >= root.data ){
			if(root.right!=null)
				insert(val,root.right);
			else
				root.right = insert(val,root.right);
		}
		return root;
	}
	
	
}
