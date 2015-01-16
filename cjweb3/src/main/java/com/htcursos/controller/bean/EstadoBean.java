package com.htcursos.controller.bean;

import java.util.List;

import javax.annotation.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Estado;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.service.EstadoService;

@Controller
@ViewScoped
public class EstadoBean {
	/**
	 * Este objeto vincula os dados da tela
	 */
	private Estado estado = new Estado();
	
	@Inject
	private EstadoService estadoService;
	
	private List<Estado> estadoList;
	
	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		estadoList = estadoService.buscarTodos();
	}

	public void salvar() {
		try {
			estadoService.salvar(estado);
			// Limpar os dados
			estado = new Estado();
			// Atualiza lista
			estadoList = estadoService.buscarTodos();
			// Envia Mensagem para Tela
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com Sucesso!", null));
		} catch (ServiceException e) {
			// Código da mensagem de erro para Tela
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Salvar: " + e.getMessage(), null));
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		estadoService.excluir(estado);
		// Nova instância para limpar formulário
		estado = new Estado();
		// Atualiza lista
		estadoList = estadoService.buscarTodos();
	}
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}	
	public EstadoService getEstadoService() {
		return estadoService;
	}
	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}	
	public List<Estado> getEstadoList() {
		return estadoList;
	}
	public void setEstadoList(List<Estado> estadoList) {
		this.estadoList = estadoList;
	}
	
}
