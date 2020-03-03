package com.mozart.model.ejb.entity;

import com.mozart.model.util.MozartUtil;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AlfaArquivoEJB.findAll", hints = { @javax.persistence.QueryHint(name = "eclipselink.refresh", value = "TRUE") }, query = "select o from AlfaArquivoEJB o")
@Table(name = "ALFA_ARQUIVO")
@SuppressWarnings("unchecked")
public class AlfaArquivoEJB extends MozartEntity {
	private static final long serialVersionUID = 1993573797406641793L;
	@Column(name = "COD_ORIGEM")
	private String codOrigem;
	@Column(name = "DSC_EMRPESA")
	private String dscEmrpesa;
	@Column(name = "DT_GERACAO")
	private Timestamp dtGeracao;
	@Id
	@Column(name = "ID_ARQUIVO", nullable = false)
	private Long idArquivo;
	@Column(name = "TIPO_LAYOUT", nullable = false)
	private String tipoLayout;
	@Column(name = "QTDE_REGISTRO")
	private Long qtdeRegistro;
	@OneToMany(mappedBy = "alfaArquivoEJB", cascade = {
			javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.PERSIST })
	private List<AlfaCertificadoEJB> alfaCertificadoEJBList;

	public AlfaArquivoEJB() {
		this.alfaCertificadoEJBList = new ArrayList();
		this.qtdeRegistro = -1L;
	}

	public String getCodOrigem() {
		return this.codOrigem;
	}

	public void setCodOrigem(String codOrigem) {
		this.codOrigem = codOrigem;
	}

	public String getDscEmrpesa() {
		return this.dscEmrpesa;
	}

	public void setDscEmrpesa(String dscEmrpesa) {
		this.dscEmrpesa = dscEmrpesa;
	}

	public Long getIdArquivo() {
		return this.idArquivo;
	}

	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}

	public String getTipoLayout() {
		return this.tipoLayout;
	}

	public void setTipoLayout(String tipoLayout) {
		this.tipoLayout = tipoLayout;
	}

	public List<AlfaCertificadoEJB> getAlfaCertificadoEJBList() {
		return this.alfaCertificadoEJBList;
	}

	public void setAlfaCertificadoEJBList(
			List<AlfaCertificadoEJB> alfaCertificadoEJBList) {
		this.alfaCertificadoEJBList = alfaCertificadoEJBList;
	}

	public AlfaCertificadoEJB addAlfaCertificadoEJB(
			AlfaCertificadoEJB alfaCertificadoEJB) {
		getAlfaCertificadoEJBList().add(alfaCertificadoEJB);
		alfaCertificadoEJB.setAlfaArquivoEJB(this);
		return alfaCertificadoEJB;
	}

	public AlfaCertificadoEJB removeAlfaCertificadoEJB(
			AlfaCertificadoEJB alfaCertificadoEJB) {
		getAlfaCertificadoEJBList().remove(alfaCertificadoEJB);
		alfaCertificadoEJB.setAlfaArquivoEJB(null);
		return alfaCertificadoEJB;
	}

	public void addLinha(String linha) {
		if (linha.startsWith("H")) {
			this.idArquivo = new Long(linha.substring(1, 11));
			this.tipoLayout = linha.substring(11, 13);
			this.dtGeracao = MozartUtil.toTimestamp(linha.substring(13, 21),
					"ddMMyyyy");
			this.codOrigem = linha.substring(21, 31);
			this.dscEmrpesa = linha.substring(31, 61);
		} else if (linha.startsWith("D")) {
			AlfaCertificadoEJB certificado = new AlfaCertificadoEJB();
			if (linha.substring(1, 2).equals("1")) {
				certificado.setFlgVisivel("S");
			} else {
				certificado.setFlgVisivel("N");
			}
			certificado.setFlgUsado("N");
			certificado.setCodSeguro(linha.substring(2, 12));
			certificado.setIdCertificado(new Long(linha.substring(12, 47)));
			addAlfaCertificadoEJB(certificado);
		} else if (linha.startsWith("T")) {
			setQtdeRegistro(new Long(linha.substring(1, 9)));
		}
	}

	public void setQtdeRegistro(Long qtdeRegistro) {
		this.qtdeRegistro = qtdeRegistro;
	}

	public Long getQtdeRegistro() {
		return this.qtdeRegistro;
	}

	public void setDtGeracao(Timestamp dtGeracao) {
		this.dtGeracao = dtGeracao;
	}

	public Timestamp getDtGeracao() {
		return this.dtGeracao;
	}
}