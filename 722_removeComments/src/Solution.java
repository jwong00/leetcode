import java.util.List;

class Solution {
    public List<String> removeComments(String[] source) {
        //CASES

        // line comment
        // start of line, delete whole line
        // mid of line, delete from cur_char to eol

        // block comment
        // set cur char to /*
        // for each line, find */
        // if not found, delete whole line, if found, remove char until 1 char after */

    }
}
