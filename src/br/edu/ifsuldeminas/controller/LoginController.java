package br.edu.ifsuldeminas.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifsuldeminas.dao.PessoaDao;
import br.edu.ifsuldeminas.modelo.Pessoa;



@ManagedBean
@ViewScoped
public class LoginController {

	private Pessoa usuario = new Pessoa();
	

	public Pessoa getUsuario() {
		return usuario;
	}

	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}

	public String logar() {
		Pessoa u = new PessoaDao().buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());

		FacesContext context = FacesContext.getCurrentInstance();
		if (u != null) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", u);
			return "modelo?faces-redirect=true";
		} else {
			context.getExternalContext().getFlash().setKeepMessages(true);

			context.addMessage(null, new FacesMessage("Email e/ou Senha estão incorretos!"));
			return "login?faces-redirect=true";
		}
	}

	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().clear();
		return "login?faces-redirect=true";
	}
}
