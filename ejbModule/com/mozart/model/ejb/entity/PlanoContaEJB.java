package com.mozart.model.ejb.entity;


import javax.persistence.*;





/**
 * The persistent class for the PLANO_CONTAS database table.
 * 
 */
@Entity
@NamedQueries({				
	@NamedQuery  (name = "PlanoContaEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
			    	    query = "select o from PlanoContaEJB o where o.idRedeHotel=?1 order by o.contaContabil")
			})
@Table(name="PLANO_CONTAS")
public class PlanoContaEJB extends MozartEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PC_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PC_GENERATOR")
	@Column(name="ID_PLANO_CONTAS")
	private Long idPlanoContas;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="ATIVO_PASSIVO")
	private String ativoPassivo;

	private String cofins;

	@Column(name="CONTA_CONTABIL")
	private String contaContabil;

	@Column(name="CONTA_CREDORA_DEP")
	private String contaCredoraDep;

	@Column(name="CONTA_CREDORA_MON")
	private String contaCredoraMon;

	@Column(name="CONTA_DEVEDORA_DEP")
	private String contaDevedoraDep;

	@Column(name="CONTA_DEVEDORA_MON")
	private String contaDevedoraMon;

	@Column(name="CONTA_REDUZIDA")
	private String contaReduzida;

	@Column(name="CORRECAO_MONETARIA")
	private String correcaoMonetaria;

	private String depreciacao;

	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_HISTORICO_CREDITO", referencedColumnName="ID_HISTORICO")
	private HistoricoContabilEJB historicoCredito;

	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="ID_HISTORICO_DEBITO", referencedColumnName="ID_HISTORICO")
	private HistoricoContabilEJB historicoDebito;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_HOTEL_MUTUO")
	private Long idHotelMutuo;

	@ManyToOne
	@JoinColumn(name="ID_PLANO_CONTAS_SPED", referencedColumnName="ID_PLANO_CONTAS_SPED")
	private PlanoContasSpedEJB planoContasSpedEJB;

	private String mutuo;

	@Column(name="NOME_CONTA")
	private String nomeConta;

	private Double percentual;

	@Column(name="RAZAO_AUXILIAR")
	private String razaoAuxiliar;

	@Column(name="TIPO_CONTA")
	private String tipoConta;

	//bi-directional many-to-one association to PlanoConta
    @ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumns({
		@JoinColumn(name="ID_CONTA_DEV_DEP", referencedColumnName="ID_PLANO_CONTAS")
		})
	private PlanoContaEJB planoConta1;

	//bi-directional many-to-one association to PlanoConta
    @ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumns({
		@JoinColumn(name="ID_CONTA_CRED_DEP", referencedColumnName="ID_PLANO_CONTAS")
		})
	private PlanoContaEJB planoConta2;

    @Transient
    private String dsContaContabil;
    
    public String getDsContaContabil() {
		return this.contaReduzida + " - " + contaContabil + " - "+ nomeConta;
	}


	public void setDsContaContabil(String dsContaContabil) {
		this.dsContaContabil = dsContaContabil;
	}


	public PlanoContaEJB() {
    	
    }

    
	public String toString(){
    	
    	return contaContabil+" - "+ativoPassivo+" - "+ nomeConta; 
    }

	
	public String getAtivoPassivo() {
		return this.ativoPassivo;
	}

	public void setAtivoPassivo(String ativoPassivo) {
		this.ativoPassivo = ativoPassivo;
	}

	public String getCofins() {
		return this.cofins;
	}

	public void setCofins(String cofins) {
		this.cofins = cofins;
	}

	public String getContaContabil() {
		return this.contaContabil;
	}

	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}

	public String getContaCredoraDep() {
		return this.contaCredoraDep;
	}

	public void setContaCredoraDep(String contaCredoraDep) {
		this.contaCredoraDep = contaCredoraDep;
	}

	public String getContaCredoraMon() {
		return this.contaCredoraMon;
	}

	public void setContaCredoraMon(String contaCredoraMon) {
		this.contaCredoraMon = contaCredoraMon;
	}

	public String getContaDevedoraDep() {
		return this.contaDevedoraDep;
	}

	public void setContaDevedoraDep(String contaDevedoraDep) {
		this.contaDevedoraDep = contaDevedoraDep;
	}

	public String getContaDevedoraMon() {
		return this.contaDevedoraMon;
	}

	public void setContaDevedoraMon(String contaDevedoraMon) {
		this.contaDevedoraMon = contaDevedoraMon;
	}

	public String getContaReduzida() {
		return this.contaReduzida;
	}

	public void setContaReduzida(String contaReduzida) {
		this.contaReduzida = contaReduzida;
	}

	public String getCorrecaoMonetaria() {
		return this.correcaoMonetaria;
	}

	public void setCorrecaoMonetaria(String correcaoMonetaria) {
		this.correcaoMonetaria = correcaoMonetaria;
	}

	public String getDepreciacao() {
		return this.depreciacao;
	}

	public void setDepreciacao(String depreciacao) {
		this.depreciacao = depreciacao;
	}


	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdHotelMutuo() {
		return this.idHotelMutuo;
	}

	public void setIdHotelMutuo(Long idHotelMutuo) {
		this.idHotelMutuo = idHotelMutuo;
	}

	public String getMutuo() {
		return this.mutuo;
	}

	public void setMutuo(String mutuo) {
		this.mutuo = mutuo;
	}

	public String getNomeConta() {
		return this.nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	public Double getPercentual() {
		return this.percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public String getRazaoAuxiliar() {
		return this.razaoAuxiliar;
	}

	public void setRazaoAuxiliar(String razaoAuxiliar) {
		this.razaoAuxiliar = razaoAuxiliar;
	}

	public String getTipoConta() {
		return this.tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public PlanoContaEJB getPlanoConta1() {
		return this.planoConta1;
	}

	public void setPlanoConta1(PlanoContaEJB planoConta1) {
		this.planoConta1 = planoConta1;
	}
	
	
	public PlanoContaEJB getPlanoConta2() {
		return this.planoConta2;
	}

	public void setPlanoConta2(PlanoContaEJB planoConta2) {
		this.planoConta2 = planoConta2;
	}
	
	public Long getIdPlanoContas() {
		return idPlanoContas;
	}

	public void setIdPlanoContas(Long idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}

	public Long getIdRedeHotel() {
		return idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public HistoricoContabilEJB getHistoricoCredito() {
		return historicoCredito;
	}

	public void setHistoricoCredito(HistoricoContabilEJB historicoCredito) {
		this.historicoCredito = historicoCredito;
	}

	public HistoricoContabilEJB getHistoricoDebito() {
		return historicoDebito;
	}

	public void setHistoricoDebito(HistoricoContabilEJB historicoDebito) {
		this.historicoDebito = historicoDebito;
	}

	public PlanoContasSpedEJB getPlanoContasSpedEJB() {
		return planoContasSpedEJB;
	}

	public void setPlanoContasSpedEJB(PlanoContasSpedEJB planoContasSpedEJB) {
		this.planoContasSpedEJB = planoContasSpedEJB;
	}


	
}