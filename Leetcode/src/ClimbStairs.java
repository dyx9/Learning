import java.util.Arrays;

public class ClimbStairs {

    public static int climbStairs(int n) {

        if (n <= 2) return n;
        else {
            int [] array = new int[n];
            array[0] = 1;
            array[1] = 2;
            for (int i = 2; i < n; i++) {
                array[i] = array[i-1] + array[i-2];
            }
            return array[n-1];
        }

    }

    // recursive Fibonacci
    // O(2^n)
    public static int fib(int n) {
        if (n<=1){
            return n;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }

    // Dynamic Programming Fibonacci
    public static int fib1(int n) {
        if (n <= 2) return n;
        else {
            int [] f = new int[n];
            f[0] = 1;
            f[1] = 2;
            for (int i = 2; i < n; i++) {
                f[i] = f[i-1] + f[i-2];
            }
            return f[n-1];
        }
    }

}
