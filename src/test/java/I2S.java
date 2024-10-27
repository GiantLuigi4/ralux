public class I2S {
    public static void main(String[] args) {
        System.out.println(toString(0));
        System.out.println(toString(1));
        System.out.println(toString(10));
        System.out.println(toString(-10));
        System.out.println(toString(-1));
        System.out.println(toString(Integer.MAX_VALUE));
        System.out.println(toString(Integer.MIN_VALUE));
    }

    public static String toString(int integer) {
        if (integer == 0) {
            return "0";
        } else {
            char[] buf = new char[11];
            boolean condPN = integer < 0;

            int index = 0;
            while (integer != 0) {
                int quotient = integer / 10;
                byte rem = (byte) (integer - (quotient * 10));
                if (condPN) rem = (byte) -rem;
                integer = quotient;
                buf[index] = (char) (rem + '0');
                index++;
            }

            if (condPN)
                buf[index] = '-';
            else index -= 1;

            for (int i = 0; i < (index + 1) / 2; i++) {
                char cl = buf[i];
                char cr = buf[index - i];
                buf[index - i] = cl;
                buf[i] = cr;
            }
            return new String(buf, 0, index + 1);
        }
    }
}
