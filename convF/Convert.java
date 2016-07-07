package convF;

import java.nio.file.*;
import java.io.IOException;
import java.io.File;
import java.util.List;

public class Convert {

	public Convert() {}

	private String MUSIC_PATH;
	
	public void convertF(String MUSIC_PATH, List da0Path, String[] namePath) {
		this.MUSIC_PATH = MUSIC_PATH;
		create(da0Path, namePath);
	}

	private void create(List da0Path, String[] namePath) {
		File file = new File(MUSIC_PATH);
		if (!file.exists()) file.mkdirs();
		else if (!file.isDirectory()) file.mkdirs();
		for (int i = 0; i < namePath.length; i++) {
			file = new File(MUSIC_PATH + namePath[i]);
			if (!file.exists()) {
				try {
					copyF(da0Path.get(i).toString(), namePath[i]); 
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			else System.out.println("File " + namePath[i] + " already exist!");
		}
	}

	private void copyF(String da0File, String nameFile){
		Path source = Paths.get(da0File);
		Path target = Paths.get(MUSIC_PATH + nameFile);
		try {
			Files.copy(source, target);
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
}
