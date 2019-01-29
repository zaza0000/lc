public class lc158 {
    char[] myBuf = new char[4];
    int index = 0;
    int total = 0;
    public int read(char[] buf, int n) {
        int readed = 0;
        while(readed < n){
            if(index == total || total == 0){
                total = read4(myBuf);
                if(total == 0)
                    break;
                index = 0;
            }
            while(readed < n && total > index){
                buf[readed++] = myBuf[index++];
            }
        }
        return readed;
    }

    private int read4(char[] myBuf) {
        return 0;
    }
}
