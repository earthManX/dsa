package ds;

public class Trie {
    private class TrieNode{
        int wordCount;
        TrieNode[] alphabets;

        TrieNode(){
            wordCount = 0;
            alphabets = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for( char c : word.toCharArray()){
            if( curr.alphabets[c - 'a'] == null ){
                curr.alphabets[c-'a'] = new TrieNode();
            }
            curr = curr.alphabets[c - 'a'];
        }
        curr.wordCount++;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for( char c : word.toCharArray() ){
            if( curr.alphabets[c - 'a'] == null){
                return false;
            }
            curr = curr.alphabets[c - 'a'];
        }
        return (curr.wordCount != 0 ) ? true : false ;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for( char c : prefix.toCharArray() ){
            if( curr.alphabets[c - 'a'] == null){
                return false;
            }
            curr = curr.alphabets[c - 'a'];
        }
        return true ;
    }
}
