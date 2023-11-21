package medium;

public class IntToRoman {
    public static String intToRoman(int num) {

        // list all possbile values and corresponding symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();

        // if the num > the current largest value
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                // keep add that symbol and subtract the current largest value from num
                res.append(symbols[i]);
                num -= values[i];
            }
            if (num == 0) break;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(4));
    }
}
