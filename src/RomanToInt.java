import java.util.HashMap;
import java.util.Map;

class RomanToInt {
    public static void main(String[] args) {
        String s = "XLIX";
        int value = romanToInt(s);
        System.out.println("value = " + value);
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IX", 9);
        map.put("IV", 4);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int size = s.length();
        int total = 0;
        int prev = 0;
        for (int i = 0; i < size; i++) {
            String ch = s.substring(i, i + 1);
            System.out.println(ch);
            int value = map.getOrDefault(ch, 0);
            if (prev < value) {
                total -= prev;
                int diff = value - prev;
                total += diff;
                prev = diff;
            } else {
                total += value;
                prev = value;
            }
            System.out.println("total = " + total);
        }
        return total;
    }
}
