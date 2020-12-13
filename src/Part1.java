import java.util.*;
class SortedList<T extends Comparable<T>> extends ArrayList<T> implements Comparable<SortedList<T>>{
    @Override
    public int compareTo(SortedList<T> sortedList) {
        int i;
        for (i = 0; i < this.size() && i < sortedList.size(); i++) {
            if (this.get(i).compareTo(sortedList.get(i)) < 0) {
                return -1;
            } else if (this.get(i).compareTo(sortedList.get(i)) > 0) {
                return 1;
            } else {
                continue;
            }
        }

        if (i == this.size() && i < sortedList.size()) {
            return -1;
        } else if (i < this.size() && i == sortedList.size()) {
            return 1;
        }

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

class A implements Comparable<A> {
    Integer value;

    A(Integer x) {
        this.value = x;
    }

    public int compareTo(A el) {
        if (this.value < el.value) {
            return -1;
        } else if (this.value > el.value) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return "A<" + this.value + ">";
    }
}

class B extends A {
    Integer x;
    Integer y;
    B(Integer x, Integer y) {
        super(x + y);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "B<" + this.x + "," + this.y + ">";
    }
}

public class Part1 {
    static <T extends Comparable<T>> void addToSortedList(SortedList<T> L, T z) {
        L.add(z);
    }

    static void test() {
        SortedList<A> c1 = new SortedList<A>();
        SortedList<A> c2 = new SortedList<A>();
        for(int i = 35; i >= 0; i-=5) {
            addToSortedList(c1, new A(i));
            addToSortedList(c2, new B(i+2,i+3));
        }

        System.out.print("c1: ");
        System.out.println(c1);

        System.out.print("c2: ");
        System.out.println(c2);

        switch (c1.compareTo(c2)) {
            case -1:
                System.out.println("c1 < c2");
                break;
            case 0:
                System.out.println("c1 = c2");
                break;
            case 1:
                System.out.println("c1 > c2");
                break;
            default:
                System.out.println("Uh Oh");
                break;
        }

    }

    public static void main(String[] args) {
        test();
    }
}
