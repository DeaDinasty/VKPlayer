import searchF.Search;
import nameF.Name;
import java.util.List;
import java.util.ArrayList;

class main {
	public static void main (String[] args) throws Exception {
		final String PATH = "/home/deadboy/VKPlayer/da0_Files/";
		Search search = new Search();
		List files_da0 = search.getFind(PATH, "^(.)*.da0");
		System.out.println("Founded " + search.getFilesNumber() + " files.");
		System.out.println("Total size: " + (float) search.getTotalLength() / (1024*1024) + "Mb.");
		ArrayList files_names = new Name().getNames(PATH, files_da0);
		System.out.println("\nReal files names: ");
		for (int i = 0; i < files_names.size(); i++) System.out.println(files_names.get(i));
		System.out.println("\nSearching true name files: ");
		for (int i = 0; i < files_names.size(); i++) {
			System.out.println("File " + files_names.get(i) + (search.getFileExist(PATH + files_names.get(i))?" exist":" not exist"));
		}
	}
}
