import java.util.*;

public class lc91 {
    public int numDecodings(String s) {
        if(s.isEmpty())
            return 0;
        Integer len = s.length();
        if(s.charAt(0) == '0')
            return 0;
        Integer f[] = new Integer[len+1];
        f[0] = 1;
        char[] c = s.toCharArray();
        for(int i = 1; i < len+1; i++){
            if(c[i-1] != '0'){
                if(i == 1){
                    f[i] = f[i-1];
                    continue;
                }
                if(c[i-2] == '1'){
                    f[i] = f[i-1] + f[i-2];
                }
                else if(c[i-2] == '2'){
                    if(c[i-1] >= '0' && c[i-1] <='6')
                        f[i] = f[i-1] + f[i-2];
                    else
                        f[i] = f[i-1];
                }
                else{
                    f[i] = f[i-1];
                }
            }
            else{
                if(c[i-2] == '1' || c[i-2] == '2')
                    f[i] = f[i-2];
                else
                    return 0;
            }
        }
        return f[len];
    }
}
