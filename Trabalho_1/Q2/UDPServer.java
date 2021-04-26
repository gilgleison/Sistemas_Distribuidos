import java.net.*;

import java.io.*;
public class UDPServer{
    public static void main(String args[]){ 
    	DatagramSocket aSocket = null;
		try{
	    	aSocket = new DatagramSocket(6789);
					// create socket at agreed port
			byte[] buffer = new byte[1000];
 			while(true){
 					DatagramPacket request = new DatagramPacket(buffer, buffer.length);
					aSocket.receive(request);
					
					String teste = new String(request.getData());
					String carac[] = teste.split(":");
					double envio = 0;

					double part1 = Double.valueOf(carac[0]);
					double part2 = Double.valueOf(carac[2]);

					switch (carac[1]){
						case "+": 
							envio = part1 + part2;
							break;
						case "-": 
							envio = part1 + part2;			
							break;
						case "*": 
							envio = part1 * part2;			
							break;
						case "/": 
							envio = part1 / part2;			
							break;
					}
			
					buffer = String.valueOf(envio).getBytes();
					request.setData(buffer);

    			DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), 
    			request.getAddress(), request.getPort());
					aSocket.send(reply);

					buffer = new byte[1000];
					
    		}
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
    }
}
