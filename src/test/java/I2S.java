public class I2S {
    public static void main(String[] args) {
        for (int b = 0; b < 100; b += 1) {
            for (int a = 0; a < 100; a += 1) {
                if (a > 50) continue;
                System.out.println(a);
            }
        }
    }
}
