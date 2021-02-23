import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("blah");
        s.findLongestWord("test",dictionary);
    }
    public String findLongestWord(String s, List<String> d) {
        if(s==null || d==null || s.length()==0 || d.size()==0) return new String();

        Trie deletionTrie = new Trie(s);
        deletionTrie.printAll();

        return null;

    }

    private class Trie{
        private TrieNode root;

        public void printAll() {
            root.print();
        }

        public Trie(String s) {
            root = new TrieNode(s);
        }
        private class TrieNode {
            boolean isEndOfWord=false;
//            char key;
            HashMap<Character,TrieNode> children = new HashMap<>();

            public TrieNode(String s) {
                if(s==null || s.length()==0) return;
//                key =  s.charAt(0);

//                System.out.println("CONS TRIENODE FOR "+ s);
                System.out.println(s.charAt(0));

                if(s.length()==1) isEndOfWord = true;
                else {
                    children = new HashMap<>();
                    for(int i=0;i<s.length();i++) {
                        children.put(s.charAt(i), new TrieNode(s.substring(i+1)));
                    }
                }

            }

            public boolean isEndOfWord() {
                return isEndOfWord;
            }

            public void print() {
                //print each key then call print on each child
                for(Map.Entry<Character,TrieNode> ch : children.entrySet()) {
                    System.out.println(ch.getKey());
                    ch.getValue().print();
                }
            }



        }

    }
}
