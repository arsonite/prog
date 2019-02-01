package pr1.a11;

import java.io.FileFilter;
import java.io.File;

public class OnlyFiles implements FileFilter {

	public boolean accept(File dir) {
		return dir.isFile();
	}

}