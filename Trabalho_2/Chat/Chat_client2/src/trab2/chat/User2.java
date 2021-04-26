package trab2.chat;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class User2{
	public static void main(String[] args){
		TCPClient client = new TCPClient();
		while(true) {
			
			String msg = client.getResponse();
			
			if(msg.equals("!sair")){
				System.out.println("O Outro Cliente saiu");
				client.close();
				return;
			}
			
			System.out.println("Resposta: " + msg);
			
			Scanner teclado = new Scanner(System.in);
			
			String envio = teclado.next();
			
			if(envio.equals("!sair")){
				client.close();
				return;
			}
			
			client.sendRequest(envio);		
			
		}
	}
}