package tfc.ralux.compiler.util.console;

public abstract class Console {
	public void write(Level level, Source source, Stage stage, String text) {
		write(level, source, stage.name(), text);
	}
	
	public abstract void write(Level level, Source source, String stage, String text);
	
	public enum Level {
		FATAL, ERROR, WARNING, INFO, DEBUG;
	}
	
	public enum Source {
		FRONTEND, IR, TRANSLATOR, BACKEND
	}
	
	public enum Stage {
		COMPILE, TRANSLATE, OPTIMIZE, LINK
	}
}
