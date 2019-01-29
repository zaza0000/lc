public class lc67 {
    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        String ans = "";
        int i = aa.length -1;
        int j = bb.length -1;
        char cmp = '0';
        while(i>=0 && j>=0){
            int t1 = aa[i] - '0';
            int t2 = bb[j] - '0';
            int sum = cmp - '0';
            sum += t1 + t2;
            if(sum == 3){
                ans = "1"+ans;
                cmp = '1';
            }else if(sum == 2){
                ans = "0"+ans;
                cmp = '1';
            }else if(sum == 1){
                ans = "1"+ans;
                cmp = '0';
            }else if(sum == 0){
                ans = "0"+ans;
                cmp = '0';
            }
            i--;
            j--;
        }
        while(cmp == '1'){
            int temp = 0;
            if(i>=0){
                temp = aa[i] - '0';
                i--;
            }else if(j>=0){
                temp = bb[j] - '0';
                j--;
            }
            int sum = cmp - '0';
            sum += temp;
            if(sum == 2){
                ans = "0"+ans;
                cmp = '1';
            }else if(sum == 1){
                ans = "1"+ans;
                cmp = '0';
            }else if(sum == 0){
                ans = "0"+ans;
                cmp = '0';
            }
        }
        while(i>=0){
            ans = aa[i] + ans;
            i--;
        }
        while(j>=0){
            ans = bb[j] + ans;
            j--;
        }

        return ans;
    }
}
