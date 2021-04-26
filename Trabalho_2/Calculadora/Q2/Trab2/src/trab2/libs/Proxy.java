package trab2.libs;

public class Proxy{
	
	public TCPClient tcp = new TCPClient();
	
    public double soma(double op1, double op2){
    	
    	String op = "+";  
	    String trata = op + ":" + String.valueOf(op1) + ":" + String.valueOf(op2);
	    this.tcp.sendRequest(trata);
	    String recebe = this.tcp.getResponse();
	    double envio = Double.valueOf(recebe);
	    return envio;
	    	
    }
    public double sub(double op1, double op2){
    	
    	String op = "-";  
	    String trata = op + ":" + String.valueOf(op1) + ":" + String.valueOf(op2);
	    this.tcp.sendRequest(trata);
	    String recebe = this.tcp.getResponse();
	    double envio = Double.valueOf(recebe);
	    return envio;
	    	
    }
    public double mult(double op1, double op2){
    	
    	String op = "*";  
	    String trata = op + ":" + String.valueOf(op1) + ":" + String.valueOf(op2);
	    this.tcp.sendRequest(trata);
	    String recebe = this.tcp.getResponse();
	    double envio = Double.valueOf(recebe);
	    return envio;
	    	
    }
    public double div(double op1, double op2){
    	
    	String op = "/";  
	    String trata = op+ ":" + String.valueOf(op1) + ":" + String.valueOf(op2);
	    this.tcp.sendRequest(trata);
	    String recebe = this.tcp.getResponse();
	    double envio = Double.valueOf(recebe);
	    return envio;
	    	
    }
    public void close(){
    	tcp.close();
    }
}

