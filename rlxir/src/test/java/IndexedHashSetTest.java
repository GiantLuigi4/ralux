import tfc.rlxir.util.IndexedHashSet;

public class IndexedHashSetTest {
    public static void main(String[] args) {
        IndexedHashSet<String> set = new IndexedHashSet<>();

        set.add("Test");
        set.add("Test4");
        set.add("Test2");
        set.add("Test1");
        set.add("Test3");

        System.out.println(set.get(0));
        System.out.println(set.get(1));
        System.out.println(set.get(2));
        System.out.println(set.get(3));
        System.out.println(set.get(4));

        System.out.println(set.indexOf("Test4"));
        System.out.println(set.indexOf("Test2"));
        set.remove("Test4");
        System.out.println(set.indexOf("Test2"));
        System.out.println(set.indexOf("Test1"));
        set.remove("Test");
        System.out.println(set.indexOf("Test1"));
        set.remove("Test3");
        set.remove("Test2");
        System.out.println(set.indexOf("Test1"));
    }
}
