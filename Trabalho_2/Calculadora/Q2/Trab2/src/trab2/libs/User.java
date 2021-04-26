package trab2.libs;
import java.util.InputMismatchException;
import java.util.Scanner;

import trab2.libs.Proxy;

public class User {
	public static void main(String[] args) {
		Proxy proxy = new Proxy();
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
		            	proxy.close();
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
		        
		        switch (sel){
				case "1.0": 
					System.out.println("Resultado " + proxy.soma(num[1],num[2]));
					break;
				case "2.0": 
					System.out.println("Resultado " + proxy.sub(num[1],num[2]));
					break;
				case "3.0": 
					System.out.println("Resultado " + proxy.mult(num[1],num[2]));		
					break;
				case "4.0": 
					System.out.println("Resultado " + proxy.div(num[1],num[2]));		
					break;
					
				}
		        
			}catch(InputMismatchException e){
				System.out.println("Digite apenas números");
			}
		}
	}
}
