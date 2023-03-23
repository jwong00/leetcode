class WordDictionary {
    TrieNode dictionary;

    public WordDictionary() {
        dictionary = new TrieNode();
    }

    /*
    * Adds a word by recursively descending the Trie.
    * As you descend, search for the next node in the array
    * by indexing into the character:
    *
    *   char c = 'i';
    *   index = c - 'a';
    *
    * Where next node is...
    *
    * */
    public void addWord(String word) {
        addWordHelper(word,0,dictionary);
    }

    //for any given index i, the node represents the previous character
    //meaning: check if the current node has a non-null pointer to char i
    private void addWordHelper(String word, int i, TrieNode node) {
        if(node==null) {
            System.out.println("This should be an error state: exiting helper early.");
            return;
        }

        int computed_index = word.charAt(i)-'a';
        if(node.neighbors[computed_index]==null) node.neighbors[computed_index] = new TrieNode();


    }

    public boolean search(String word) {

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
