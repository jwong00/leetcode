import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));

    }
    public List<List<String>> findDuplicate(String[] paths) {

        HashMap<String,List<String>> files_unique = new HashMap<>();
        //process strings, foreach str:
        for(int i=0;i<paths.length;i++) {
            String[] path = paths[i].split("\\s");

            System.out.println("DIRECTORY: "+path[0]);
            System.out.println("FILES: ");

            String root = path[0] + "/";

            for(int j=1;j<path.length;j++) {
                System.out.println(path[j]);
                int l_paren=0,r_paren=path[j].length()-1;
                char[] file = path[j].toCharArray();
                while(file[l_paren]!='(' && l_paren<r_paren) l_paren++;
                //filename
                String filename = path[j].substring(0,l_paren);
                System.out.println(filename);
                //content
                String content = path[j].substring(l_paren+1,r_paren);
                System.out.println(content);

                if(!files_unique.containsKey(content)) {
                    files_unique.put(content,new ArrayList<String>());
                }

                files_unique.get(content).add(root+filename);
            }
        }

        //process duplicates
        ArrayList<List<String>> duplicates = new ArrayList<>();
        for(String data : files_unique.keySet()) {
            if(files_unique.get(data).size() > 1) {
                duplicates.add(files_unique.get(data));
            }
        }
        return duplicates;


    }
}
