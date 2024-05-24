package com.u2.web.SpringDojo.model;

import java.beans.JavaBean;

@JavaBean
public class LivroModel {

	private String titulo;
	private String editora;
	
	public LivroModel() {
		super();
	}

	public LivroModel(String titulo, String editora) {
		super();
		this.titulo = titulo;
		this.editora = editora;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "LivroModel{" +
				"titulo='" + titulo + '\'' +
				", editora='" + editora + '\'' +
				'}';
	}
}
