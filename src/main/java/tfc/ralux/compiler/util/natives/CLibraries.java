package tfc.ralux.compiler.util.natives;

import java.util.ArrayList;
import java.util.List;

public class CLibraries {
	public static List<String> necessaryLibraries(String platform) {
		List<String> libs = new ArrayList<>();
		
		switch (platform) {
			case "windows" -> {
				libs.add("vcruntime");
				libs.add("ucrt");
				libs.add("msvcrt");
//	            libs.add("libcmt");
			}
			default -> throw new RuntimeException("TODO: Non Windows builds");
		}
		
		return libs;
	}
}
