package problems;

public class BinarySearchTreeToList {
	
	private TreeNode lastNode;
	
	public TreeNode treeToList(TreeNode root){
		
		lastNode = null;
		toList(root);
		TreeNode pointer = lastNode;
		
		//Go to head
		while(pointer !=null && pointer.left != null){
			pointer = pointer.left;
		}
		
		return pointer;
	}
	
	private void toList(TreeNode node){
		
		
		if(node == null)
			return;
		
		TreeNode currentNode = node;
		

		if(currentNode.left != null)
			toList(currentNode.left);
		 
		currentNode.left = lastNode;

		if(currentNode.val == 1){
			System.out.println(lastNode.val);
		}
			
		if(lastNode != null){
			lastNode.right = currentNode;
		}
		
		lastNode = currentNode;
		
		if(currentNode.right != null){
			toList(currentNode.right);
		}
	}

	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
			left = null;
			right = null;
		}
	}
}
