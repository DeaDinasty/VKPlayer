package nameF;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.io.*;

public class Name {
	public Name() {}
	private final Pattern p = Pattern.compile("^(.)*TPE1");

	public ArrayList getNames(String PATH, List FILES) {
		return NamesFromFile(PATH, FILES);
	}

	private ArrayList NamesFromFile(String PATH, List FILES) {
		ArrayList names = new ArrayList();
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
				names.add(cleanName);
			} catch(IOException e) {
				System.out.println("File not found!");
			}
		}

		return names;
	}
}
