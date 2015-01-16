package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Estado;
import com.htcursos.model.service.EstadoService;

@Named
public class EstadoConverter implements Converter {

	@Inject
	EstadoService estadoService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Estado estado = estadoService.buscarPorId(Long.parseLong(id));
			return estado;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object estado) {
		Estado e = (Estado) estado;
		return e.getId().toString();
	}

}
