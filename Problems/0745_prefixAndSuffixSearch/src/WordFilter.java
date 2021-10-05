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
            root.weight = -1;

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
                    System.out.println("Adding..."+_w.substring(i));
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
            String t = s+"#"+p;

            System.out.println(t);

            for(int i=0;i<t.length();i++) {
                char key = t.charAt(i);
                System.out.println(key);
                if(!cur.value.containsKey(key)) {
                    System.out.println("Key is: "+key+" Trie result:"+cur.value.containsKey(key));
                    return -1;
                }
                cur=cur.value.get(key);
            }
            System.out.println("HERE!!!! "+cur.weight);
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
