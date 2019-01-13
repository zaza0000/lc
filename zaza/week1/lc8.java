public class lc8 {
    public int myAtoi(String str) {
        if(str.length() == 0)
            return 0;
        char[] c = str.toCharArray();
        int index = 0;
        while(index < c.length && c[index] == ' '){
            index++;
        }
        if(index == c.length)
            return 0;
        int sign = 1;
        if(c[index] == '-' || c[index] == '+'){
            if(c[index] == '-')
                sign = -1;
            index++;
        }
        int total = 0;
        while(index < c.length && c[index] <= '9' && c[index] >='0'){
            int temp = c[index] - '0';
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < temp)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = 10 * total + temp;
            index++;
        }

        return sign*total;
    }
}
