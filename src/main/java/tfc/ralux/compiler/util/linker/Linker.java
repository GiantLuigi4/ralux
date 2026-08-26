package tfc.ralux.compiler.util.linker;

public abstract class Linker {
	public abstract Linker addLibrary(String lib);
	
	public abstract Linker addLibPath(String path);
	
	public abstract Linker entrypoint(String main);
	
	public abstract Linker link(String output, String... inputs);
	
	public abstract Linker release(boolean b);
	
	public abstract Linker debug(String strip) ;
	
	public abstract Linker protectDataExecution(boolean value);
	
	public abstract Linker useLTO(boolean value);
	
	public abstract Linker merge(String section);
	
	public abstract Linker verbose(boolean value);

	public abstract Linker allowRelocations(boolean value);
	
	public abstract Linker incrementalLink(boolean value);
	
	public abstract Linker enforceControlFlow(boolean value);
	
	public abstract Linker opt(String option, boolean value);
	
	public abstract String buildCommand();
	
	public abstract boolean execute();
}
