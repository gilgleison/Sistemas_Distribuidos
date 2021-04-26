import java.rmi.*; 
import java.rmi.server.*;

public class ChatImple extends UnicastRemoteObject implements Chat
{ 
    String msg = "";
    String msg2 = "";

    protected ChatImple() throws RemoteException  
    { 
        super(); 
    }
    
    public void escrever(String msg){
        this.msg2 = msg;
	}

	public String ler(){
        String str = msg;
        msg = "";
        return str;
    }
    
    public void escrever2(String msg){
        this.msg = msg;
	}

	public String ler2(){
        String str = msg2;
        msg2 = "";
        return str;
    }
    
}