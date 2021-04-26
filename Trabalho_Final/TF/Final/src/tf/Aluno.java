package tf;
import java.util.ArrayList;

public class Aluno{
	String nome="";
	int matricula = 0; 
	ArrayList<String> VecDisc = new ArrayList<String>();
	
	public Aluno(String nome, int matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public void Matricular(String cod){
		if(check(cod) == -1)
			VecDisc.add(cod);
	}
	
	public void Desmatricular(String cod){
		int ind = check(cod);
		if(ind != -1) {
			VecDisc.remove(ind);
		}
	}
	
	public int check(String cod){
		for(int i = 0; i< this.VecDisc.size(); i++){
			if(cod.equals(VecDisc.get(i)))
				return i;			
		}
		return -1;		
	}
	
	public String show(){
		String ss = this.nome + ", "+ this.matricula +": " + "[";
		if (this.VecDisc != null && !this.VecDisc.isEmpty()) {
			for(String i: this.VecDisc){
				ss += " " + i;
			}
		}
		ss += " ]";
		return ss;
	}
	
	public String getName() {
		return this.nome;
	}
	
	public int getMat() {
		return this.matricula;
	}
	
	public ArrayList<String> getDisc(){
		return this.VecDisc;
	}
	
}
