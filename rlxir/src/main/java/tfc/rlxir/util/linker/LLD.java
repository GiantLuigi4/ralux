package tfc.rlxir.util.linker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LLD extends Linker {
	List<String> libraries = new ArrayList<>();
	List<String> libPaths = new ArrayList<>();
	List<String> inputs = new ArrayList<>();
	String entrypoint;
	String output;
	String debug;
	
	boolean isRelease = true;
	
	@Override
	public Linker addLibrary(String lib) {
		libraries.add(lib);
		return this;
	}
	
	@Override
	public Linker addLibPath(String path) {
		libPaths.add(path);
		return this;
	}
	
	@Override
	public Linker entrypoint(String entrypoint) {
		this.entrypoint = entrypoint;
		return this;
	}
	
	@Override
	public Linker link(String output, String... inputs) {
		this.output = output;
		this.inputs = new ArrayList<>();
		this.inputs.addAll(Arrays.asList(inputs));
		return this;
	}
	
	@Override
	public Linker release(boolean b) {
		this.isRelease = b;
		return this;
	}
	
	@Override
	public Linker debug(String mode) {
		switch (mode) {
			case "strip":
				this.debug = "none";
				return this;
		}
		throw new RuntimeException("Unsupported mode: " + mode);
	}
}
