package com.mozart.model.ejb.entity;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "EmpresaGrupoLancamentoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from EmpresaGrupoLancamentoEJB o")
@Table(name = "EMPRESA_GRUPO_LANCAMENTO")
@IdClass(EmpresaGrupoLancamentoEJBPK.class)
public class EmpresaGrupoLancamentoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3110015547969018387L;
	@Id
    @Column(name="ID_EMPRESA", nullable = false, insertable = false, updatable = false)
    private Long idEmpresa;
    @Id
    @Column(name="ID_HOTEL", nullable = false, insertable = false, updatable = false)
    private Long idHotel;
    @Id
    @Column(name="ID_IDENTIFICA_LANCAMENTO", nullable = false, insertable = false,  updatable = false)
    private Long idIdentificaLancamento;
    @Column(name="QUEM_PAGA", nullable = false)
    private String quemPaga;
    @ManyToOne
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    })
    private EmpresaHotelEJB empresaHotelEJB;

    @JoinColumn(name = "ID_IDENTIFICA_LANCAMENTO", referencedColumnName = "ID_IDENTIFICA_LANCAMENTO")
    private IdentificaLancamentoEJB identificaLancamentoEJB;

    public EmpresaGrupoLancamentoEJB() {
    }

    
    
	@SuppressWarnings("unchecked")
	public static Comparator getComparator(){
        return new Comparator(){
            public int compare(Object o1, Object o2) {
            	EmpresaGrupoLancamentoEJB primeiro = (EmpresaGrupoLancamentoEJB)o1;
            	EmpresaGrupoLancamentoEJB segundo = (EmpresaGrupoLancamentoEJB)o2;
                
                String valorPrimeiro = primeiro.getIdentificaLancamentoEJB().getDescricaoLancamento();

                String valorSegundo = segundo.getIdentificaLancamentoEJB().getDescricaoLancamento();
                    
                return valorPrimeiro.compareTo( valorSegundo );
            }
        };
    }

	
    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdIdentificaLancamento() {
        return idIdentificaLancamento;
    }

    public void setIdIdentificaLancamento(Long idIdentificaLancamento) {
        this.idIdentificaLancamento = idIdentificaLancamento;
    }

    public String getQuemPaga() {
        return quemPaga;
    }

    public void setQuemPaga(String quemPaga) {
        this.quemPaga = quemPaga;
    }

    public EmpresaHotelEJB getEmpresaHotelEJB() {
        return empresaHotelEJB;
    }

    public void setEmpresaHotelEJB(EmpresaHotelEJB empresaHotelEJB) {
        this.empresaHotelEJB = empresaHotelEJB;
    }

    public void setIdentificaLancamentoEJB(IdentificaLancamentoEJB identificaLancamentoEJB) {
        this.identificaLancamentoEJB = identificaLancamentoEJB;
    }

    public IdentificaLancamentoEJB getIdentificaLancamentoEJB() {
        return identificaLancamentoEJB;
    }
}
