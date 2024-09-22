import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import tfc.ralux.compiler.optim.QuickPass;
import tfc.ralux.compiler.parse.RaluxLexer;
import tfc.ralux.compiler.parse.RaluxParser;
import tfc.ralux.compiler.util.TreeNode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.Future;

public class ParserTest {
    static final String[] TEST_FILES = new String[]{
            "fl.java",
            "gcd.java",
            "str.java",
            "MainTest.java",
            "calls.java",
            "sh.java"
    };

    public static void main(String[] args) {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : looks) {
            System.out.println(info.getName() + ": " + info.getClassName());
        }

        try {
            new File("dmp").mkdir();
        } catch (Throwable ignored) {
        }

        Color BG = new Color(30, 30, 30);
        Color BUTTON_BG = new Color(76, 80, 82);
        Color FG = new Color(224, 224, 224);
        Color TC = new Color(128, 128, 128);
        Color BORDER = new Color(89, 91, 93).brighter();

        try {
            // Set the desired Look and Feel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

            UIManager.put("Panel.background", BG);
            UIManager.put("Panel.foreground", FG);
//            UIManager.put("Viewport.background", BG);
            UIManager.put("ScrollPane.background", BG);

            UIManager.put("Slider.background", BG);
            UIManager.put("Slider.foreground", TC);

            UIManager.put("Label.background", BG);
            UIManager.put("Label.foreground", FG);

            UIManager.put("Tree.background", BG);
            UIManager.put("Tree.foreground", FG);
            UIManager.put("Tree.textBackground", BG);
            UIManager.put("Tree.textForeground", FG);
            UIManager.put("Tree.selectionBackground", new Color(100, 150, 255).brighter().brighter()); // Selected background
            UIManager.put("Tree.selectionForeground", Color.BLACK); // Selected text color

            Border outerBorder = BorderFactory.createLineBorder(BORDER, 1); // Outer border
            Border paddingBorder = BorderFactory.createEmptyBorder(5, 10, 5, 10); // Padding
            Border combinedBorder = BorderFactory.createCompoundBorder(outerBorder, paddingBorder);
            UIManager.put("Button.background", BUTTON_BG);
            UIManager.put("Button.foreground", FG);
            UIManager.put("Button.border", combinedBorder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String testFile : TEST_FILES) {
            CharStream stream;
            try {
                String strng = new String(ParserTest.class.getClassLoader().getResourceAsStream(testFile).readAllBytes());
                stream = CharStreams.fromString(strng);
            } catch (Throwable err) {
                System.err.println("wat");
                throw new RuntimeException(err);
            }
            RaluxLexer lexer = new RaluxLexer(stream);
            RaluxParser parser = new RaluxParser(new CommonTokenStream(lexer));

//            parser.addErrorListener(new CustomErrorListener());
//            parser.setErrorHandler(new DefaultErrorStrategy());

            RaluxParser.FileContext tree = parser.file();
            if (tree.children == null)
                return;

            System.out.println(tree.toStringTree());
            Future<JFrame> frameFuture = Trees.inspect(tree, parser);

            try {
                frameFuture.get();
            } catch (Throwable err) {
            }

            TreeNode root = new TreeNode(tree);
            QuickPass pass = new QuickPass();
            pass.optimize(root);

            StringBuilder textify = new StringBuilder();
            root.forEachRecursive(t -> {
                textify
                        .append("\t".repeat(t.getDepth()))
                        .append(t.getText(parser))
                        .append("\n");
            });
            try {
                FileOutputStream fos = new FileOutputStream("dmp/" + testFile + ".rtree");
                fos.write(textify.toString().getBytes());
                fos.flush();
                fos.close();
            } catch (Throwable ignored) {
            }
        }
    }

    static class CustomErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line, int charPositionInLine,
                                String msg, RecognitionException e) {
            // Print a detailed error message
            System.err.println("Error at line " + line + ", position " + charPositionInLine + ": " + msg);
            if (offendingSymbol instanceof Token)
                System.err.println(offendingSymbol + " " + recognizer.getTokenNames()[((Token) offendingSymbol).getType()]);
            else
                System.err.println(offendingSymbol);

            // Optionally: throw an exception to halt parsing
            throw new ParseCancellationException("Parse error at line " + line + ": " + msg);
        }
    }
}
