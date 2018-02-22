package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Postagem extends Model{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private String titulo;
	@Column(nullable=false,columnDefinition="LONGTEXT")
//	@Lob
	private String texto;
	@Column(columnDefinition="int")
	private int views;
	@ManyToOne
	private Tema tema;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy="postagem")
	private List<Comentario> comentarios = new ArrayList<Comentario>(); 
	
	public Postagem() {}
	public Postagem(String titulo, String texto, Tema tema, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.tema = tema;
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
}
