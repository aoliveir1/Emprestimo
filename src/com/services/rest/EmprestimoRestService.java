package com.services.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ejb.intf.EmprestimoSession;
import com.model.dto.EmprestimoDTO;
import com.model.ejb.entity.Emprestimo;


@Path("emprestimos")
@ManagedBean
@RequestScoped
public class EmprestimoRestService {
	
	@EJB
	private EmprestimoSession emprestimoSession;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getEquipamentos() {		
		return Response.ok().entity(this.converteParaDTO(emprestimoSession.buscaTodos())).build();
	}
	
	
	private List<EmprestimoDTO> converteParaDTO(List<Emprestimo> emprestimos) {
		List<EmprestimoDTO> dtos = new ArrayList<EmprestimoDTO>();
		for(Emprestimo e : emprestimos) {
			EmprestimoDTO dto = new EmprestimoDTO(e.getId(),e.getNome(),e.getMaterial(),e.getSala(),e.getEmprestado());
			dtos.add(dto);
		}
		return dtos;
	}

}
