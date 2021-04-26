import java.rmi.*;
import java.util.*;
public class ChatClient  
{ 
    public static void main(String[] args)  
    { 
        System.out.println("################### Chat RMI #####################");

        try
        { 
            Chat c = (Chat) Naming.lookup("ChatRMI");

            new Thread() {   
                public void run() {
                    escreve(c);
                }
              }.start();

            new Thread() {   
                public void run() {
                    ler(c);
                }
              }.start();

        }  
        catch (Exception e){ 
            System.out.println(e); 
        } 
    }

    public static void ler(Chat c){
        try{
            while(true){
                String recebe = c.ler();

                if(recebe.length() != 0){
                    System.out.println("Mensagem: "+recebe);
                }
            } 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
        
    }

    public static void escreve(Chat c){
        try{
            String str;
            Scanner teclado = new Scanner(System.in);
            
            while(true){
                str = teclado.nextLine();
                c.escrever(str);
            } 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
        
    }
}