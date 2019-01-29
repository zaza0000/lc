public class lc224 {
    public int calculate(String s) {
        if(s == null)
            return 0;
        int index = 0;
        int sign = 1;
        int sum = 0;
        int number = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            if(c == '+'){
                sum = sum + sign*number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                sum = sum + sign*number;
                number = 0;
                sign = -1;
            }else if(c <= '9' && c >='0'){
                number = number*10 + (c - '0');
            }else if(c == '('){
                String ss = null;
                int end = index + 1;
                int finish = 1;
                while(finish != 0){
                    char cc = s.charAt(end);
                    if(cc == '(')
                        finish++;
                    else if(cc == ')')
                        finish--;
                    end++;
                }
                ss = s.substring(index+1, end-1);
                number = calculate(ss);
                index = end-1;
            }else{
                //
            }
            index++;
        }
        sum = sum + sign*number;
        return sum;
    }
}


//  14ms solution:
//    public int calculate(String s) {
//        Stack<Integer> stack = new Stack<>();
//
//        int num = 0;
//        int flag = 1;
//        int res = 0;
//
//        char[] chars = s.toCharArray();
//
//        for (int i = 0; i < chars.length; i++){
//            char c = chars[i];
//            if (Character.isDigit(c)){
//                num = num * 10 + c - '0';
//            } else if (c == '+'){
//                res += num * flag;
//                flag = 1;
//                num = 0;
//            } else if (c == '-'){
//                res += num * flag;
//                flag = -1;
//                num = 0;
//            } else if (c == '('){
//                stack.push(res);
//                stack.push(flag);
//                res = 0;
//                flag = 1;
//            } else if (c == ')'){
//                res += num * flag;
//                res = res * stack.pop() + stack.pop();
//                num = 0;
//            }
//        }
//
//        if(num != 0) {
//            res += flag * num;
//        }
//        return res;
//    }
