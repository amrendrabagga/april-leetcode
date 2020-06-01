package practice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingInt;

public class StringRotation {
    public static void main(String[] args) {
        int shift[][] = {{0,1}, {1,2}};
//        System.out.println(gcd(7,2));
        System.out.println(stringShift("abc", shift));
    }

    public static String stringShift(String s, int[][] shift) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        int total = 0;
        Map<Integer, IntSummaryStatistics> map =
                Arrays.stream(shift).
                collect(groupingBy(x->x[0], summarizingInt(x->x[1])));
        for (Map.Entry<Integer, IntSummaryStatistics> entry : map.entrySet()) {
            if (entry.getKey() == 0)
                total -= entry.getValue().getSum();
            else total += entry.getValue().getSum();
        }
        System.out.println(total);
        if (total==0)
            return sb.toString();
        else if (total < 0) {
            total = Math.abs(total) % len;
            String store = sb.substring(0, total);
            return sb.delete(0, total).append(store).toString();
        }
        else {
            int pos = len - total;
            String store = sb.substring(0, pos);
            return sb.delete(0, pos).append(store).toString();
        }
    }

    /*private static String rotateStringForKDistance(String s, int rotations, int len) {
        // using juggling algo
        char[] c = s.toCharArray();
        int j,k;
        for (int i=0;i<gcd(len, rotations);i++) {
            char temp = c[i];
            j = i;
            while(true) {
                k = j + rotations;
                if (k>=len)
                    k -= len;
                if (k==i)
                    break;
                c[j] = c[k];
                j = k;
            }
            c[j] = temp;
        }
        return new String(c);
    }

    private static int gcd(int a, int b) {
        if (b==0)
            return a;
        return gcd(b, a%b);
    }*/
}
