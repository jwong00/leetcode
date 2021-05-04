import java.util.HashMap;

class WordFilter {
    Trie prefix,suffix;

    public static void main(String[] args) {

        WordFilter wf = new WordFilter(new String[] {"apple"});
        System.out.print(wf.contains("apple"));
    }


    private class Trie {

        TrieNode root;
        private Trie() {
            root = new TrieNode();
        }
        private Trie(String[] s) {
            root = new TrieNode();
            this.add(s);
        }
        private class TrieNode {
            //key implicitly mapped
            HashMap<Character,TrieNode> values;

            private TrieNode() {
                values = new HashMap<>();
            }

        }

        private void add(String s) {
            TrieNode curNode = root;
            System.out.println("Internal debug for adding: "+s);

            for(int i=0;i<s.length();i++) {
                char curKey = s.charAt(i);
                if(!curNode.values.containsKey(curKey)) curNode.values.put(curKey,new TrieNode());
                curNode=curNode.values.get(curKey);
            }

            System.out.println("Internal debug for finish adding:"+s);
        }

        private void add(String[] words) {
            System.out.println("Adding dictionary...");
            for(String w : words) {
                System.out.println("Before call for add: "+w);
                this.add(w);
            }
        }

        private boolean contains(String s) {
            TrieNode curNode = root;

            for(int i=0;i<s.length();i++) {
                char curKey = s.charAt(i);
                System.out.println("TESTING..."+curKey+" "+curNode.values.get(i));
                if(curNode.values.containsKey(curKey)) curNode=curNode.values.get(curKey);
                else return false;
            }
            return true;
        }

    }
    public WordFilter(String[] words) {
        prefix = new Trie(words);
    }

    public int f(String prefix, String suffix) {
        return 0;
    }

    public boolean contains(String s) {
        return prefix.contains(s);
    }


}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
