package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
	
	public void criaArquivoComConfigs() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("N�o foi poss�vel encontrar o seu arquivo de registros/configura��es!");
		System.out.println("Voc� deseja criar? 1 para SIM | 2 para N�O");
		int opcaoArq = leitor.nextInt();
		
		if(opcaoArq == 1) {
			criaArquivo();
			System.out.println("Okay, arquivo criado, vamos as configura��es...");
			System.out.println("Qual � seu nome?");
			String nome = leitor.next();
			System.out.println("Quanto � sua carga hor�ria?");
			String cargaHoraria = leitor.next();
			preencheConfigs(nome, cargaHoraria);
			System.out.println("Arquivo criado e configurado! Op��o liberada.");
		}
		
		if(opcaoArq != 2) {
			System.out.println("Okay! Retornando ao menu");
		}
		
		leitor.close();
	}
	
	public void preencheConfigs(String nome, String cargaHoraria) {
        try {
        	BufferedWriter writer = new BufferedWriter(new FileWriter("registros", true));
        	writer.write("Nome: " + nome);
            writer.newLine();
			writer.write("Carga hor�ria:" + cargaHoraria);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}	
	
}
