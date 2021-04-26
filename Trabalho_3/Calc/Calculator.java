import java.rmi.*;  
    
public interface Calculator extends Remote 
{ 
    public double soma(double a, double b) throws RemoteException;
    public double sub(double a, double b) throws RemoteException;
    public double div(double a, double b) throws RemoteException;
    public double mult(double a, double b) throws RemoteException; 

}