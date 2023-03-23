public class TrieNode {
    boolean end_of_word;
    TrieNode[] neighbors;

    public TrieNode() {
        end_of_word = false;
        neighbors = new TrieNode['z'-'a'+1];
    }
}
