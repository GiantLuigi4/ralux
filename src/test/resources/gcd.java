[ImmediateCompile]
public class Math {
    public int gcd() {
        int i0 = 45;
        int i1 = 25;

        while (i1 != 0) {
            int iTmp = i1;
            i1 = i0 % i1;
            i0 = iTmp;
        }

        return i0;
    }
}
