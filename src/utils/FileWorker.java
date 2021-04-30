package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileWorker {
	
	Scanner leitor = new Scanner(System.in);
	
	public FileReader criaArquivo() {
    	File file = new File("registros.txt");
    	try {
			file.createNewFile();
			FileReader reader = new FileReader("registros.txt");
			return reader;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public FileReader procuraArquivo() {
		try {
	        FileReader reader = new FileReader("registros.txt");
	        
	        return reader;
	    } catch (IOException e) {
	    	
	        if(e.getClass().getName().indexOf("FileNotFoundException") > -1) {
	        	System.out.println("Voc� n�o tem um arquivo de registros/configura��es criado...");
	        	System.out.println("Deseja criar? Voc� ser� redirecionado para a configura��o de um novo arquivo.");
	        	System.out.println("1 para SIM / 2 para N�O");
	        	int opcaoConfig = leitor.nextInt();
	        	if(opcaoConfig == 1) {
	        		return criaArquivo();
	        	} else {
	        		return null;
	        	}
	        }
	        
	    }
		
		leitor.close();
		return null;
	}
	
}
