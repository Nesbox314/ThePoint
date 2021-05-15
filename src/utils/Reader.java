package utils;

import java.util.Scanner;

public class Reader {
	
	private Scanner leitor = new Scanner(System.in);

	public Scanner getLeitor(){
		return leitor;
	}
	
	public void closeLeitor(){
		leitor.close();
	}
}
