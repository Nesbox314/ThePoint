package utils;

import java.io.File;
import java.io.IOException;

public class FileWorker {
	
	public Boolean verificaExistenciaArquivo() {
		File file = new File("registros");
		
		return file.exists();
	}
	
	public File criaArquivo() {
		File file = new File("registros");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}
	
	
	
}
