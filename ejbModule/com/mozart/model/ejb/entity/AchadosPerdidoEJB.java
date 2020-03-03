package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the ACHADOS_PERDIDOS database table.
 * 
 */
@Entity
@Table(name="ACHADOS_PERDIDOS")
public class AchadosPerdidoEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqAchadosPerdidos")
    @SequenceGenerator(name="idSeqAchadosPerdidos", sequenceName="id", allocationSize=1)
	@Column(name="ID_ACHADOS_PERDIDOS")
	private Long idAchadosPerdidos;

	private Timestamp data;

	@Column(name="DATA_DEVOLUCAO")
	private Timestamp dataDevolucao;

	@Column(name="DOC_RECEBEDOR")
	private String docRecebedor;

	private String documento;

	@Column(name="FUNCIONARIO_ACHOU")
	private String funcionarioAchou;

	@Column(name="FUNCIONARIO_RECEBE")
	private String funcionarioRecebe;

	@Transient
	private Long idRoomList;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	private String local;

	private String objeto;

	private String periodo;

	private String recebedor;

    public AchadosPerdidoEJB() {
    }

	public Long getIdAchadosPerdidos() {
		return this.idAchadosPerdidos;
	}

	public void setIdAchadosPerdidos(Long idAchadosPerdidos) {
		this.idAchadosPerdidos = idAchadosPerdidos;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Timestamp getDataDevolucao() {
		return this.dataDevolucao;
	}

	public void setDataDevolucao(Timestamp dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getDocRecebedor() {
		return this.docRecebedor;
	}

	public void setDocRecebedor(String docRecebedor) {
		this.docRecebedor = docRecebedor;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getFuncionarioAchou() {
		return this.funcionarioAchou;
	}

	public void setFuncionarioAchou(String funcionarioAchou) {
		this.funcionarioAchou = funcionarioAchou;
	}

	public String getFuncionarioRecebe() {
		return this.funcionarioRecebe;
	}

	public void setFuncionarioRecebe(String funcionarioRecebe) {
		this.funcionarioRecebe = funcionarioRecebe;
	}

	public Long getIdRoomList() {
		return this.idRoomList;
	}

	public void setIdRoomList(Long idRoomList) {
		this.idRoomList = idRoomList;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getObjeto() {
		return this.objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getRecebedor() {
		return this.recebedor;
	}

	public void setRecebedor(String recebedor) {
		this.recebedor = recebedor;
	}

}