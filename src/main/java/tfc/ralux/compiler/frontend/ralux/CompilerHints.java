package tfc.ralux.compiler.frontend.ralux;

import tfc.rlxir.comphints.builtin.ExternHint;

import java.util.List;

public class CompilerHints {
    private static <T> void parseExtern(List<T> compHints, String asText) {
        String[] split = asText.split(" ");
        if (split.length == 3) {
            compHints.add((T) new ExternHint(
                    split[1],
                    split[2]
            ));
        } else if (split.length == 2) {
            compHints.add((T) new ExternHint(
                    split[1]
            ));
        } else throw new RuntimeException("ERROR");
    }

    public static <T> void parseCompHint(List<T> compHints, String asText) {
        if (asText.startsWith("Extern")) {
            parseExtern(compHints, asText);
        } else
            throw new RuntimeException("TODO");
    }
}
