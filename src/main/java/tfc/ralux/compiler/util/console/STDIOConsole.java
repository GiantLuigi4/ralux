package tfc.ralux.compiler.util.console;

public class STDIOConsole extends Console {
	@Override
	public void write(Level level, Source source, String stage, String text) {
		System.out.print("[" + level + "] " + source + "::" + stage + " " + text);
	}
}
