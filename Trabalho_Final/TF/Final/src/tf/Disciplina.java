package tf;
import java.util.ArrayList;

public class Disciplina {
	String cod = "";
	String id="";
	ArrayList<Integer> VecAlu = new ArrayList<Integer>();
	
	public Disciplina(String id, String cod) {
		this.id = id;
		this.cod = cod;
	}
	
	public String Matricular(int mat){
		String ss="";
		if(check(mat) == -1) {
			VecAlu.add(mat);
			return ss;
		}
		ss = "\n Aluno já matriculado nessa Disciplina \n";
		return ss;
	}
	
	public String Desmatricular(int mat){
		String ss="";
		int ind = check(mat);
		if(ind != -1) {
			VecAlu.remove(ind);
			return ss;
		}
		ss = "\n Aluno não matriculado \n";
		return ss;
	}
	
	public int check(int mat){
		for(int i = 0; i< this.VecAlu.size(); i++){
			if(mat == VecAlu.get(i))
				return i;			
		}
		return -1;		
	}
	
	public String show(){
		String ss = this.id +", "+ this.cod +": " + "[";
		if (this.VecAlu != null && !this.VecAlu.isEmpty()) {
			for(Integer i: this.VecAlu) {
				ss += " " + i;
			}
		}
		ss += " ]";
		return ss;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getCod() {
		return this.cod;
	}
	
	public ArrayList<Integer> getAlu(){
		return this.VecAlu;
	}
}
