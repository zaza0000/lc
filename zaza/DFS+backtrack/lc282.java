package DFSandBacktrack;

import java.util.ArrayList;
import java.util.List;

public class lc282 {
    char[] operators;
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0)
            return res;
        int[] nums = new int[num.length()];
        char[] exp = new char[num.length()*2-1];
        operators = new char[4];
        operators[0] = '+';
        operators[1] = '-';
        operators[2] = '*';
        operators[3] = '.';
        for (int i = 0; i < num.length()-1; i++) {
            char ch = num.charAt(i);
            exp[i*2] = ch;
            exp[i*2+1] = '.';
        }
        exp[exp.length-1] = num.charAt(num.length()-1);
        backtrack(res, exp, 1, target);
        return res;
    }

    private void backtrack(List<String> res, char[] exp, int index, int target) {
        if(index == exp.length) {
            if(target == getSum(exp, 0, exp.length)){
                //System.out.println(buildStr(exp));
                //System.out.println(getSum(exp, 0, exp.length));
                res.add(buildStr(exp));
                //System.out.println("here");
            }
            return;
        }
        for (int i = 0; i < operators.length; i++) {
            if (i == operators.length-1 && exp[index-1] == '0'){
                if(index-2 >=0 && exp[index-2] == '.'){
                } else{
                    continue;
                }
            }
            exp[index] = operators[i];
            backtrack(res, exp, index+2, target);
            exp[index] = '.';
        }
    }

    private String buildStr(char[] exp) {
        String str = "";
        int sum = 0;
        for (int i = 0; i < exp.length; i++) {
            if(exp[i] != '.')
                str += exp[i];
        }
        return str;
    }

    private long getSum(char[] exp, int start, int end) {
        long sum = 0;
        long num1 = 0;
        long num2 = 0;
        for (int i = start; i < end; i++) {
            if (exp[i] <= '9' && exp[i] >= '0') {
                num1 = num1*10 + Character.getNumericValue(exp[i]);
            } else if (exp[i] == '+' || exp[i] == '-'){
                int nextend = i;
                while(++nextend < end){
                    if(exp[nextend] == '+' || exp[nextend] == '-')
                        break;
                }
                num2 = getSum(exp, i+1, nextend);
                //System.out.println(i+1+" "+ end);
                //System.out.println("--"+num1+" "+num2);
                if(exp[i] == '+')
                    sum += num1 + num2;
                else
                    sum += num1 -num2;
                i = nextend-1;
                num1 = 0;
                num2 = 0;
            } else if (exp[i] == '*') {
                int nextend = i;
                while(++nextend < end){
                    if(exp[nextend] == '+' || exp[nextend] == '-' || exp[nextend] == '*')
                        break;
                }
                num2 = getSum(exp, i+1, nextend);
                num1= num1*num2;
                i = nextend-1;
                num2 = 0;
            }
        }
        if(num1 != 0)
            sum += num1;
        return sum;
    }
}
