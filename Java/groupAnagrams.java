class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans= new ArrayList<>();
        HashMap<String, List<String>> check= new HashMap<>();

        for(String s: strs){
            char[] charArr= s.toCharArray();
            Arrays.sort(charArr);

            String temp= String.valueOf(charArr);
            if(!check.containsKey(temp))
                check.put(temp, new ArrayList<>());
            
            check.get(temp).add(s);
        }

        ans.addAll(check.values());
        return ans;
    }
}