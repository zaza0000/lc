class Solution {
    public int numDecodings(String s) {
        int ans[] = new int[s.length()+1];

        ans[0] = 1;
        for (int i=1; i<=s.length(); i++) {
            if (s.charAt(i-1)-'0' > 0)
                ans[i] += ans[i-1];
            if (i-1 <= 0 || s.charAt(i-2) == '0') continue;
            int code = (s.charAt(i-1)-'0') + (s.charAt(i-2)-'0') * 10;
            if (code > 0 && code <= 26)
                ans[i] += ans[i-2];
        }
        return ans[s.length()];
    }
}