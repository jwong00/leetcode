import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeComments(new String[] {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"});

    }
    public List<String> removeComments(String[] source) {
        //CASES

        boolean IN_BLOCK_COMMENT = false;
        boolean IN_LINE_COMMENT = false;

        for(String line : source) {

            StringBuilder buf = new StringBuilder();

            // process line, char-by-char
            for(int cur_char=0;cur_char<line.length();cur_char++) {


                if(line.charAt(cur_char) == '/') {
                    if(line.charAt(cur_char + 1) == '/') IN_LINE_COMMENT = true;
                    if(line.charAt(cur_char + 1) == '*') IN_BLOCK_COMMENT = true;
                }

                if(line.charAt(cur_char) == '*' && line.charAt(cur_char + 1) == '/') IN_BLOCK_COMMENT = false;

                if(!IN_BLOCK_COMMENT && !IN_LINE_COMMENT) buf.append(line.charAt(cur_char));
            }

            //exit LINE COMMENT state after finishing a line
            IN_LINE_COMMENT = false;



            // line comment

            // start of line, delete whole line
            // mid of line, delete from cur_char to eol

            // block comment
            // set cur char to /*
            // for each line, find */
            // if not found, delete whole line, if found, remove char until 1 char after */
        }

    }
}
