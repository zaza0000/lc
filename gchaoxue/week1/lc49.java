class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (!map.containsKey(String.valueOf(chars)))
                map.put(String.valueOf(chars), new ArrayList<>());

            map.get(String.valueOf(chars)).add(s);
        }

        return new ArrayList<>(map.values());
    }
}