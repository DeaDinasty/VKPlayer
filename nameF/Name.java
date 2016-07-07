package nameF;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.Collections;
import java.io.*;

public class Name {

	public Name() {}

	private final Pattern p = Pattern.compile("^(.)*TPE1");
	private long arr[];
	private List da0files;

	public String[] getNames(List FILES) {
		return NamesFromFile(FILES);
	}

	public void goQuickSort(long array[], List da0) {
		da0files = da0;
		arr = array;
		quickSort(0, arr.length - 1);
	}

	public long[] getArray() {
		return arr;
	}

	private String[] NamesFromFile(List FILES) {
		String[] names = new String[FILES.size()];
		for (int i = 0; i < FILES.size(); i++) {
			try (BufferedReader reader = new BufferedReader(new FileReader(FILES.get(i).toString()))){
				String s, cleanName = "";
				s = reader.readLine();
				s = reader.readLine();
				s = s.substring(15);
				Matcher m = p.matcher(s);
				if (m.find()) 
					s = m.group().substring(0, m.group().length() - 5);
				for (int a = 0; a < s.length() - 1; a++) {
					if (s.charAt(a) != s.charAt(s.length() - 1)) 
						cleanName += s.charAt(a);
				}
				names[i] = cleanName;
			} catch(IOException e) {
				System.out.println("File not found!");
			}
		}

		return names;
	}

	private int partition(int left, int right) {
		int i = left, j = right;
		long tmp;
		long pivot = arr[(left + right) / 2];      
		while (i <= j) {
			while (arr[i] < pivot) i++;
			while (arr[j] > pivot) j--;
			if (i <= j) { 
				Collections.swap(da0files, i, j);
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			 }
		 };
		return i;
	}
	 
	private void quickSort(int left, int right) {
		int index = partition(left, right);
		if (left < index - 1) quickSort(left, index - 1);
		if (index < right) quickSort(index, right);
	}
}
