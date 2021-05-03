package br.edu.ifsuldeminas.utils;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;


import br.edu.ifsuldeminas.modelo.Pessoa;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		// Obt�m contexto da aplica��o
		FacesContext context = event.getFacesContext();
		// Obt�m o nome da p�gina que est� sendo chamada
		String nomePagina = context.getViewRoot().getViewId();

		// System.out.println(nomePagina);

		// se for a p�gina de login, o usu�rio pode acessar
		if ("/login.xhtml".equals(nomePagina)) {
			return;
		}

		// Obt�m usu�rio da sess�o
		Pessoa usuarioLogado = (Pessoa) context.getExternalContext().getSessionMap().get("usuarioLogado");

		// se h� usu�rio logado, ele pode acessar as p�ginas
		if (usuarioLogado != null) {
//			// se for a index, o usu�rio pode acessar
//			if (nomePagina.equals("/Index.xhtml")) {
//				return;
//			}
//
//			// caso n�o seja a index, obt�m a p�gina/funcionalidade na sess�o
//			Funcionalidade funcionalidade = (Funcionalidade) context.getExternalContext().getSessionMap()
//					.get(nomePagina);
//
//			// se usuario tem acesso � funcionalidade - objeto n�o nulo
//			if (funcionalidade != null) {
//				return;
//			}
//
//			// usu�rio n�o tem acesso a funcionalidade, o usu�rio �
//			// redirecionado para a index
//			NavigationHandler handler = context.getApplication().getNavigationHandler();
//			handler.handleNavigation(context, null, "/principal?faces-redirect=true");
//			context.renderResponse();
			
			return;
		}
		if(usuarioLogado == null){
			if(nomePagina.equals("/modelo.xhtml") || nomePagina.equals("/Apoiador.xhtml") || nomePagina.equals("/atividade.xhtml") || nomePagina.equals("/comiss�o.xhtml") || nomePagina.equals("./Evento.xhtml") || nomePagina.equals("/Inscricao.xhtml") || nomePagina.equals("/pessoa.xhtml")){
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "/login?faces-redirect=true");
			context.renderResponse();
			return;
			}
		}

		// se n�o h�, o usu�rio � redirecionado para o login
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/login?faces-redirect=true");
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW; // o autorizador ser� executado na fase
										// restore_view
	}

}