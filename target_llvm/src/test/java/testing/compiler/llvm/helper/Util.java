package testing.compiler.llvm.helper;

import org.bytedeco.javacpp.BytePointer;

import java.nio.charset.StandardCharsets;

public class Util {
    public static int log4(int value) {
        return 16 - (Integer.numberOfLeadingZeros(value) >> 1);
    }

    public static int log2(int value) {
        return 32 - Integer.numberOfLeadingZeros(value);
//        int index = 0;
//        while (value != 0) {
//            value = value >> 1;
//            index += 1;
//        }
//        return index;
    }

    public static BytePointer memUTF(String text) {
        byte[] data = text.getBytes(StandardCharsets.UTF_8);
        BytePointer buffer = new BytePointer(data.length + 1);
        buffer.put(data).position(0).limit(buffer.capacity());
        buffer.put(buffer.capacity() - 1, (byte) 0);
        return buffer;
    }

    public static String string(BytePointer target) {
        String txt = "";
        int i = 0;
        while (target.get(i) != 0) {
            txt += (char) target.get(i);
            i++;
        }
        return txt;
    }
}
