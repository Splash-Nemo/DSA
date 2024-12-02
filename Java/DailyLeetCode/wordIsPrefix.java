class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {

        if(sentence.length()<searchWord.length())
            return -1;

        String[] abc= sentence.split(" ");
        int n1= abc.length;
        int n2= searchWord.length();

        for(int i=0; i<n1; i++){
            if(abc[i].length()>=n2){
                if(abc[i].startsWith(searchWord))
                    return i+1;
            }
        }

        return -1;
    }
}