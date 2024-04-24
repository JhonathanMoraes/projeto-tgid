
package com.sistema.projetoTgid.models;

import java.time.LocalDate;
import com.sistema.projetoTgid.controllers.services.EmailServices;
import com.sistema.projetoTgid.models.enums.TipoTransacao;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;

public class Transacao {

	private Long idEmpresa;
	private Long idCliente;
	private TipoTransacao tipoTransacao;
	private double valor;

	public void callBack(Empresa empresa, Cliente cliente) {
		try {
			InternetAddress[] recipients = { 
					new InternetAddress(cliente.getEmail()),
					new InternetAddress(empresa.getEmail()) 
			};
			
			EmailServices.sendEmail(recipients, this);
			System.out.println("Email enviado. Cliente ID(" + getIdCliente() + "), Empresa ID(" + getIdEmpresa() + ") - " + LocalDate.now());
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}

	}

	// Getters e Setters

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
