package controller.bean;

import java.util.*;

import javax.faces.bean.*;
import javax.faces.component.html.HtmlInputText;

import dao.DAOPostagem;
import model.*;
@ManagedBean(name = "postagemBean")
@ViewScoped
public class PostagemManagedBean {
    private DAOPostagem daoPostagem = DAOPostagem.getInstance();
    private List<Postagem> postagens = new ArrayList<Postagem>();
	private HtmlInputText inputPesquisa;
	private String pesquisa;
	
		
	public void init() {
		for (Postagem postagem : daoPostagem.listar()) {
			postagens.add(postagem);
		}
	}

	public List<Postagem> getPostagens(){
        return postagens;
    }
	
	public List<Postagem> pesquisar() {
		System.out.println("Pesquisa: "+ pesquisa);
		postagens = daoPostagem.pesquisarPostagens(pesquisa);
		for (Postagem postagem : postagens) {
			System.out.println(postagem.getTitulo());
		}
		return postagens;
	}

	public HtmlInputText getInputPesquisa() {
		return inputPesquisa;
	}

	public void setInputPesquisa(HtmlInputText inputPesquisa) {
		this.inputPesquisa = inputPesquisa;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
}
