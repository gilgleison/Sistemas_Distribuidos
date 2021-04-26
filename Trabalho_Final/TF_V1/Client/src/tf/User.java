package tf;

import java.util.Scanner;

public class User {
	public static void main(String[] args) {
//		TCPClient client = new TCPClient();
		String sel="";
		Scanner teclado = new Scanner(System.in); 
		while(true){
			TCPClient client = new TCPClient();
			System.out.println("Escolha a opção desejada: \n"
								+ "1 : Adicionar Aluno \n"
								+ "2 : Adicionar Disciplina \n"
								+ "3 : Matricular \n"
								+ "4 : Desmatricular \n"
								+ "5 : Remover Aluno \n"
								+ "6 : Mostrar Disciplinas \n"
								+ "7 : Mostrar Alunos \n"
								+ "8 : Mostrar Disciplina \n"
								+ "9 : Mostrar Aluno \n");
							
			sel = teclado.nextLine();
			String envia[]= new String[2];

			switch (sel){
				case "1": 
					System.out.println("Nome do Aluno: ");
					envia[0] = "";
					envia[1] = teclado.nextLine();
					System.out.println(client.doOperation("Repositorio", 1, envia));
					break;
				case "2": 
					System.out.println("ID da Disciplina: ");
					envia[1] = "";
					envia[0] = teclado.nextLine();
					System.out.println(client.doOperation("Repositorio", 2, envia));
					break;
				case "3": 
					System.out.println("ID da Disciplina: ");
					envia[0] = teclado.nextLine();
					System.out.println("Nome do Aluno: ");
					envia[1] = teclado.nextLine();
					System.out.println(client.doOperation("Repositorio", 3, envia));
					break;
				case "4": 
					System.out.println("ID da Disciplina: ");
					envia[0] = teclado.nextLine();
					System.out.println("Nome do Aluno: ");
					envia[1] = teclado.nextLine();
					System.out.println(client.doOperation("Repositorio", 4, envia));
					break;
				case "5": 
					System.out.println("Nome do Aluno: ");
					envia[1] = teclado.nextLine();
					envia[0] = "";
					System.out.println(client.doOperation("Repositorio", 5 ,envia));
					break;
				case "6": 
					envia[0] = "";
					envia[1] = "";
					System.out.println(client.doOperation("Repositorio", 6, envia));
					break;
				case "7": 
					envia[0] = "";
					envia[1] = "";
					System.out.println(client.doOperation("Repositorio", 7, envia));
					break;
				case "8": 
					System.out.println("Nome da Disciplina: ");
					envia[0] = teclado.nextLine();
					envia[1] = "";
					System.out.println(client.doOperation("Repositorio", 8, envia));
					break;
				case "9":
					System.out.println("Nome do Aluno: ");
					envia[1] = teclado.nextLine();
					envia[0] = "";
					System.out.println(client.doOperation("Repositorio", 9, envia));
					break;
				default:
					System.out.println("opção inválida");
			}		        
		}
	}
}

