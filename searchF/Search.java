package searchF;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {

	public Search() {}

	private Pattern p = null;
	private Matcher m = null;
	private long totalLength = 0;
	private long filesNumber;

	public List getFind(String PATH, String mask) throws Exception {
		return find(PATH, mask);
	}

	public long getTotalLength() {
		return totalLength;
	}

	public long getFilesNumber() {
		return filesNumber;
	}

	private boolean accept(String name) {
		m = p.matcher(name);
		if (m.matches()) return true;
		else return false;
	}

	private List find(String startPATH, String mask) throws Exception {
		File directory = new File(startPATH);
		if (!directory.exists()) throw new Exception("PATH not exist!");
		p = Pattern.compile(mask, Pattern.CASE_INSENSITIVE);
		filesNumber = 0;
		totalLength = 0;
		ArrayList res = new ArrayList(1000);
		searchFiles(directory, res);
		return res;
	}

	private void searchFiles(File directory, List res) {
		File[] list = directory.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isFile()) {
				if (accept(list[i].getName())) {
					filesNumber++;
					totalLength +=list[i].length();
					res.add(list[i]);
				}
			}
		}
	}
}
