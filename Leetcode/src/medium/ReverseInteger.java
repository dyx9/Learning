package medium;

public class ReverseInteger {
    public int reverseInteger(int x) {

        int res = 0;
        while (x != 0) {
            // check if the results will exceed [-2^32,2^32-1]
            if ( res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) return 0;
            
            res = 10 * res + x % 10;
            x /= 10;
        }

        return res;
    }
}
