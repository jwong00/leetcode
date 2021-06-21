import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeComments(new String[] {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
        System.out.println(s.removeComments(new String[]{"a/*comment", "line", "more_comment*/b"}));


    }
    public List<String> removeComments(String[] source) {
        List<String> clean = new ArrayList<String>();

        boolean IN_BLOCK_COMMENT = false;
        boolean IN_LINE_COMMENT = false;

        for(String line : source) {

            StringBuilder buf = new StringBuilder();

            // process line, char-by-char
            for(int cur_char=0;cur_char<line.length();cur_char++) {

                if(cur_char<line.length() && line.charAt(cur_char) == '/') {
                    if(line.charAt(cur_char + 1) == '/') IN_LINE_COMMENT = true;
                    if(line.charAt(cur_char + 1) == '*') IN_BLOCK_COMMENT = true;

                    /*
                        skip second char of comment signifier, so we don't double count
                        it as part of a block comment close
                     */
                    cur_char++;
                }


                //exit comment
                if(cur_char<line.length() && line.charAt(cur_char) == '*' && line.charAt(cur_char + 1) == '/') {
                    IN_BLOCK_COMMENT = false;

                    cur_char +=2;
                }


                if(cur_char <line.length() && !IN_BLOCK_COMMENT && !IN_LINE_COMMENT) buf.append(line.charAt(cur_char));
            }

            //exit LINE COMMENT state after finishing a line
            IN_LINE_COMMENT = false;

            //append line-buffer to clean source file
            if(buf.length()>0) clean.add(buf.toString());

        }

        return clean;



    }
}
