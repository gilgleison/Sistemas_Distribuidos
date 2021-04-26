package tf;

import com.google.gson.*;
import java.net.*;
import java.io.*;

public class TCPServer {
	
	static DataInputStream in;
	static DataOutputStream out;
	static Socket clientSocket;
	static Mensagem msg = new Mensagem();
	static Gson gson = new Gson();
	static Repositorio rep = new Repositorio();
	
	public static void main (String args[]) throws IOException{
		
		int serverPort = 7896; // the server port
		ServerSocket listenSocket = new ServerSocket(serverPort);
		
		while(true){	
			
			System.out.println("\t Esperando Conexão \n");
			
			clientSocket = listenSocket.accept();
			in = new DataInputStream( clientSocket.getInputStream());
			out = new DataOutputStream( clientSocket.getOutputStream());
			
			System.out.println("\t Cliente Conectado \n");
			
			while(true){	
				
				String data = getRequest();
				//System.out.println(data);
				
				System.out.println(data);
				msg = gson.fromJson(data, Mensagem.class);
				
				try {
					
					if(msg.mtdId == -1) {
						clientSocket.close();				
						break;	
					}
					
					switch(msg.mtdId){
						case 1:
							//nome e matricula: String, Int
							data = rep.addAlu(msg.args.get(0), Integer.valueOf(msg.args.get(1)));
						break;
						case 2:
							// Id e Cod: String, String
							data = rep.addDisc(msg.args.get(0), msg.args.get(1));
						break;
						case 3:
							//cod da disciplina e matricula do aluno: String, Int
							data = rep.Matricular(msg.args.get(0), Integer.valueOf(msg.args.get(1)));
						break;
						case 4:
							//cod da disciplina e matricula do aluno: String, Int
							data = rep.Desmatricular(msg.args.get(0), Integer.valueOf(msg.args.get(1)));
						break;
						case 5:
							//Matricula do Aluno int
							data = rep.RemoverAlu(Integer.valueOf(msg.args.get(0)));
						break;
						case 6:
							//cod da disciplina
							data = rep.RemoverDisc(msg.args.get(0));
						break;
						case 7:
							data = rep.showDisc();
						break;
						case 8:						
							data = rep.showAlu();
						break;
					}
					
				}catch (Exception e){
					data = "\n Digite apenas Numeros para a matricula \n";
				}
				
				if(msg.args.isEmpty()) {
					msg.args.add(data);
				}
				else 
					msg.args.set(0, data);
				
				msg.msgType = 1;
				
				String aux = gson.toJson(msg);
				sendReply(aux);
			}
			
			clientSocket.close();
		}
	}
	
	public static String getRequest(){
		String data="";
		try{
			
			data = in.readUTF();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	                  // read a line of data from the stream	
		return data;
	}
	
	public static void sendReply(String data){
		try {
			
			out.writeUTF(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
