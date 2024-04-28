public class IsSubsequence {
    public static void main(String[] args) {
        String s = "b";
        String t = "abc";
        boolean res = isSubsequence(s, t);
        System.out.println("res = " + res);
    }

    public static boolean isSubsequence(String s, String t) {
        int size = t.length();
        int index = 0;
        if (s.isBlank()) {
            return true;
        }
        if (t.isBlank() && !s.isBlank()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (s.charAt(index) == t.charAt(i)) {
                index++;
                if (index == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
