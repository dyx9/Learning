package medium;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
        public static String zigzagConvert(String s, int numRows) {
        
        if (numRows < 2) return s;
        
        // a list of StringBuilder to store each char in each row
        List<StringBuilder> rows = new ArrayList<StringBuilder>(numRows);
        for (int i=0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0;
        // tricky to set flag = -1
        int flag = -1;

        // iterate each char of the string, change the index (i)
        // according to if it reaches the turning point (0, or numRows-1)
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows -1) {
                flag = -flag;
            }
            // i will increase 1 if it goes down
            // i will decrease 1 if it goes up
            i += flag;
        }

        // concatnate each row together
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(zigzagConvert("PAYPALISHIRING", 3));
    }
}
