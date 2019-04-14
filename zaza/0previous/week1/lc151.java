public class lc151 {
    public String reverseWords(String s) {
        if(s == null)
            return s;
        char[] c = s.toCharArray();
        reverse(c, 0, c.length -1);
        int start = 0;
        int end = 0;
        int index = 0;
        while(index < c.length){
            while(index < c.length && c[index] == ' ')
                index++;
            start = index;
            while(index < c.length && c[index] != ' '){
                index++;
            }
            end = index - 1;
            reverse(c, start, end);
        }
        start = 0;
        index = 0;
        while(index < c.length){
            while(index < c.length && c[index] == ' '){
                index++;
            }
            while(index < c.length && c[index] != ' '){
                c[start++] = c[index++];
            }
            while(index < c.length && c[index] == ' '){
                index++;
            }
            if(index < c.length)
                c[start++] = ' ';
        }

        return new String(c).substring(0, start);
    }

    public void reverse(char[] c, int s, int e){
        if(c == null || e >= c.length)
            return;
        while(s < e){
            char temp;
            temp = c[s];
            c[s++] = c[e];
            c[e--] = temp;
        }
    }
}
