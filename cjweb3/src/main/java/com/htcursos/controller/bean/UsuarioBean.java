package com.htcursos.controller.bean;

import java.util.List;

import javax.annotation.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Usuario;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.service.UsuarioService;

@Controller
@ViewScoped
public class UsuarioBean {
	/**
	 * Este objeto vincula os dados da tela
	 */
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioService usuarioService;
	
	private List<Usuario> usuarioList;
	
	//@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		usuarioList = usuarioService.buscarTodos();
	}

	public void salvar() {
		try {
			usuarioService.salvar(usuario);
			// Limpar os dados
			usuario = new Usuario();
			// Atualiza lista
			usuarioList = usuarioService.buscarTodos();
			// Envia Mensagem para Tela
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com Sucesso!", null));
		} catch (ServiceException e) {
			// Código da mensagem de erro para Tela
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Salvar: " + e.getMessage(), null));
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		usuarioService.excluir(usuario);
		// Atualiza lista
		usuarioList = usuarioService.buscarTodos();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}
	
}
