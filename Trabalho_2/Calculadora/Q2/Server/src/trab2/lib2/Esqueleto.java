package trab2.lib2;

public class Esqueleto{
	public static String soma(String s) {
		String str[] = s.split(":");
		double a = Double.valueOf(str[0]);
		double b = Double.valueOf(str[1]);
		double soma = Calc.soma(a,b);
		String envio = String.valueOf(soma);
		
		return envio;		
	}
	public static String sub(String s) {
	
		String str[] = s.split(":");
		double a = Double.valueOf(str[0]);
		double b = Double.valueOf(str[1]);
		double sub = Calc.sub(a,b);
		String envio = String.valueOf(sub);
		
		return envio;
		
	}
	public static String mult(String s) {
		
		String str[] = s.split(":");
		double a = Double.valueOf(str[0]);
		double b = Double.valueOf(str[1]);
		double mult = Calc.mult(a,b);
		String envio = String.valueOf(mult);
		
		return envio;
	}
	public static String div(String s) {
		
		String str[] = s.split(":");
		double a = Double.valueOf(str[0]);
		double b = Double.valueOf(str[1]);
		double div = Calc.div(a,b);
		String envio = String.valueOf(div);
		
		return envio;
	}

}
