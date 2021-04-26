import java.net.*;
import java.io.*;
import java.util.Scanner;

class Cliente{
	int porta = 0;
	int count;
	String[] oper = new String[3];

	public Cliente(int port){
		this.porta = port;
		count = 0;
	}

	int getPorta(){
		return this.porta;
	}

	String[] getOper(){
		return oper;
	}
}

public class TCPServer {
	public static Cliente[] lista = new Cliente[10];
	public static void main (String args[]) {
		try{
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
}
class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	int porta;
	TCPServer tcp = new TCPServer();
	int i = 0 , j = 0 , cont = 0;
	String msg; 
	String op;

	public Connection(Socket aClientSocket) {
		try {

			System.out.println("Received: ");
			clientSocket = aClientSocket;
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			out.writeUTF("Envie o operando");

			this.start();
		} catch (IOException e) {
			System.out.println("Connection:" + e.getMessage());
		}
	}

	public void run() {
		try { // an echo server
			porta = clientSocket.getPort();

			System.out.println("Received: ");

			if(tcp.lista[i] == null){
				tcp.lista[i] = new Cliente(porta);

			}else {
				for (i = 0; i < tcp.lista.length; i++){
					if (tcp.lista[i] != null && tcp.lista[i].getPorta() == porta){
						tcp.lista[i] = new Cliente(porta);
						break;
					}
				}						
			}


			System.out.println("Received: ");

			String[] aux = tcp.lista[i].getOper();

			for(j=0; j <aux.length;j++){
				if(aux[j] != null){
					cont++;
					break;
				}
			}

			switch (cont){
			case 0:
				msg = "envie o operando";
				break;
			case 1:
				msg = "envie o primeiro digito";
				break;
			case 2:
				msg = "envie o segundo digito";
				break;
			}
			
			out.writeUTF(msg);
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch(IOException e) {System.out.println("readline:"+e.getMessage());
		}finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
	}
}
