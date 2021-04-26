package tf;
import com.google.gson.*;
import java.net.*;
import java.io.*;

public class TCPClient{
	
	InetAddress aHost;
	Socket s;
	DataInputStream in;
	DataOutputStream out;
	int serverPort;
	
	Mensagem msg = new Mensagem();
	Mensagem msg2 = new Mensagem();
	
	Gson gson = new Gson();
	String envia = "";
	String recebe = "";
	
	TCPClient(){
		s = null;
		try{
			serverPort = 9002;
			aHost = InetAddress.getByName("localhost");
			s = new Socket(aHost, serverPort);    
			in = new DataInputStream( s.getInputStream());
			out =new DataOutputStream( s.getOutputStream());
			
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}
     }
	
	public String doOperation(String remoteObjRef, int metodoId, String args[]){
		String data= "";
		try {
			
			msg.msgType = 0;
			msg.rqId += 1;
			msg.objRef = remoteObjRef;
			msg.mtdId = metodoId;
			msg.args = args;
			
			envia = gson.toJson(msg);

			try {
			
				File fl = new File("qualquercoisa.json");
				FileWriter flw = new FileWriter(fl);
				flw.write(envia);
				flw.close();
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			out.writeUTF(envia);
			recebe = in.readUTF();
			
			try {
				
				File fl = new File("qualquercoisa2.json");
				FileWriter flw = new FileWriter(fl);
				flw.write(recebe);
				flw.close();
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			msg2 = gson.fromJson(recebe, Mensagem.class);
			//if(msg.rqId == msg.rqId)
				//data = "ok";
			
			data = msg2.args[0];
			
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
			e.printStackTrace();
		}
	}
}
