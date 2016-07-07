import searchF.Search;
import nameF.Name;
import convF.Convert;
import java.util.*;

class main {
	public static void main (String[] args) throws Exception {
		final String PATH = "/home/deadboy/VKPlayer/da0_Files/";
		final String MUSIC_PATH = "/home/deadboy/VKPlayer/Music/";
		Search search = new Search();
		List files_da0 = search.getFind(PATH, "^(.)*.da0"); //List da0 name files
		System.out.println("Founded " + search.getFilesNumber() + " files.");
		System.out.println("Total size: " + (float) search.getTotalLength() / (1024*1024) + "Mb.");
		Name name = new Name();
		String[] files_names = name.getNames(files_da0); //String[] names of files
		System.out.println("\nReal files names: ");
		for (String files : files_names) System.out.println(files);
		System.out.println("\nSearching true name files: ");
		if (!search.getPathExist(MUSIC_PATH, true)) System.out.println("Files not found!");
		else for (String files : files_names) System.out.println("File " + files + 
				(search.getFileExist(MUSIC_PATH + files)?" exist":" not exist"));
		long[] dates = search.getFilesDate(files_da0); //long[] dates of files modificated
		for (int i = 0; i < dates.length; i++) 
			System.out.println(dates[i] + "\t" + files_da0.get(i));
		name.goQuickSort(dates, files_da0);
		System.out.println();
		dates = name.getArray();
		for (int i = 0; i < dates.length; i++) 
			System.out.println(dates[i] + "\t" + files_da0.get(i));
		new Convert().convertF(MUSIC_PATH, files_da0, files_names);
	}
}
