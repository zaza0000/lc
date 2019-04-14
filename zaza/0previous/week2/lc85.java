import java.util.*;

public class lc85 {
    int[] height;
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        height = new int[matrix[0].length + 1];
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0')
                    height[j] = 0;
                else
                    height[j]++;
            }
            ans = Math.max(ans, maxRect());
        }

        return ans;
    }

    public int maxRect(){
        int ans = 0;
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < height.length; i++){
            while(st.size()>0 && height[st.peek()]>height[i]){
                int temp = st.peek();
                st.pop();
                if(st.size() == 0)
                    ans = Math.max(ans, height[temp]*i);
                else
                    ans = Math.max(ans, height[temp]*(i-st.peek()-1));
            }
            st.push(i);
        }

        return ans;
    }
}
