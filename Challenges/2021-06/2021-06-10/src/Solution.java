import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    public static void main(String[] args) {
        MyCalendar m = new MyCalendar();
        System.out.println(m.book(10,20));
        System.out.println(m.book(15,25));
        System.out.println(m.book(20,30));

    }

    List<Integer[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<Integer[]>();
    }

    public boolean book(int start, int end) {
        if(calendar.isEmpty()) {
            calendar.add(new Integer[] {start,end});
            return true;
        }

        //add if not overlap
        for(int i=0;i<calendar.size();i++) {
            Integer[] t = calendar.get(i);
            if(t[0] < end && start < t[1]) return false;
        }
        calendar.add(new Integer[] {start,end});
        return true;

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
