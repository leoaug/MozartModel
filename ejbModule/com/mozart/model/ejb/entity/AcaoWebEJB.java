package com.mozart.model.ejb.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="ACAO_WEB")
public class AcaoWebEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;
	private long idAcaoWeb;
	private BigDecimal idAcaoApelidoWeb;
	private BigDecimal idMenu;
	private BigDecimal idPrograma;
	private String inicial;
	private String jspPage;
	private String nome;

    public AcaoWebEJB() {
    }

	@Id
	@Column(name="ID_ACAO_WEB")
	public long getIdAcaoWeb() {
		return this.idAcaoWeb;
	}

	public void setIdAcaoWeb(long idAcaoWeb) {
		this.idAcaoWeb = idAcaoWeb;
	}

	@Column(name="ID_ACAO_APELIDO_WEB")
	public BigDecimal getIdAcaoApelidoWeb() {
		return this.idAcaoApelidoWeb;
	}

	public void setIdAcaoApelidoWeb(BigDecimal idAcaoApelidoWeb) {
		this.idAcaoApelidoWeb = idAcaoApelidoWeb;
	}

	@Column(name="ID_MENU")
	public BigDecimal getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(BigDecimal idMenu) {
		this.idMenu = idMenu;
	}

	@Column(name="ID_PROGRAMA")
	public BigDecimal getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(BigDecimal idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getInicial() {
		return this.inicial;
	}

	public void setInicial(String inicial) {
		this.inicial = inicial;
	}

	@Column(name="JSP_PAGE")
	public String getJspPage() {
		return this.jspPage;
	}

	public void setJspPage(String jspPage) {
		this.jspPage = jspPage;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}