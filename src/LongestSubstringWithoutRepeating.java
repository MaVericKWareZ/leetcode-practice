import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int len = lengthOfLongestSubstring(s);
        System.out.println("len = " + len);
    }

    public static int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int maxLength = 0;
        int leftPtr = 0;
        int rightPtr = 0;
        Map<String, Integer> charsVisitedIndexMap = new HashMap<>();
        while (rightPtr < size) {
            String ch = String.valueOf(s.charAt(rightPtr));
            if (charsVisitedIndexMap.getOrDefault(ch, -1) >= leftPtr) {
                leftPtr = charsVisitedIndexMap.get(ch) + 1;
            }
            int length = rightPtr - leftPtr + 1;
            maxLength = Math.max(maxLength, length);
            charsVisitedIndexMap.put(ch, rightPtr);
            rightPtr++;
        }

        return maxLength;
    }
}
