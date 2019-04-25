class Solution {
    public final static Map<Character, List<Character>> map = new HashMap(){{
        put('2', Arrays.asList('a','b','c'));
        put('3', Arrays.asList('d','e','f'));
        put('4', Arrays.asList('g','h','i'));
        put('5', Arrays.asList('j','k','l'));
        put('6', Arrays.asList('m','n','o'));
        put('7', Arrays.asList('p','q','r','s'));
        put('8', Arrays.asList('t','u','v'));
        put('9', Arrays.asList('w','x','y','z'));
    }};
    
    
    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }
        
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        
        Character first = digits.charAt(0);
        List<String> subList = letterCombinations(digits.substring(1));
        for (Character c: map.get(first)) {
            if (subList.size() == 0) {
                subList.add("");
            }
            for (String str: subList) {
                result.add(c + str);
            }
        }
        
        return result;
    }

    /**
     * Runtime: faster than 89.34%
     * Memory: less than 75.17%
     */
}