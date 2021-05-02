package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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
	
	public void preencheConfigs(String nome, String cargaHoraria) {
        try {
        	BufferedWriter writer = new BufferedWriter(new FileWriter("registros", true));
        	writer.write("Nome: " + nome);
            writer.newLine();
			writer.write("Carga horária:" + cargaHoraria);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}	
	
}
