import java.util.HashMap;

public class RansomNote {

    public static void main(String[] args) {
        String ransomNote = "abs";
        String magazine = "abcs";
        boolean res = canConstruct(ransomNote, magazine);
        System.out.println("res = " + res);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()){
            return false;
        }
        HashMap<Character, Integer> magazineCounter = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            int val = magazineCounter.getOrDefault(ch, 0);
            magazineCounter.put(ch, ++val);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int val = magazineCounter.getOrDefault(ch, 0);
            if (val == 0) {
                return false;
            }
            magazineCounter.put(ch, --val);
        }
        return true;
    }

}

