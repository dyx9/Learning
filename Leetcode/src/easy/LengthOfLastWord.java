package easy;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i--;
        }
        int length = 0;
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                length++;
            }
            else {
                return length;
            }
            i--;
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s));
    }
}
