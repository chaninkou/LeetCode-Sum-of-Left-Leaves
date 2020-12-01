package leetcode404;

import java.util.Stack;

public class FindSumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        } 
        int result = 0;
        
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null){
                result += root.left.val;
            }else{
                result += sumOfLeftLeaves(root.left);
            } 
        }
        
        result += sumOfLeftLeaves(root.right);
    
        return result;
    }
    
	public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int result = 0;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null){
                    result += node.left.val;
                }
                else{
                    stack.push(node.left);
                }
            }
            
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null){
                    stack.push(node.right);
                }
            }
        }
        return result;
    }
}
