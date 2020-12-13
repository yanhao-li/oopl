import java.util.*;
class SortedList<T extends Comparable<T>> extends ArrayList<T> implements Comparable<SortedList<T>>{
    @Override
    public int compareTo(SortedList<T> sortedList) {
        return 0;
    }

    @Override
    public boolean add(T el) {
        for (int i = 0; i < this.size(); i++) {
            // the current element is larger than el
            if (this.get(i).compareTo(el) >= 0) {
                super.add(i, el);
                return true;
            }
        }
        return super.add(el);
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < this.size(); i++) {
            str += this.get(i).toString();
            if (i < this.size() - 1) {
                str += ", ";
            }
        }

        return "[" + str + "]";
    }

}

public class Part1 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(1);
        System.out.println(nums.toString());
    }
}
