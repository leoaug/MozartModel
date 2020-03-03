package com.mozart.model.ejb.entity;

import java.lang.reflect.Field;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Comparator;
import java.util.List;

@SuppressWarnings({"serial","unchecked"})
@Entity
@NamedQuery(name = "MovimentoApartamentoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from MovimentoApartamentoEJB o")
@Table(name = "MOVIMENTO_APARTAMENTO")
public class MovimentoApartamentoEJB extends MozartEntity implements Cloneable {

    
	public static Comparator getComparator(){
        return new Comparator(){
            public int compare(Object o1, Object o2) {
                MovimentoApartamentoEJB primeiro = (MovimentoApartamentoEJB)o1;
                MovimentoApartamentoEJB segundo = (MovimentoApartamentoEJB)o2;
                
                String valorPrimeiro = primeiro.getQuemPaga()+""+//(MozartUtil.isNull(primeiro.getRoomListEJB())?"":primeiro.getRoomListEJB().getIdRoomList()+"")+
                					   primeiro.getTipoLancamentoEJB().getGrupoLancamento() +
                					   (primeiro.getTipoLancamentoEJB().getIdentificaLancamento().getIdentificaLancamentoPaiEJB() == null?"":primeiro.getTipoLancamentoEJB().getIdentificaLancamento().getIdentificaLancamentoPaiEJB().getDescricaoLancamento()) +                       
						               primeiro.getTipoLancamentoEJB().getDebitoCredito() + 
                                       primeiro.getTipoLancamentoEJB().getIdentificaLancamento().getDescricaoLancamento() + 
                                       (primeiro.getHoraLancamento()==null?primeiro.getDataLancamento().getTime():primeiro.getHoraLancamento().getTime());

                String valorSegundo = segundo.getQuemPaga()+""+//(MozartUtil.isNull(segundo.getRoomListEJB())?"":segundo.getRoomListEJB().getIdRoomList()+"")+
								      segundo.getTipoLancamentoEJB().getGrupoLancamento() +
						              (segundo.getTipoLancamentoEJB().getIdentificaLancamento().getIdentificaLancamentoPaiEJB()==null?"":segundo.getTipoLancamentoEJB().getIdentificaLancamento().getIdentificaLancamentoPaiEJB().getDescricaoLancamento()) +		              
						              segundo.getTipoLancamentoEJB().getDebitoCredito() + 
                                      segundo.getTipoLancamentoEJB().getIdentificaLancamento().getDescricaoLancamento()+ 
                                      (segundo.getHoraLancamento()==null?segundo.getDataLancamento().getTime():segundo.getHoraLancamento().getTime());
                    
                return valorPrimeiro.compareTo( valorSegundo );
            }
        };
    }



    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqMov")
    @SequenceGenerator(name="idSeqMov", sequenceName="id", allocationSize=1)
    @Column(name="ID_MOVIMENTO_APARTAMENTO", nullable = false)
    private Long idMovimentoApartamento;


    @Column(name="ALL_INCLUSIVE")
    private Long allInclusive;
    @Column(nullable = false)
    private String checkout;
    private String cortesia;

    @Column(name="DATA_LANCAMENTO", nullable = false)
    private Timestamp dataLancamento;
    
    private Long fap;
    @Column(name="HORA_LANCAMENTO", nullable = false)
    private Timestamp horaLancamento;
    @Column(name="ID_CONTAS_PAGAR")
    private Long idContasPagar;

    
    @Column(name="ID_NR")
    private Long idNr;
    @Column(name="ID_REDE_HOTEL")
    private Long idRedeHotel;
    @Column(name="ID_TIPO_DIARIA")
    private Long idTipoDiaria;
    @ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinColumns({
    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL"),
    @JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO")
    })
    private TipoLancamentoEJB tipoLancamentoEJB;

    private Long map;
    private String minipdv;
    @Column(name="MOV_TMP")
    private String movTmp;
    @Column(name="NUM_DOCUMENTO")
    private String numDocumento;
    private String parcial;
    @Column(name="QTDE_ADULTOS")
    private Long qtdeAdultos;
    @Column(name="QTDE_CAFE")
    private Long qtdeCafe;
    @Column(name="QTDE_CRIANCAS")
    private Long qtdeCriancas;
    private Double quantidade;
    @Column(name="QUEM_PAGA", nullable = false)
    private String quemPaga;
    @Column(name="VALOR_LANCAMENTO")
    private Double valorLancamento;
    @Column(name="VALOR_PENSAO")
    private Double valorPensao;

