package HML2;

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abbcaa";
        String words = "the pep pep coding the the";
        System.out.println(pattern(pattern, words));
    }

    private static boolean pattern(String pattern, String str) {
        String[] words = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch) == false) {
                if (used.containsKey(words[i]) == true) {
                    return false;
                } else {
                    used.put(words[i], true);
                    map.put(ch, words[i]);
                }
            } else {
                String mwith = map.get(ch);
                if (mwith.equals(words[i]) == false) {
                    return false;
                }
            }
        }

        return true;

    }

}
