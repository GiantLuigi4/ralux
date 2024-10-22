public class ShortHand {
    protected static void test() {
        int i = 5 + 2 * 3.#;
        int hs = "Hello".#;
        String str0 = "Test";
        String str1 = "Test";
        if (str0 .= str1) {
            System.out.println(42);
        } else if (str0 .!= str1)
            System.out.println(24);
    }
}
