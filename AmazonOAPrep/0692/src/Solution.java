import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"},2));
        System.out.println(s.topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"},4));
    }
    public List<String> topKFrequent(String[] words, int k) {

        //map word to an entry
        //entry is a k,v pair that maps word (k) to its priority (v)
        HashMap<String, Integer> words_h = new HashMap<>();

        //order with respect to the count of occurrences of the string
        PriorityQueue<String> words_q =
                new PriorityQueue<>(words.length,(a,b)->words_h.get(b)-words_h.get(a));

        //add to both hashmap and pqueue if not in hashmap
        for(String word : words) {
            //if in hash AND pq
            if(words_h.containsKey(word)) words_q.remove(word);
            words_h.put(word,words_h.getOrDefault(word,0)+1);
            words_q.offer(word);
        }

        ArrayList<String> ans = new ArrayList<>();
        while(k>0) {
            ans.add(words_q.poll());
            k--;
        }
        return ans;
    }
}
