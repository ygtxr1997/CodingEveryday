/***
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * 单身狗就这样默默地看着你，一句话也不说。
 */

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-03-10 15:25
 * @description：注意边界条件的判定
 */
class Trie {

    private class Node{
        Node[] children;
        boolean isWord;
        Node(){
            children = new Node[26];
        }
    }

    private Node root;


    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wordc = word.toCharArray();
        Node temp = root;
        for (char c :wordc){
            if (temp.children[c - 'a'] == null)//如果不做判断的话会刷新掉之前的数据导致之前insert的数据都找不到了
                temp.children[c - 'a'] = new Node();
            temp = temp.children[c -'a'];
        }
        temp.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node temp = root;
        char[] wordc = word.toCharArray();
        for (char c :wordc){
            if (temp.children[c- 'a'] == null)
                return false;
            temp = temp.children[c-'a'];
        }
        return temp.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node temp = root;
        char[] prec = prefix.toCharArray();
        for (char c : prec){
            if (temp.children[c - 'a'] == null)
                return false;
            temp = temp.children[c - 'a'];
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
