package practice;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(checkHappyOrNot(n));
    }

    private static boolean checkHappyOrNot(int n) {
        int repeatCheck = n;
        while (n%10!=0 && n!=1) {
            int tmp = 0;
            while (n != 0) {
                tmp += Math.pow(n % 10,2);// squaring unit digit in each loop
                n = n/10;
            }
            if (tmp ==1)
                return true;
            if (tmp<10 && tmp !=8)
                return false;
            n = tmp;
        }
        return powerOfTen(n) || n==8;
    }

    private static boolean powerOfTen(int input) {
        while (input > 9 && input % 10 == 0)
            input /= 10;
        return input == 1;
    }
}
