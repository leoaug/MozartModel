package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the MOZART.PARTNER_DOMINIO database table.
 * 
 */
@Entity
@Table(name="MOZART.PARTNER_DOMINIO")
@NamedQueries({
@NamedQuery(name = "PartnerDominioEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from PartnerDominioEJB o")
})
public class PartnerDominioEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ID_PARTNER_DOMINIO", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_PARTNER_DOMINIO")
	@Column(name="ID_PARTNER_DOMINIO")
	private Long id;

	@Column(name="ID_EMPRESA")
	private Long idEmpresa;

	@Column(name="DOMINIO")
	private String dominio;

	@Column(name="COLOR")
	private String color;
	
	@Column(name="ATIVO")
	private String ativo;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="ARQUIVO_IMAGEM", length=4000)
	private byte[] logotipo;
	
	@Column(name="ARQUIVO_NOME")
	private String nomeLogotipo;
	
    public PartnerDominioEJB() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public byte[] getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(byte[] logotipo) {
		this.logotipo = logotipo;
	}

	public String getNomeLogotipo() {
		return nomeLogotipo;
	}

	public void setNomeLogotipo(String nomeLogotipo) {
		this.nomeLogotipo = nomeLogotipo;
	}
}