package algorithm;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode30 {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>(); // result

        if (words == null || words.length < 1) return res; // boundary

        // init a HashMap
        Map<String, Integer> map  = new HashMap<>(); // <word, count>
        for(String str: words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int wLen = words[0].length();
        int cLen = words.length * wLen; // length of a concatenation of each word

        for(int i = 0; i <= s.length() - cLen; i++) {
            Map<String, Integer> occ = new HashMap<>(); // occurrence of words in substring
            int j = 0;
            while (j < words.length) {
                String oneWord = s.substring(i + j * wLen, i + (j + 1) * wLen);
                if (map.containsKey(oneWord)) occ.put(oneWord, occ.getOrDefault(oneWord, 0) + 1);
                else break;
                j++;
            }
            if (j == words.length && map.equals(occ)) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word","good","best","good"};

        LeetCode30 solution = new LeetCode30();
        solution.findSubstring(s2, words2);
    }
}
