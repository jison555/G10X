package com.example.demo.entity;

public class Teachers {
	
	private int id;
	private String name;
	private String language;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Teachers [id=" + id + ", name=" + name + ", language=" + language + "]";
	}
	
	
	

}
