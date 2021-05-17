package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import utils.FileWorker;
import utils.Reader;

public class Configurations {
	
	Reader reader = new Reader();
	FileWorker fileWorker = new FileWorker();

	public void menu() {
		System.out.println("-----------------------CONFIGURAÇÕES-----------------------");
		System.out.println("O que você deseja fazer por aqui?");
		System.out.println("1 - Ler as configurações");
		System.out.println("2 - Alterar as configurações");
		System.out.println("3 - Voltar ao menu");
		int opcao = reader.getLeitor().nextInt();

		try {
			File file = new File("configuracoes.txt");
			BufferedReader br;
			br = new BufferedReader(new FileReader(file));
			
			if(opcao == 1) {
			    String stringConfigs;
			    stringConfigs = br.readLine();
			    System.out.println(stringConfigs);
			    stringConfigs = br.readLine();
			    System.out.println(stringConfigs);
			    stringConfigs = br.readLine();
			    System.out.println(stringConfigs);
			}
			
			if(opcao == 2) {
				fileWorker.limpaArquivoConfiguracoes();
				System.out.println("Okay, vamos alterar os dados...");
				System.out.println("Digite o seu nome:");
				String nome = reader.getLeitor().next();
				System.out.println("Digite a sua carga horária:");
				String cargaHoraria = reader.getLeitor().next();
				fileWorker.preencheConfigs(nome, cargaHoraria);
			}
	
			br.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//leitor.close();
	}
	
	public String[] getDadosConfiguracoes() {
		String[] dados = {"null", "null"};
		try {
			File file = new File("configuracoes.txt");
			BufferedReader br;
			br = new BufferedReader(new FileReader(file));
			String stringConfigs;
			stringConfigs = br.readLine();
		    stringConfigs = br.readLine();
		    String nome = stringConfigs;
		    stringConfigs = br.readLine();
		    String cargaHoraria = stringConfigs;
		    dados[0] = nome.substring(nome.indexOf("|") + 1, nome.lastIndexOf("|"));
		    dados[1] = cargaHoraria.substring(cargaHoraria.indexOf("|") + 1, cargaHoraria.lastIndexOf("|"));
		    
		    br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dados;
	}
	
}
