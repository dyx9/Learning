package easy;

public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            // if a has digit, add
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            // if b has digit, add
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            carry = sum / 2;
            res.append(sum % 2);
        }

        if (carry != 0) res.append(1);
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println("Sum of binary strings: " + addBinary(a, b));
    }

}
