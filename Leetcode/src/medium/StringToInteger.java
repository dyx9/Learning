package medium;

public class StringToInteger {
    public static int myAtoi(String s) {

        // remove leading space
        char[] array = s.trim().toCharArray();
        // return immediately if it's empty
        if (array.length == 0) return 0;
    
        // track the first digit
        int start = 0;
        int sign = 1;

        // note -sign and increment pointer
        if (array[start] == '-') {
            sign = -sign;
            start++;
        }
        // increment pointer
        else if (array[start] == '+') {
            start++;
        }

        int res = 0;
        for (int i = start; i<array.length; i++) {
            // check if the character is digit, otherwise break the loop
            if (array[i] >= '0' && array[i] <= '9') {
                // check if next operation cause overflow ( > 2147483647 )
                //      case 1: res * 10 > Integer.MAX_VALUE
                //      case 2: res * 10 = Integer.MAX_VALUE, but the naxt char > 7
                if ( res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && array[i] > '7') ) {
                    // return clamped res
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                else {
                    // convert chars to integers 
                    // res = res * 10 + Integer.parseInt(String.valueOf(array[i]));
                    res = res * 10 + (array[i] - '0');
                }
            }
            else break;
        }

        if (sign == -1) {
            return -res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" 12"));
    }
}
