import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.simplifyPath("/home/././a/b/../../");
        s.simplifyPath("/home/./a/b/../");
        s.simplifyPath("/");
        s.simplifyPath("/home//foo");
        s.simplifyPath("/..");

    }
    public String simplifyPath(String path) {
        String[] absolutePath = path.split("/");

        /**
         * Build canonicalPath in parts
         * index 0 == root
         * index 1 is start
         * if ".", skip element
         * if ".." remove last added element from canonicalPath
         * else add to canonicalPath
         **/
        ArrayDeque<String> canonicalPath = new ArrayDeque<String>();
        for(int i = 1; i < absolutePath.length; i++) {
            if(absolutePath[i].equals("."));
            else if (absolutePath[i].equals(""));

            else if( absolutePath[i].equals("..") ) {
                if(canonicalPath.size() > 0) canonicalPath.removeLast();
            }
            else canonicalPath.add(absolutePath[i]);
        }

        String canonicalPathStr = "";

        if(canonicalPath.isEmpty()) canonicalPathStr = "/";
        else while(!canonicalPath.isEmpty()) canonicalPathStr += "/"+canonicalPath.poll();


        return canonicalPathStr;
    }
}
