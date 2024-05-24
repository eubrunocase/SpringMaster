package com.u2.web.SpringDojo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.u2.web.SpringDojo.model.LivroModel;
import com.u2.web.SpringDojo.negocio.LivroRN;

import java.util.List;

@Controller
public class LivroController {
	LivroRN livroRN = new LivroRN();

	@GetMapping("/homeLivro")
	public String abreCadastro(Model model) {
		List<LivroModel> livros = livroRN.listarTodosLivros();
		model.addAttribute("livros", livros);
		return "Cadastrar";
	}

	@PostMapping("/cadastrar")
	public String cadastrarLivro(HttpServletRequest request,
								 @RequestParam(value = "titulo") String titulo,
								 @RequestParam(value = "editora") String editora,
								 Model model) {
		LivroModel modelLivro = new LivroModel();
		String mensagem = "";

		if (!titulo.isEmpty()) {
			modelLivro.setTitulo(titulo);
		} else {
			mensagem = "Título não pode ficar em branco.\n";
		}
		if (!editora.isEmpty()) {
			modelLivro.setEditora(editora);
		} else {
			mensagem += "Editora não pode ficar em branco.";
		}
		if (mensagem.isEmpty()) {
			boolean cadastrouLivro = livroRN.cadastrarLivro(modelLivro);

			if (!cadastrouLivro) {
				mensagem = "Livro já existente na base.";
			}
		}

		if (!mensagem.isEmpty()) {
			request.getSession().setAttribute("mensagem", mensagem);
		} else {
			request.getSession().removeAttribute("mensagem");
		}

		List<LivroModel> livros = livroRN.listarTodosLivros();
		model.addAttribute("livros", livros);

		return "Cadastrar";
	}

	@GetMapping("/pesquisarLivro")
	public String abrePesquisa(){
		return "Pesquisar";
	}
	@RequestMapping(value = "/pesquisar")
	public String findByTitle(@RequestParam(value = "titulo")String titulo,
										HttpServletRequest request){
		request.getSession().setAttribute("livros",livroRN.pesquisarLivro(titulo).toString());
		return "Pesquisar";
	}


	@GetMapping("/alterar")
	public String alterarDeletar(@RequestParam(value = "titulo") String titulo,
								 @RequestParam(value = "editora") String editora,
								 Model model) {
		LivroModel livro = new LivroModel(titulo, editora);
		boolean editou = livroRN.editarLivro(livro);
		if (editou){
			return "redirect:/homeLivro";
		}
		model.addAttribute("livro", livro);
		return "AlterarDeletar";
	}

	@RequestMapping({"/remover"})
	public String deletarLivro(HttpServletRequest request,
							   @RequestParam(value="titulo") String titulo) {
		String mensagem = "";

		if(titulo.isEmpty()) {
			mensagem  = "Digite um titulo";
		} else if(!livroRN.contains(titulo)) {
			mensagem = "Livro não encontrado";
		} else {
			livroRN.livro = new LivroModel("","");
			livroRN.remove(titulo);
			mensagem = "Livro foi removido";
		}

        request.getSession().setAttribute("mensagem", mensagem);

        return "redirect:/homeLivro";
	}

}
