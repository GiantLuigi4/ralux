package ir_to_ir;

public class BehaviorTest {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(i);
        System.out.println(i += 1);
        System.out.println(i);
        System.out.println(i++);
        System.out.println(i);
        System.out.println(++i);

        System.out.println();

        i = 0;
        i = i++;
        i++;
        System.out.println(i);
    }
}
