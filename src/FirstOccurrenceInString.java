import java.util.List;

public class FirstOccurrenceInString {


    public static void main(String[] args) {
//        String haystack = "abasbdabfaeioadnanlknl";
//        String needle = "nan";
//        int res = strStr(haystack, needle);
//        System.out.println("res = " + res);

        String s = "  hello world  ";
        String rev = reverseWords(s);
        System.out.println("rev = " + rev);

    }

    public static int strStr(String haystack, String needle) {
        int needleSize = needle.length();
        int haystackSize = haystack.length();
        if (needle.equals(haystack)) {
            return 0;
        }
        for (int i = 0; i < haystackSize - needleSize + 1; i++) {
            String word = haystack.substring(i, i + needleSize);
            System.out.println("word = " + word);
            if (word.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static String reverseWords(String s) {
        List<String> words = List.of(s.split(" "));
        int size = words.size();
        StringBuilder rev = new StringBuilder();
        for (int index = size - 1; index >= 0; index--) {
            String word = words.get(index).strip();
            if (word.strip().length() != 0) {
                System.out.println("word = " + word);
                rev.append(word);
                rev.append(" ");
            }
        }
        rev.deleteCharAt(rev.length() - 1);
        return rev.toString();
    }

    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int counter = 1;
        for (int index = 1; index < size; index++) {
            if (counter == 1 || nums[index - 2] != nums[index]) {
                nums[counter++] = nums[index];
            }
        }
        return counter;
    }
}