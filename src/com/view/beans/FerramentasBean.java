package com.view.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.intf.EmprestimoSession;
import com.model.ejb.entity.Emprestimo;

@ManagedBean(name = "ferramentasBean")
public class FerramentasBean {
	
	@EJB
	EmprestimoSession emprestimoSession;
	
	// Métodos chamados na página ferramentas
	public void exportarListaDevolvidos() {
		FileOutputStream fos = null;
		File file;
		String data = String.valueOf((new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())));
		try {
			file = new File("C:/Users/suptilocal/Documents/Emprestimos/devolvidos"+data+".csv");
			fos = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			List<Emprestimo> emprestimos = emprestimoSession.buscaDevolvidos();
			for (Emprestimo emprestimo : emprestimos) {
				fos.write(emprestimo.exportCsv().getBytes());
			}
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	
	public void exportarListaEmprestados() {
		FileOutputStream fos = null;
		File file;
		String data = String.valueOf((new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())));
		try {
			file = new File("C:/Users/suptilocal/Documents/Emprestimos/emprestados"+data+".csv");
			fos = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			List<Emprestimo> emprestimos = emprestimoSession.buscaEmprestados();
			for (Emprestimo emprestimo : emprestimos) {
				fos.write(emprestimo.exportCsv().getBytes());
			}
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String removerDevolvidos(){
		
		exportarListaEmprestados();
		exportarListaDevolvidos();
		
		List<Emprestimo> lista = emprestimoSession.buscaDevolvidos();
		for (Emprestimo emprestimo : lista) {
			emprestimoSession.remove(emprestimo);
		}
		
		return "devolvidos?faces-redirect=true";
	}

}
