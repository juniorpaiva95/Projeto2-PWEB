package model;

import javax.persistence.*;

@Entity
public class Comentario  extends Model{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String comentario;
	
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Postagem postagem;
	
	
	public Comentario() {}
	public Comentario(String comentario, Usuario usuario, Postagem postagem) {
		super();
		this.comentario = comentario;
		this.usuario = usuario;
		this.postagem = postagem;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Postagem getPostagem() {
		return postagem;
	}
	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	
}
