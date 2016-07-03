import searchF.Search;
import nameF.Name;
import java.util.List;
import java.util.ArrayList;

class main {
	public static void main (String[] args) throws Exception {
		final String PATH = "/home/deadboy/VKPlayer/da0_Files/";
		List files_da0 = new Search().getFind(PATH, "^(.)*.da0");
		ArrayList files_names = new Name().getNames(PATH, files_da0);
		for (int i = 0; i < files_names.size(); i++) System.out.println(files_names.get(i));
	}
}
