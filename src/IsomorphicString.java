import java.util.HashMap;
import java.util.Map;

class IsomorphicString {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean res = isIsomorphic(s, t);
        System.out.println("res=" + res);
    }

    public static boolean isIsomorphic(String s, String t) {
        int stringLength = s.length();
        Map<String, String> replacementMap = new HashMap<>();

        for (int i = 0; i < stringLength; i++) {
            String og = String.valueOf(s.charAt(i));
            String rep = String.valueOf(t.charAt(i));
            String mapVal = replacementMap.get(og);
            System.out.println("og=" + og + ", rep=" + rep);

            if (mapVal != null && !mapVal.equals(rep)) {
                return false;
            }

            if (replacementMap.containsValue(rep) && !replacementMap.containsKey(og)) {
                return false;
            }

            replacementMap.put(og, rep);

            System.out.println("replacementMap=" + replacementMap);
        }

        return true;
    }
}