class Trie {
    
    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(char c){
            val = c;
        }
    }



    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        for(int i = 0; i < word.length(); i++){
            char tmpC = word.charAt(i);
            if(tmp.children[tmpC - 'a'] == null){
                tmp.children[tmpC - 'a'] = new TrieNode(tmpC);
            }
            tmp = tmp.children[tmpC - 'a'];
        }
        tmp.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        for(int i = 0; i < word.length(); i++){
            char tmpC = word.charAt(i);
            if(tmp.children[tmpC - 'a'] == null){
                return false;
            }
            tmp = tmp.children[tmpC - 'a'];
        }
        if(tmp.isWord)
            return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(int i = 0; i < prefix.length(); i++){
            char tmpC = prefix.charAt(i);
            if(tmp.children[tmpC - 'a'] == null){
                return false;
            }
            tmp = tmp.children[tmpC - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */