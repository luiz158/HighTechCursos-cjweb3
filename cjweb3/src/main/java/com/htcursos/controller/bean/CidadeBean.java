package com.htcursos.controller.bean;

import java.util.List;

import javax.annotation.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Cidade;
import com.htcursos.model.entity.Estado;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.service.CidadeService;

@Controller
@ViewScoped
public class CidadeBean {
	/**
	 * Este objeto vincula os dados da tela
	 */
	private Cidade cidade = new Cidade();
	
	@Inject
	private CidadeService cidadeService;
	
	private List<Cidade> cidadeList;
	
	@SuppressWarnings("restriction")
	@PostConstruct
	public void init() {
		cidadeList = cidadeService.buscarTodos();
	}

	public void salvar() {
		try {
			cidadeService.salvar(cidade);
			// Limpar os dados
			cidade = new Cidade();
			// Atualiza lista
			cidadeList = cidadeService.buscarTodos();
			// Envia Mensagem para Tela
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com Sucesso!", null));
		} catch (ServiceException e) {
			// Código da mensagem de erro para Tela
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Salvar: " + e.getMessage(), null));
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		cidadeService.excluir(cidade);
		// Nova instância para limpar formulário
		cidade = new Cidade();
		// Atualiza lista
		cidadeList = cidadeService.buscarTodos();
	}
	
	public void buscarCidades(ValueChangeEvent evento) {
		if(evento.getNewValue() != evento.getOldValue()) {
			Estado estado = (Estado)evento.getNewValue();
			
			cidadeList = cidadeService.buscarCidades(estado);
		}
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}	
	public CidadeService getCidadeService() {
		return cidadeService;
	}
	public void setCidadeService(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}	
	public List<Cidade> getCidadeList() {
		return cidadeList;
	}
	public void setCidadeList(List<Cidade> cidadeList) {
		this.cidadeList = cidadeList;
	}
	
}
