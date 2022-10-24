package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped

public class Credit  {
	private Double kwota;
	private Double okres;
	private Double proc;
	private Double result;
	
	@Inject
	@ManagedProperty("#{calcCreditErr}")
	private ResourceBundle calcCreditErr;
	
	@Inject
	@ManagedProperty("#{calcCreditText}")
	private ResourceBundle calcCreditText;



	public Double getKwota() {
		return kwota;
	}

	public void setKwota(Double kwota) {
		this.kwota = kwota;
	}

	public Double getOkres() {
		return okres;
	}

	public void setOkres(Double okres) {
		this.okres = okres;
	}

	public Double getProc() {
		return proc;
	}

	public void setProc(Double proc) {
		this.proc = proc;
	}

	public Double getResult() {
		return result;
	}



	public String calc() {
		FacesContext ctx = FacesContext.getCurrentInstance();

		result = (((proc/100) * kwota * okres) + kwota)/(okres * 12);

		ctx.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, calcCreditErr.getString("calcComputationOkInfo"), null));
		ctx.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, calcCreditText.getString("result") + ": " + result, null));

		return null;

	}

}


	




