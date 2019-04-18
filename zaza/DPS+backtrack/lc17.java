package DPSandBacktrack;

import java.util.*;

public class lc17 {

    Map<Character, String> hash;
    ArrayList<String> ans;

    // recursively
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;

        hash = new HashMap<>();
        createMap(hash);
        char[] nums = digits.toCharArray();
        backtrack("", nums, 0);

        return ans;
    }

    private void createMap(Map<Character, String> hash) {
        hash.put('2', "abc");
        hash.put('3', "def");
        hash.put('4', "ghi");
        hash.put('5', "jkl");
        hash.put('6', "mno");
        hash.put('7', "pqrs");
        hash.put('8', "tuv");
        hash.put('9', "wxyz");
    }

    private void backtrack(String combination, char[] nums, int index) {
        if (nums.length == index) {
            ans.add(combination);
            return;
        }
        char[] letters = hash.get(nums[index]).toCharArray();
        for (char letter : letters) {
            backtrack(combination+letter, nums, index+1);
        }
    }

    //iteratively
    public List<String> letterCombinations2(String digits) {
        ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;

        hash = new HashMap<>();
        createMap(hash);
        char[] nums = digits.toCharArray();
        Queue<String> queue = new LinkedList<String>();
        queue.offer("");
        for (char num : nums) {
            char[] letters = hash.get(num).toCharArray();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String combination = queue.poll();
                for (char letter: letters) {
                    queue.offer(combination+letter);
                }
            }
        }
        for (String str : queue) {
            ans.add(str);
        }

        return ans;
    }


}
