package practice;

public class BitwiseAnd {
    public static void main(String[] args) {
        int arr[] = {5,6,7,8};
        System.out.println(rangeBitwiseAnd(5, 7));
    }
    public static int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        while (m>0 && n>0) {
            int msb_m = getMsb(m);
            int msb_n = getMsb(n);

            if (msb_m != msb_n)
                break;
            int msb_val = 1<<msb_m;
            res += msb_val;
            m -= msb_val;
            n -= msb_val;
        }
        return res;
    }
    static int getMsb (int n) {
        int msp_p = -1;
        while (n > 0) {
            n = n>>1;
            msp_p++;
        }
        return msp_p;
    }
}
