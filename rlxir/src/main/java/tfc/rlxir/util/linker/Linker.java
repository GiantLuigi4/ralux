package tfc.rlxir.util.linker;

public abstract class Linker {
	public abstract Linker addLibrary(String lib);
	
	public abstract Linker addLibPath(String path);
	
	public abstract Linker entrypoint(String main);
	
	public abstract Linker link(String output, String... inputs);
	
	public abstract Linker release(boolean b);
	
	public abstract Linker debug(String strip) ;
}
