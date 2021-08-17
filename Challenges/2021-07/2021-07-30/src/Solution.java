import java.util.ArrayDeque;
import java.util.Deque;

class MapSum {
    public static void main(String[] args) {
        MapSum ms = new MapSum();
        ms.insert("apple",3);
        ms.sum("ap");
        ms.insert("app",2);
        ms.sum("ap");
    }

//    Trie map;
    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        //iterate over char in key while traversing down Trie
        TrieNode cur = root;

        for(int i=0;i<key.length();i++) {
            char cur_char = key.charAt(i);
            //begin insertion upon reaching char not found in Trie
            if(cur.containsKey(cur_char)) cur=cur.get(cur_char);
            else cur=cur.insert(cur_char);
        }

        //should be at the node representing last char
        cur.setValue(val);
    }

    public int sum(String prefix) {
        //traverse trie til end of common prefix
        TrieNode cur = root;
        int sum = 0;
        for(int i=0;i<prefix.length();i++) {
            char cur_char = prefix.charAt(i);
            if(cur.containsKey(cur_char)) cur=cur.get(cur_char);
            else return 0;
        }
        //node representing last character of common prefix is beginning of all suffixes sharing that prefix
//        sum+=cur.val;

        //init stack
        Deque<TrieNode> stack = new ArrayDeque<>();
        stack.push(cur);

        while(!stack.isEmpty()) {
            cur = stack.pop();
            sum+=cur.getValue();
            for(int i='z';i>='a';i--) {
                if(cur.get((char) i) !=null)stack.push(cur.get((char) i));
            }
        }

        System.out.println(sum);

        return sum;
    }

    private class TrieNode {
        TrieNode[] children;
        char key;
        int val;


        public TrieNode() {
            children = new TrieNode['z'-'a'+1];
            val = 0;
        }

        public TrieNode(char key) {
            children = new TrieNode['z'-'a'+1];
            this.key = key;
            val = 0;
        }

        public boolean containsKey(char c) {
            if(children[c-'a']==null) return false;
            return true;
        }

        public TrieNode get(char c) {
            return this.children[c-'a'];
        }

        public TrieNode insert(char c) {
            this.children[c-'a'] = new TrieNode(c);
            return get(c);
        }

        public boolean setValue(int val) {
            if(val>=1 && val<=1000) this.val=val;
            else return false;
            return true;
        }

        public int getValue() {
            return this.val;
        }

    }

}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
