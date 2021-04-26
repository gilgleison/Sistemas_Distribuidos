package trab2.chat;
import java.net.*;
import java.io.*;
public class TCPServer {
	static DataOutputStream out1;
	static DataOutputStream out2;
	static DataInputStream in1;
	static DataInputStream in2;
	static Socket cliente1 = null;
	static Socket cliente2 = null;
	
	public static void main (String args[]) throws InterruptedException {
		try{
			
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			
			while(true) {
		        System.out.println("Aguardando conexão dos clientes ");
		      
	        	cliente1 = listenSocket.accept();
	        	System.out.println("Cliente 1 "+ cliente1.getPort());
		       
		        
	        	cliente2 = listenSocket.accept();
	        	System.out.println("Cliente 2 "+ cliente2.getPort());
		      
		        
		        out1 = new DataOutputStream(cliente1.getOutputStream());
		        out2 = new DataOutputStream(cliente2.getOutputStream());
		        
		        in1 = new DataInputStream(cliente1.getInputStream());
		        in2 = new DataInputStream(cliente2.getInputStream());
		        
		        String msg1 = null;
		        String msg2 = null;
		        
		        while (true){                        
		            msg1 = getRequest();
		            if(msg1.equals("!sair")){
		            	sendResponse2(msg1);
		            	cliente1.close();
		            	cliente2.close();
		            	System.out.println("Um dos clientes encerrou a conexão");
		            	break;
		            }
		            sendResponse2(msg1);
		            
		            msg2=getRequest2();
		            if(msg2.equals("-1")) {
		            	sendResponse(msg2);
		            	cliente2.close();
		            	cliente1.close();
		            	System.out.println("Um dos clientes encerrou a conexão");
		            	break;
		            }
		            sendResponse(msg2);
		
		            Thread.sleep(1000);
		        }
                        
			}
			
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
	
	public static String getRequest(){
		String data="";
		try{
			
			data = in1.readUTF();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	                  // read a line of data from the stream	
		return data;
	}
	
	public static String getRequest2(){
		String data="";
		try{
			
			data = in2.readUTF();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	                  // read a line of data from the stream	
		return data;
	}
	
	public static void sendResponse(String data){
		try {
			
			out1.writeUTF(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void sendResponse2(String data){
		try {
			
			out2.writeUTF(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
}