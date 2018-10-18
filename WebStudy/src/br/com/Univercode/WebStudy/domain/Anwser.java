package br.com.Univercode.WebStudy.domain;

public class Anwser {
	private int id;
	private String anwser;
	private boolean correct;
	private int idQuestion;
	
	public Anwser(int id, String anwser, boolean right, int idQuestion) {
		setId(id);
		setAnwser(anwser);
		setCorrect(right);
		setIdQuestion(idQuestion);
	}
	
	public Anwser(String anwser, boolean right) {
		setAnwser(anwser);
		setCorrect(right);
	}
	
	public boolean isCorrect(){
		return correct;
	}
	public void setCorrect(boolean correct){
		this.correct = correct;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnwser() {
		return anwser;
	}
	public void setAnwser(String anwser) {
		this.anwser = anwser;
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
}
