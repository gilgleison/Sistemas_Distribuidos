package trab2.q1;

import java.net.*;
import java.io.*;
public class TCPServer {
	
	static DataInputStream in;
	static DataOutputStream out;
	static Socket clientSocket;
	
	public static void main (String args[]) throws IOException{
		
		int serverPort = 7896; // the server port
		ServerSocket listenSocket = new ServerSocket(serverPort);
		
		while(true){	
				
			clientSocket = listenSocket.accept();
			in = new DataInputStream( clientSocket.getInputStream());
			out = new DataOutputStream( clientSocket.getOutputStream());
			
			while(true){	
				
				String data = getRequest();
				//System.out.println(data);
				if(data.equals("-1")) {
					clientSocket.close();				
					break;	
				}
				
				String str[] = data.split(":");
				
				double result;
				
				switch (str[0]){
				case "+": 
					result = Calc.soma(Double.valueOf(str[1]),Double.valueOf(str[2]));
					data = String.valueOf(result);
					break;
				case "-": 
					result = Calc.sub(Double.valueOf(str[1]),Double.valueOf(str[2]));
					data = String.valueOf(result);
					break;
				case "*": 
					result = Calc.mult(Double.valueOf(str[1]),Double.valueOf(str[2]));
					data = String.valueOf(result);
					break;
				case "/": 
					result = Calc.div(Double.valueOf(str[1]),Double.valueOf(str[2]));
					data = String.valueOf(result);
					break;			
				}
				
				sendResponse(data);					
			}					
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
	
	public static void sendResponse(String data){
		try {
			
			out.writeUTF(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
