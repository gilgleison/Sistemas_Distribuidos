package trab2.lib2;

public class Despachante {
	
	public static String desp(String s){
		
		String str[] = s.split(":");
		
		String envio = "0";
		
		switch (str[0]){
		case "+": 
			str[1] =  str[1] + ":" + str[2];
			envio = Esqueleto.soma(str[1]);
			break;
		case "-": 
			str[1] =  str[1] + ":" + str[2];
			envio = Esqueleto.sub(str[1]);
			break;
		case "*": 
			str[1] =  str[1] + ":" + str[2];
			envio = Esqueleto.mult(str[1]);			
			break;
		case "/": 
			str[1] =  str[1] + ":" + str[2];
			envio = Esqueleto.div(str[1]);			
			break;
		}
		
		return envio;
	}
}
