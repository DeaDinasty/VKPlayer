import java.util.regex.*;
import java.io.*;

class About{
	public static void main (String[] args) {
		final String PATH = "/home/deadboy/VKPlayer/";
		final String files[] = {"-77288583_365257942.da0", "-77288583_365257963.da0", "-77288583_365257996.da0", 
			"-77288583_365258037.da0", "-77288583_365258096.da0"};
		String file_names[] = new String[files.length];
		/*
		File Folder = new File(PATH);
		File[] files = Folder.listFiles();
		for (File file : files) System.out.println(file);
		*/
		for (int a = 0; a < 5; a++) {
			try (BufferedReader reader = new BufferedReader(new FileReader(PATH + files[a]))) {
				String s, cleanLine = "";
				s = reader.readLine();
					s = reader.readLine();
					s = s.substring(15);
					Pattern p = Pattern.compile("^(.)*TPE1");
					Matcher m = p.matcher(s);
					if (m.find()) 
						s = m.group().substring(0, m.group().length() - 5);
					for (int i = 0; i < s.length()-1; i++) 
						if (s.charAt(i) != s.charAt(s.length()-1)) cleanLine += s.charAt(i);
					file_names[a] = cleanLine;
			} catch(IOException e) {
				System.out.println("File not found!");
			}
		} //Можно объединить циклы
		for (int i = 0; i < file_names.length; i++) {
			String name = file_names[i] + ".mp3";
			System.out.println(PATH + name);
			File newFile = new File(PATH + name);
			try {
				newFile.createNewFile();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
} 
