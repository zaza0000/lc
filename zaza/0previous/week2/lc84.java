import java.util.*;

public class lc84 {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < heights.length; i++){
            while(st.size()>0 && heights[st.peek()]>heights[i]){
                int temp = st.peek();
                st.pop();
                if(st.size() == 0)
                    ans = Math.max(ans, heights[temp]*i);
                else
                    ans = Math.max(ans, heights[temp]*(i-st.peek()-1));
            }
            st.push(i);
        }
        while(st.size()>0){
            int temp = st.peek();
            st.pop();
            if(st.size() == 0)
                ans = Math.max(ans, heights[temp]*heights.length);
            else
                ans = Math.max(ans, heights[temp]*(heights.length-st.peek()-1));
        }

        return ans;
    }
}
