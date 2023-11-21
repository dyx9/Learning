package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInte {

    public static int romanToInt(String s) {

        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            
            int current = charMap.get(s.charAt(i));
            int next = current;
            
            // check if next value exsits
            if (i != s.length()-1) {
                next = charMap.get(s.charAt(i+1));
            }
            // check if next value > current, e.g., "IV"
            if (next > current) {
                // make the cuurent value negative
                current = -current;
            }
            res += current;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

}
