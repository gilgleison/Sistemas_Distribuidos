package tf;

import java.io.IOException;
import java.util.ArrayList;

public class Repositorio{
	
	private ArrayList<Disciplina> Disciplinas = new ArrayList<Disciplina>();
	private ArrayList<Aluno> Alunos = new ArrayList<Aluno>();
	
	public String addAlu(String nome, int matricula){
		String ss="";
		if(checkAlu(matricula) == -1) {
			Alunos.add(new Aluno(nome, matricula));
			return ss;
		}
		ss = "\n Aluno já existe \n";
		return ss;
	}
	
	public String addDisc(String id, String cod){
		String ss="";
		if(checkDisc(cod) == -1) {
			Disciplinas.add(new Disciplina(id, cod));
			return ss;
		}
		ss = "\n Disciplina já existe \n";
		return ss;
	}
	
	public String Matricular(String cod, int matricula){
		String ss ="";
		int indA = checkAlu(matricula);
		int indD = checkDisc(cod);	
		if(indA != -1) {
			if(indD != -1){
				Alunos.get(indA).Matricular(cod);
				ss = Disciplinas.get(indD).Matricular(matricula);
				return ss;
			}
			ss = "\n Disciplina não existe \n";
			return ss;
		}
		ss = "\n Aluno não existe \n";
		return ss;
	}
	
	public String Desmatricular(String cod, int matricula){
		String ss ="";
		int indA = checkAlu(matricula);
		int indD = checkDisc(cod);	
		if(indA != -1){
			if(indD != -1) {
				Alunos.get(indA).Desmatricular(cod);
				ss = Disciplinas.get(indD).Desmatricular(matricula);
				return ss;
			}
			ss = "\n Disciplina não existe \n";
			return ss;
		}
		ss = "\n Aluno não existe \n";
		return ss;
	}
	
	public String RemoverAlu(int matricula) throws IOException{
		String ss = "";
		int ind = checkAlu(matricula);
		if(ind != -1){
			ArrayList<String> aux = this.Alunos.get(ind).getDisc();			
			for(int i=0; i<Integer.valueOf(aux.size());i++){
				for(int j=0; j<Integer.valueOf(this.Disciplinas.size());j++) {
					if(aux.get(i).equals(Disciplinas.get(j).getCod())){
						Disciplinas.get(j).Desmatricular(matricula);
					}
				}
			}
			Alunos.remove(ind);
			return ss;
		}
		ss = "\n Aluno não Existe \n";
		return ss;
	}
	
	public String RemoverDisc(String cod) throws IOException{
		String ss = "";
		int ind = checkDisc(cod);
		if(ind != -1){
			ArrayList<Integer> aux = this.Disciplinas.get(ind).getAlu();		
			for(int i=0; i<Integer.valueOf(aux.size());i++){
				for(int j=0; j<Integer.valueOf(this.Alunos.size());j++) {
					if(aux.get(i) == Alunos.get(j).getMat()) {
						Alunos.get(j).Desmatricular(cod);
					}
				}
			}
			Disciplinas.remove(ind);
			return ss;
		}
		ss = "\n Disciplina não Existe \n";
		return ss;
	}

	public int checkAlu(int matricula){
		for(int i = 0; i < this.Alunos.size(); i++){
			if(matricula == Alunos.get(i).getMat())
				return i;			
		}
		return -1;		
	}
	
	public int checkDisc(String cod){
		for(int i = 0; i< this.Disciplinas.size(); i++){
			if(cod.equals(Disciplinas.get(i).getCod()))
				return i;			
		}
		return -1;		
	}
	
	public String showAlu() {
		String ss="";
		if (this.Alunos != null && !this.Alunos.isEmpty()){
			ss = "Alunos: \n";
			for(Aluno i : this.Alunos) {
				ss += "\n" + i.show() + "\n";
			}
			return ss;
		}
		ss = "\n Nenhum Aluno Cadastrado \n";
		return ss;
	}
	
	public String showDisc(){
		String ss="";
		if (this.Disciplinas != null && !this.Disciplinas.isEmpty()) {
			ss = "Disciplinas: \n";
			for(Disciplina i : this.Disciplinas) {
				ss += "\n" + i.show() + "\n";
			}
			return ss;
		}
		ss = "\n Nenhuma Disciplina Cadastrada \n";
		return ss;
	}
}