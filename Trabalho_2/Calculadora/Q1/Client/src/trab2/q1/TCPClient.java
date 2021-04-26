package trab2.q1;

import java.net.*;
import java.io.*;
public class TCPClient{
	
	InetAddress aHost;
	Socket s;
	DataInputStream in;
	DataOutputStream out;
	int serverPort;
	
	TCPClient(){
		// arguments supply message and hostname
		s = null;
		try{
			serverPort = 7896;
			aHost = InetAddress.getByName("localhost");
			s = new Socket(aHost, serverPort);    
			in = new DataInputStream( s.getInputStream());
			out =new DataOutputStream( s.getOutputStream());
			//out.writeUTF(ss);      	// UTF is a string encoding see Sn. 4.4
			//String data = in.readUTF();	    // read a line of data from the stream
			//return data;
			//System.out.println("Received: "+ data) ; 
			
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}
		//return ss;
     }
	
	public void sendRequest(String ss){
		try {
			out.writeUTF(ss);
		} catch (IOException e) {
			System.out.println("fui eu ");
			e.printStackTrace();
		}
	}
	
	public String getResponse(){
		String data= "";
		try {
			//String data;
			data = in.readUTF();
			//return data;
		} catch (IOException e){
			System.out.println("mentira, fui eu ");
			e.printStackTrace();
		}
		return data;
	}
	
	public void close() {
		try {
			String sair = "-1";
			out.writeUTF(sair);
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
