import java.util.HashMap;

class validAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> fs = new HashMap<>();
        HashMap<Character, Integer> ft = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            fs.put(c, fs.getOrDefault(c, 0) + 1);
        }
        
        for (char c : t.toCharArray()) {
            ft.put(c, ft.getOrDefault(c, 0) + 1);
        }

        for (char c : fs.keySet()) {
            if (!ft.containsKey(c) || !fs.get(c).equals(ft.get(c))) {
                return false;
            }
        }

        return true;
    }
}
