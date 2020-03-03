package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "AlfaCertificadoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from AlfaCertificadoEJB o")
@Table(name = "ALFA_CERTIFICADO")
public class AlfaCertificadoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4799272630606490651L;
	@Column(name="COD_SEGURO", nullable = false)
    private String codSeguro;
    @Column(name="FLG_USADO", nullable = false)
    private String flgUsado;
    @Column(name="FLG_VISIVEL", nullable = false)
    private String flgVisivel;
    @Id
    @Column(name="ID_CERTIFICADO", nullable = false)
    private Long idCertificado;
    @ManyToOne
    @JoinColumn(name = "ID_ARQUIVO", referencedColumnName = "ID_ARQUIVO")
    private AlfaArquivoEJB alfaArquivoEJB;

    public AlfaCertificadoEJB() {
    }

    public String getCodSeguro() {
        return codSeguro;
    }

    public void setCodSeguro(String codSeguro) {
        this.codSeguro = codSeguro;
    }

    public String getFlgUsado() {
        return flgUsado;
    }

    public void setFlgUsado(String flgUsado) {
        this.flgUsado = flgUsado;
    }

    public String getFlgVisivel() {
        return flgVisivel;
    }

    public void setFlgVisivel(String flgVisivel) {
        this.flgVisivel = flgVisivel;
    }


    public Long getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(Long idCertificado) {
        this.idCertificado = idCertificado;
    }

    public AlfaArquivoEJB getAlfaArquivoEJB() {
        return alfaArquivoEJB;
    }

    public void setAlfaArquivoEJB(AlfaArquivoEJB alfaArquivoEJB) {
        this.alfaArquivoEJB = alfaArquivoEJB;
    }
}
