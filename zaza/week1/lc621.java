import java.util.*;

public class lc621 {
    public int leastInterval(char[] tasks, int n) {
        int[] t = new int[26];
        for(int i = 0; i < tasks.length; i++){
            t[tasks[i] - 'A']++;
        }
        Arrays.sort(t);
        int time = 0;
        while(t[25] > 0){
            int count = 0;
            while(count <= n){
                if(t[25] == 0)
                    break;
                if(count<26 && t[25-count] > 0)
                    t[25-count]--;
                time++;
                count++;
            }
            Arrays.sort(t);
        }
        return time;
    }
}
