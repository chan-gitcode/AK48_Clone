package Leetcode;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    class Solution {
        //        Input: s = "anagram", t = "nagaram"
        //        Output: true
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> mapS = new HashMap<>();
            Map<Character, Integer> mapT = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char cS = s.charAt(i);
                char cT = t.charAt(i);
                mapS.put(cS, mapS.getOrDefault(cS,0)+1);
                mapT.put(cT, mapT.getOrDefault(cT,0)+1);
            }
            return mapS.equals(mapT);
        }
    }
}
