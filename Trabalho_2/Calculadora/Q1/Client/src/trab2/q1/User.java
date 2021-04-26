package trab2.q1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
	public static void main(String[] args) {
		TCPClient client = new TCPClient();
		while(true){
			try {
		        System.out.println("Digite o numero para escolher a operação: \n"
		                         + "1 : Soma \n"
		                         + "2 : Subtração \n"
		                         + "3 : Multiplicação \n"
		                         + "4 : Divisão \n"
		                         + "5 : para sair\n");
		        
		        Scanner teclado = new Scanner(System.in); 
		        
		        double num[] = new double[3];
		
		        for(int i = 0; i<3 ; i++){
		            switch(i){
		                case 0:
		                    System.out.println("escolha a operação:");
		                    break;
		                case 1:
		                    System.out.println("Primeiro digito:");
		                    break;
		                case 2:
		                    System.out.println("Segundo digito:");
		                    break;
		            }
		            
		            num[i] = teclado.nextDouble();
		            
		            if(num[0]== 5.0){
		            	client.close();
		            	return; 
		            }   
		           
		            if(i == 2 && num[2] == 0.0){ 
		            	System.out.println("impossivel realizar divisão por zero, digite outro número");
		            	i--;
		            }
		            
		            if(num[0] != 1 && num[0] != 2 && num[0] != 3 && num[0] != 4.0){ 
		            	System.out.println("Escolha uma operação válida");
		            	i--;
		            }
		            		            
		        }
		        
		        String sel = String.valueOf(num[0]);
		        String op = "";
		        String envio="";
		        
		        switch (sel){
				case "1.0": 
					op = "+";
					envio = op + ":" + String.valueOf(num[1]) + ":" + String.valueOf(num[2]);
					client.sendRequest(envio);
					System.out.println("Resultado " + client.getResponse());
					break;
				case "2.0": 
					op = "-";
					envio = op + ":" + String.valueOf(num[1]) + ":" + String.valueOf(num[2]);
					client.sendRequest(envio);
					System.out.println("Resultado " + client.getResponse());
					break;
				case "3.0": 
					op = "*";
					envio = op + ":" + String.valueOf(num[1]) + ":" + String.valueOf(num[2]);
					client.sendRequest(envio);
					System.out.println("Resultado " + client.getResponse());
					break;
				case "4.0": 
					op = "/";
					envio = op + ":" + String.valueOf(num[1]) + ":" + String.valueOf(num[2]);
					client.sendRequest(envio);
					System.out.println("Resultado " + client.getResponse());
					break;	
				}
		        
			}catch(InputMismatchException e){
				System.out.println("Digite apenas números");
			}
		}
	}
}
