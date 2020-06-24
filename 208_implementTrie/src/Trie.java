class Trie {

    Node root;

    public static void main(String[] args) {
//        System.out.printf("%d %d",(int)'a',(int)'z');
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.startsWith("app"));


    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        //foreach char
        //check if in trie
        //if TRUE go to next char and next node
        //if FALSE insert the rest of chars
        Node cur = root;
        int i=0;

        while(cur.index[word.charAt(i)-'A']!=null) {
            cur=cur.index[word.charAt(i)-'A'];
            i++;
        }
        for(;i<word.length();i++) {
//            System.out.printf("Insert into index %d\n", word.charAt(i)-'A');
            cur.index[word.charAt(i)-'A'] = new Node(word.charAt(i));
            cur=cur.index[word.charAt(i)-'A'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur=root;

        for(int i=0; i<word.length();i++) {
            if(cur.index[word.charAt(i)-'A']==null) return false;
            cur=cur.index[word.charAt(i)-'A'];
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur=root;

        for(int i=0; i<prefix.length();i++) {
            if(cur.index[prefix.charAt(i)-'A']==null) return false;
            cur=cur.index[prefix.charAt(i)-'A'];
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
 *
 * ASSUMPTIONS:
 *  All inputs consist of lowercase letters a-z
 *  All inputs guaranteed to be non-empty.
 */