    @ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_CHECKIN", referencedColumnName = "ID_CHECKIN")
    private CheckinEJB checkinEJB;

    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_ROOM_LIST", referencedColumnName = "ID_ROOM_LIST")
    private RoomListEJB roomListEJB;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH  })
    @JoinColumn(name = "ID_NOTA", referencedColumnName = "ID_NOTA")
    private StatusNotaEJB statusNotaEJB;
    
    @OneToMany(mappedBy = "movimentoApartamentoEJB", fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<MovimentoMiniPdvEJB> movimentoMiniPdvEJBList;    

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH  })
    @JoinColumn(name = "ID_NF", referencedColumnName = "ID_NOTA")
    private StatusNotaEJB statusNotaFiscalEJB;
    
    @Column(name="ID_TRANSACAO_WEB")
    private Long idTransacaoWeb;
    
    @Transient
    private String dsAptoCofan;
    
    public boolean equals(Object obj){
        
        if (obj == null || idMovimentoApartamento == null || !(obj instanceof MovimentoApartamentoEJB))
            return false;
            
        return  idMovimentoApartamento.equals( ((MovimentoApartamentoEJB)obj).getIdMovimentoApartamento() );    
    }

    public MovimentoApartamentoEJB() {
    }

    public Long getAllInclusive() {
        return allInclusive;
    }

    public void setAllInclusive(Long allInclusive) {
        this.allInclusive = allInclusive;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCortesia() {
        return cortesia;
    }

    public void setCortesia(String cortesia) {
        this.cortesia = cortesia;
    }

    public Timestamp getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Timestamp dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Long getFap() {
        return fap;
    }

    public void setFap(Long fap) {
        this.fap = fap;
    }

    public Timestamp getHoraLancamento() {
        return horaLancamento;
    }

    public void setHoraLancamento(Timestamp horaLancamento) {
        this.horaLancamento = horaLancamento;
    }

    public Long getIdContasPagar() {
        return idContasPagar;
    }

    public void setIdContasPagar(Long idContasPagar) {
        this.idContasPagar = idContasPagar;
    }

    public Long getIdMovimentoApartamento() {
        return idMovimentoApartamento;
    }

    public void setIdMovimentoApartamento(Long idMovimentoApartamento) {
        this.idMovimentoApartamento = idMovimentoApartamento;
    }

    public Long getIdNr() {
        return idNr;
    }

    public void setIdNr(Long idNr) {
        this.idNr = idNr;
    }

    public Long getIdRedeHotel() {
        return idRedeHotel;
    }

    public void setIdRedeHotel(Long idRedeHotel) {
        this.idRedeHotel = idRedeHotel;
    }

    public Long getIdTipoDiaria() {
        return idTipoDiaria;
    }

    public void setIdTipoDiaria(Long idTipoDiaria) {
        this.idTipoDiaria = idTipoDiaria;
    }

    public Long getMap() {
        return map;
    }

    public void setMap(Long map) {
        this.map = map;
    }

    public String getMinipdv() {
        return minipdv;
    }

    public void setMinipdv(String minipdv) {
        this.minipdv = minipdv;
    }

    public String getMovTmp() {
        return movTmp;
    }

    public void setMovTmp(String movTmp) {
        this.movTmp = movTmp;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getParcial() {
        return parcial;
    }

    public void setParcial(String parcial) {
        this.parcial = parcial;
    }

    public Long getQtdeAdultos() {
        return qtdeAdultos;
    }

    public void setQtdeAdultos(Long qtdeAdultos) {
        this.qtdeAdultos = qtdeAdultos;
    }

    public Long getQtdeCafe() {
        return qtdeCafe;
    }

    public void setQtdeCafe(Long qtdeCafe) {
        this.qtdeCafe = qtdeCafe;
    }

    public Long getQtdeCriancas() {
        return qtdeCriancas;
    }

    public void setQtdeCriancas(Long qtdeCriancas) {
        this.qtdeCriancas = qtdeCriancas;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getQuemPaga() {
        return quemPaga;
    }

    public void setQuemPaga(String quemPaga) {
        this.quemPaga = quemPaga;
    }

    public Double getValorLancamento() {
        return valorLancamento;
    }

    public void setValorLancamento(Double valorLancamento) {
        this.valorLancamento = valorLancamento;
    }

    public Double getValorPensao() {
        return valorPensao;
    }

    public void setValorPensao(Double valorPensao) {
        this.valorPensao = valorPensao;
    }

    public void setCheckinEJB(CheckinEJB checkinEJB) {
        this.checkinEJB = checkinEJB;
    }

    public CheckinEJB getCheckinEJB() {
        return checkinEJB;
    }

    public void setRoomListEJB(RoomListEJB roomListEJB) {
        this.roomListEJB = roomListEJB;
    }

    public RoomListEJB getRoomListEJB() {
        return roomListEJB;
    }

    public void setTipoLancamentoEJB(TipoLancamentoEJB tipoLancamentoEJB) {
        this.tipoLancamentoEJB = tipoLancamentoEJB;
    }

    public TipoLancamentoEJB getTipoLancamentoEJB() {
        return tipoLancamentoEJB;
    }

    public void setStatusNotaEJB(StatusNotaEJB statusNotaEJB) {
        this.statusNotaEJB = statusNotaEJB;
    }

    public StatusNotaEJB getStatusNotaEJB() {
        return statusNotaEJB;
    }

	public List<MovimentoMiniPdvEJB> getMovimentoMiniPdvEJBList() {
		return movimentoMiniPdvEJBList;
	}

	public void setMovimentoMiniPdvEJBList(
			List<MovimentoMiniPdvEJB> movimentoMiniPdvEJBList) {
		this.movimentoMiniPdvEJBList = movimentoMiniPdvEJBList;
	}

	public void addMovimentoMiniPdvEJB(MovimentoMiniPdvEJB lancMiniPDV) {
		if (lancMiniPDV != null && movimentoMiniPdvEJBList!=null){
			lancMiniPDV.setMovimentoApartamentoEJB(this);
			movimentoMiniPdvEJBList.add(lancMiniPDV);
		}
		
	}

	public StatusNotaEJB getStatusNotaFiscalEJB() {
		return statusNotaFiscalEJB;
	}

	public void setStatusNotaFiscalEJB(StatusNotaEJB statusNotaFiscalEJB) {
		this.statusNotaFiscalEJB = statusNotaFiscalEJB;
	}

	public Long getIdTransacaoWeb() {
		return idTransacaoWeb;
	}

	public void setIdTransacaoWeb(Long idTransacaoWeb) {
		this.idTransacaoWeb = idTransacaoWeb;
	}
	
	
	
	public String getDsAptoCofan() {
		return dsAptoCofan;
	}

	public void setDsAptoCofan(String dsAptoCofan) {
		this.dsAptoCofan = dsAptoCofan;
	}

	public String toAllString() {
	    StringBuilder result = new StringBuilder();
	    String newLine = System.getProperty("line.separator");

	    result.append(this.getClass().getName());
	    result.append(" Object {");
	    result.append(newLine);

	    //determine fields declared in this class only (no fields of superclass)
	    Field[] fields = this.getClass().getDeclaredFields();

	    //print field names paired with their values
	    for (Field field : fields) {
	      result.append("  ");
	      try {
	        result.append(field.getName());
	        result.append(": ");
	        //requires access to private field:
	        result.append(field.get(this));
	      }
	      catch (IllegalAccessException ex) {
	        System.out.println(ex);
	      }
	      result.append(newLine);
	    }
	    result.append("}");

	    return result.toString();
	  }
	
	

	public Long getIdIdentificaLancamento(){
		return (getTipoLancamentoEJB()!= null)?
				getTipoLancamentoEJB().getIdIdentificaLancamento() :
					null;
	}
	
	@Override
	public MovimentoApartamentoEJB clone() throws CloneNotSupportedException {
		return (MovimentoApartamentoEJB) super.clone();
	}
	
}
