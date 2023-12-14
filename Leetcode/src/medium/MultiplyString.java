package medium;

public class MultiplyString {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        // max length of result will be len(num1) + len(num2)
        int[] res = new int[num1.length() + num2.length()];

        // loop from the last digit
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                // convert char digit to int and multiply
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // sum of current product with previous carry, i.e., res[i + 1] from last loop 
                int sum = mul + res[i + j + 1];

                // store the current units place
                res[i + j + 1] = sum % 10;
                // store the tens place, i.e., carry
                res[i + j] += sum / 10;
            }
        }

        // remove leading 0s
        StringBuilder sb = new StringBuilder();
        for (int r : res) {
            if (sb.length() == 0 && r == 0) continue;
            sb.append(r);
        }
        return sb.toString();
    }    
}
