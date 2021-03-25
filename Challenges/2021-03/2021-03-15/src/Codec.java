import java.util.HashMap;
import java.util.Random;

public class Codec {
    public static void main(String[] args) {
        Codec c = new Codec();
        System.out.println(c.decode(c.encode("test")));
        System.out.println(c.decode("23984_23432"));

    }

    private int count = 0;
    private HashMap<String,String> db;
//    private char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
//    private int max = map.length;
    private int tinyLength = 7;

    public Codec() {
        db = new HashMap<>();

    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Random r = new Random();

        StringBuilder s = new StringBuilder();
        s.append(count++);
        s.append("_");
        for(int i=0;i<tinyLength;i++) {
            s.append(r.nextInt(10));
        }

        db.put(s.toString(),longUrl);

        return s.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String s = db.get(shortUrl);

        return s==null ? "Url not found!" : s;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
