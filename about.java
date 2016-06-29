import java.io.*;

class About{
	public static void main (String[] args) {
		final String PATH = "/home/deadboy/VKPlayer/";
		final String files[] = {"-77288583_365257942.da0", "-77288583_365257963.da0", "-77288583_365257996.da0", 
			"-77288583_365258037.da0", "-77288583_365258096.da0"};
		/*
		File Folder = new File(PATH);
		File[] files = Folder.listFiles();
		for (File file : files) System.out.println(file);
		*/
		for (int a = 0; a < 5; a++) {
			try (BufferedReader reader = new BufferedReader(new FileReader(PATH + files[a]))) {
				String s;
				for (int i = 0; i < 2; i++) {
					s = reader.readLine();

					System.out.println(s + "\n");
				}
			} catch(IOException e) {
				System.out.println("File not found!");
			}
		}
	}
} 
