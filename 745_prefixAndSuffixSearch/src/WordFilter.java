import java.util.HashMap;

class WordFilter {
    Trie dictionary;

    public static void main(String[] args) {
        WordFilter wf = new WordFilter(new String[] {"apple","fritter"});
        System.out.println(wf.f("a","e"));

    }

    private class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();

        }
        public Trie(String[] dictionary) {
            this();
            this.add(dictionary);

        }
        private class TrieNode{
            int weight;
            HashMap<Character,TrieNode> value;

            public TrieNode() {
                weight = 0;
                value = new HashMap<>();
            }

            public void add() {

            }
        }

        /*
        * Adds individual word if not in Trie
        * */
        public void add(String[] words) {

            System.out.println(root==null);
            TrieNode cur;

            for(int weight=0;weight<words.length;weight++){
                String _w = words[weight] + "#" + words[weight];
                System.out.println(_w);

                for (int i = 0; _w.charAt(i) != '#'; i++) {
                    cur = root;
                    cur.weight=weight;
                    for (int j = i; j < _w.length(); j++) {
                        if (cur.value == null) cur.value = new HashMap<>();

                        char key = _w.charAt(j);
                        if (cur.value.containsKey(key)) cur = cur.value.get(key);
                        else cur.value.put(key, new TrieNode());
                        cur.weight=weight;
                    }
                }
            }
        }

        public boolean contains(String w) {
            TrieNode cur = root;

            for(int i=0;i<w.length();i++) {
                char key = w.charAt(i);
                if(!cur.value.containsKey(key)) return false;
                else cur = cur.value.get(key);
            }
            return true;
        }

        public int search(String p, String s) {
            TrieNode cur = root;
            System.out.println("TEST STATEMENTS");
            System.out.println(root==null);
            System.out.println(cur==null);
            String t = p+"#"+s;

            System.out.println("PRE LOOP TEST");

            for(int i=0;i<t.length();i++) {
                System.out.println(cur==null);
                char key = t.charAt(i);
                if(!cur.value.containsKey(key)) return -1;
                cur = cur.value.get(t);
            }
            return cur.weight;
        }
    }

    public WordFilter(String[] words) {
        dictionary = new Trie(words);
    }

    public int f(String prefix, String suffix) {
        return dictionary.search(prefix,suffix);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
