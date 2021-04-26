import java.rmi.*; 
import java.rmi.server.*;

public class CalculatorImple extends UnicastRemoteObject implements Calculator 
{ 
    protected CalculatorImple() throws RemoteException  
    { 
        super(); 
    } 
    public double soma(double a, double b) {
		return a + b;
	}
	public double sub(double a, double b) {
		return a - b;
	}
	public double mult(double a, double b) {
		return a * b;
	}
	public double div(double a, double b) {
		return a / b;
	}
}