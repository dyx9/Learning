package easy;

public class Reverse {

    public static int reverse(int x) {
        String [] input = new String []{String.valueOf(x)};
        StringBuilder str = new StringBuilder();
        for (String i : input) {
            str.append(i);
        }
        if (str.charAt(0) == '-') {
            str.deleteCharAt(0);
            str = str.reverse();
            str = str.insert(0,'-');
        }
        else str = str.reverse();

        int result = 0;

        try {
            result = Integer.parseInt(str.toString());
        }
        catch (NumberFormatException e) {
            return 0;
        }

        if (result > Math.pow(2,31) - 1 || result < - Math.pow(2,31)) return 0;
        else return result;
    }

    // https://leetcode-cn.com/problems/reverse-integer
    public int reverseSolution(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 ) return 0;
            if (rev < Integer.MIN_VALUE/10 ) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

}
