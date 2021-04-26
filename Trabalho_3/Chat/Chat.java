import java.rmi.*;  
    
public interface Chat extends Remote 
{ 
    public String ler() throws RemoteException;
    public void escrever(String msg) throws RemoteException;
    public String ler2() throws RemoteException;
    public void escrever2(String msg) throws RemoteException; 

}