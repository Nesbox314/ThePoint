package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import utils.Reader;

public class Configurations {
	
	Reader reader = new Reader();

	public void menu() {
		System.out.println("-----------------------CONFIGURA��ES-----------------------");
		System.out.println("O que voc� deseja fazer por aqui?");
		System.out.println("1 - Ler as configura��es");
		System.out.println("2 - Alterar as configura��es");
		System.out.println("3 - Voltar ao menu");
		int opcao = reader.getLeitor().nextInt();
		
		try {
			
			if(opcao == 1) {
				File file = new File("registros.txt");
				  
			    BufferedReader br;
			    String st;
			    br = new BufferedReader(new FileReader(file));
			    st = br.readLine();
			    System.out.println(st);
			    st = br.readLine();
			    System.out.println(st);
			    st = br.readLine();
			    System.out.println(st);
			    br.close();
			}
			
			if(opcao == 2) {
				//alterar as configura��es
			}
	
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//leitor.close();
	}
	
	public void lerConfigs(){
		
	}
	
	public void alterarConfigs(){
		
	}
}
