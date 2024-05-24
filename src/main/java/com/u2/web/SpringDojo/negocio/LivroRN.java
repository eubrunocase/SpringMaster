package com.u2.web.SpringDojo.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.u2.web.SpringDojo.model.LivroModel;

public class LivroRN {
	private HashMap<String, LivroModel> hashLivro = new HashMap<>();
	public LivroModel livro = new LivroModel("","");

	public boolean cadastrarLivro(LivroModel model) {

		//Fazer o cadastramento através do título
		if(!hashLivro.containsKey(model.getTitulo())) {
			hashLivro.put(model.getTitulo(), model);
		} else {
			return false;
		}

		return true;
	}
	public LivroModel pesquisarLivro(String titulo){
		if (!hashLivro.containsKey(titulo)){
			throw new RuntimeException();
		}else {
			return hashLivro.get(titulo);
		}

	}

	public LivroModel pegarLivroAntigo(String titulo){
		if (!hashLivro.containsKey(titulo)){
			throw new RuntimeException();
		}else {
			livro = pesquisarLivro(titulo);
			System.out.println(livro.toString() + " dentro de pegar livro antigo");
			return livro;
		}
	}

	public boolean editarLivro(LivroModel livroNovo){
		if (!livro.getTitulo().isEmpty()){
			if (hashLivro.containsKey(livro.getTitulo())) {
				hashLivro.remove(livro.getTitulo());
				hashLivro.put(livroNovo.getTitulo(), livroNovo);
				livro = new LivroModel("","");
				return true;
			}
		}
		if (livro.getTitulo().isEmpty()){
			livro = livroNovo;
			return false;
		}
		return false;
	}

	public HashMap<String, LivroModel> pesquisarTodos() {
		return hashLivro;
	}

	public List<LivroModel> listarTodosLivros() {
		return new ArrayList<>(hashLivro.values());
	}

	public boolean remove(String titulo){
		if (contains(titulo)){
			hashLivro.remove(titulo);
			return true;
		}
		return false;
	}

	public boolean contains(String titulo) {
		return hashLivro.containsKey(titulo);
	}
}