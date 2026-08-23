package tfc.rlxir.util;

import java.io.IOException;
import java.nio.file.Path;

public class ProgramLocator {
	public static Path find(String name) {
		String cmd = "where " + name;
		Process p = null;
		try {
			p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
			
			byte[] data = p.getInputStream().readAllBytes();
			return Path.of(new String(data).trim());
		} catch (IOException | InterruptedException e) {
			return null;
		}
	}
}
