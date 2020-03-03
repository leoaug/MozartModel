package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONFIG_WEB database table.
 * 
 */
@Entity
@Table(name="CONFIG_WEB")
public class ConfigWebEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONFIG_WEB_IDCONFIGWEB_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONFIG_WEB_IDCONFIGWEB_GENERATOR")
	@Column(name="ID_CONFIG_WEB")
	private Long idConfigWeb;

	@Column(name="BUCKET")
	private String bucket;
	
	@Column(name="BLOQUEAR_ACESSO")
	private String bloquearAcesso;

    public ConfigWebEJB() {
    }

	public Long getIdConfigWeb() {
		return this.idConfigWeb;
	}

	public void setIdConfigWeb(Long idConfigWeb) {
		this.idConfigWeb = idConfigWeb;
	}

	public String getBloquearAcesso() {
		return this.bloquearAcesso;
	}

	public void setBloquearAcesso(String bloquearAcesso) {
		this.bloquearAcesso = bloquearAcesso;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

}