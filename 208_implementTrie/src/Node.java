public class Node {

    Node[] index;
    char value;

    /*
    * 'A' 065
    * 'Z' 090
    * 'a' 097
    * 'z' 122
    * */
    static int index_length = 'z'-'A';

    public Node(char c) {
        this.value = c;
        index = new Node[Node.index_length];
    }

    public Node() {
        index = new Node[Node.index_length];
    }

}
