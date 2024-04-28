public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "0P";
        boolean res = isPalindrome(s);
        System.out.println("res = " + res);
    }

    public static boolean isPalindrome(String s) {
        int size = s.length();

        if (size == 1 || s.isEmpty()) {
            return true;
        }

        int beg = 0;
        int end = size - 1;

        while (beg < end) {
            char currStart = s.charAt(beg);
            char currEnd = s.charAt(end);
            if (!Character.isLetterOrDigit(currStart)) {
                beg++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(beg)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                beg++;
                end--;
            }
        }
        return true;
    }
}


