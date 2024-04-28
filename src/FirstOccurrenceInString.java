public class FirstOccurrenceInString {


    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        int res = strStr(haystack,needle);
        System.out.println("res = " + res);
    }

    public static int strStr(String haystack, String needle) {
        int needleSize = needle.length();
        int haystackSize = haystack.length();
        if (needle.equals(haystack)) {
            return 0;
        }
        for (int i = 0; i < haystackSize - needleSize + 1; i++) {
            String word = haystack.substring(i, i+needleSize);
//            System.out.println("word = " + word);
            if (word.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}