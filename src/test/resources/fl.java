public class Test {
    public void ifs() {
        int ix = 0;
        int a = 32;
        if (a == 5 + 6) {
            List<?> lv = new List<>(i);
            if (a == 5 + 6)
                ix = 5;
            int ie = 5;
        }
    }

    public void test() {
        float ioDA = 3+5/(2-4*3+2)+5**2/2;
        int idAK = 4**ioDA;
        List<T instanceof Object> list = new List<T instanceof Object>();
        ioDA += 4.0f;
        idAK += 4i;
        long uv = 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9 * 9;
        int aTest = ioDR += 5;

        for (int i = 0; i < 100; i++) {
        }

        tfc.ralux.util.List<?> li = new List<tfc.ralux.core.String>();

        i=0;{a=5;}
        // this is a comment!
        unsigned half k = 2.5h;
        /*
         * this is a block comment...
         * for (int i = 0; i < 100; i++) {
         * }
         */

        int iv = k;

        do {
            int kap = 5;
            kap -= 3;
            iv -= 1;
        } while (iv > 0)

        boolean b = false;

        int 9ix32 = 0;
        int 9i9 = 0;
        int 9id = 9i;
    }

    public void inferredSemis() {
        %infer_semicolon%
        int i = 5 int i1 = i + 3
        i1 -= i * 3l
        %enforce_semicolon%
    }

    public void arrays() {
        int[500] array = null;
    }

    public void labeledLoop() {
        label:
        for (int i = 0; i < 100; i++) {
            break label;
        }

        %infer_semicolon%
        label1:
        for (int i = 0; i < 100; i++) {
            // TODO: there's a bug in the parser that makes omitting the ; invalid here
            break label1;
            int i = 5
            break; int b = 4
        }
        %enforce_semicolon%
    }
}
