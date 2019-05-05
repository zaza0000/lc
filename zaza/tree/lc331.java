package tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class lc331 {

    // indegree and outdegree
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0)
            return true;
        int degree = 1;
        String[] strs = preorder.split(",");
        for (int i = 0; i < strs.length; i++) {
            degree--;
            if (degree < 0)
                return false;
            if (!strs[i].equals("#"))
                degree += 2;
        }
        return degree == 0;
    }

    // recursive
    boolean ans = true;
    int index;
    public boolean isValidSerialization2(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return true;
        String[] strs = preorder.split(",");
        traversal(strs);
        return ans && (index == strs.length);
    }

    private void traversal (String[] strs) {
        if (index == strs.length){
            ans = false;
            return;
        }
        if (strs[index++].equals("#"))
            return;
        traversal(strs);
        traversal(strs);
    }

    // iterative
    public boolean isValidSerialization3(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return true;
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            //System.out.println(stack);
            while (strs[i].equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(strs[i]);
        }
        return (stack.size() == 1) && (stack.peek().equals("#"));
    }
}
