package model;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Usuario extends Model{
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private String login;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String password;

//	@ManyToOne
//	@JoinColumn(name = "iduser")
//	private ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
	
	public Usuario() {}
	
	public Usuario(String login, String nome, String password) {
		super();
		this.login = login;
		this.nome = nome;
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
