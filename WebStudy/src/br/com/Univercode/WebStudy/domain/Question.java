package br.com.Univercode.WebStudy.domain;

import java.util.ArrayList;

public class Question implements Domain {
	private int id;
	private String content;
	private String disciple;
	private String theme;
	private TypeQuestion typeQuestion;
	private LevelQuestion difficultQuestion;
	private ArrayList<Anwser> anwsers;
	
	public Question(String content, String disciple, String theme, TypeQuestion type, LevelQuestion level, ArrayList<Anwser> anwsers) {
		setContent(content);
		setDisciple(disciple);
		setTheme(theme);
		setTypeQuestion(type);
		setLevelQuestion(level);
		setAnwsers(anwsers);
	}
	
	public Question(int id, String content, String disciple, String theme, TypeQuestion type, LevelQuestion level, ArrayList<Anwser> anwsers) {
		setId(id);
		setContent(content);
		setDisciple(disciple);
		setTheme(theme);
		setTypeQuestion(type);
		setLevelQuestion(level);
		setAnwsers(anwsers);
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public TypeQuestion getTypeQuestion() {
		return typeQuestion;
	}
	public void setTypeQuestion(TypeQuestion typeQuestion) {
		this.typeQuestion = typeQuestion;
	}
	public LevelQuestion getLevelQuestion() {
		return difficultQuestion;
	}
	public void setLevelQuestion(LevelQuestion difficultQuestion) {
		this.difficultQuestion = difficultQuestion;
	}
	public ArrayList<Anwser> getAnwsers() {
		return anwsers;
	}
	public void setAnwsers(ArrayList<Anwser> anwsers) {
		this.anwsers = anwsers;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	public String getDisciple() {
		return disciple;
	}
	public void setDisciple(String disciple) {
		this.disciple = disciple;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
}
