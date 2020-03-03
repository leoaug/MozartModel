package com.mozart.model.ejb.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.OcupDispVO;

@Entity
@Table(name="HOTEL")
@NamedQueries({
@NamedQuery(name = "HotelEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from HotelEJB o"),
@NamedQuery(name = "HotelEJB.findByRede", query = "select o from HotelEJB o where o.redeHotelEJB.idRedeHotel = ?1 and o.ativo='S' order by o.nomeFantasia", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"))
})
public class HotelEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HOTEL_IDHOTEL_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOTEL_IDHOTEL_GENERATOR")
	@Column(name="ID_HOTEL")
	private Long idHotel;

	private String ativo;

	@Column(name="CONTROLE_ATIVO_FIXO")
	private Long controleAtivoFixo;

	@Column(name="ATIVO_WEB")
	private String ativoWeb;

	private String bairro;

	private String cep;

	private String cgc;

	private String chave;

	private String classificacao;
	
	private String believer;
	
	@Column(name="CONTA_CORRENTE_DUPLICATAS")
	private Long contaCorrenteDuplicatas;

	@Column(name="CPF_CONTADOR")
	private String cpfContador;

	@Column(name="CPF_TITULAR")
	private String cpfTitular;

	@Column(name="CRC_CONTADOR")
	private String crcContador;

	private String cupomfiscal;

    @Column(name="DATA_FUNDACAO")
	private Timestamp dataFundacao;

	private Long diario;

	@Column(name="E_RESERVA")
	private String eReserva;

	private String email;

	private String endereco;

	@Column(name="ENDERECO_LOGOTIPO")
	private String enderecoLogotipo;

	@Column(name="ENDERECO_RELATORIO")
	private String enderecoRelatorio;

	private String fax;

	private String fnrh;

	@Column(name="FONTE_NOTA")
	private String fonteNota;

	private String formatoconta;

	@Column(name="FUNDO_RESERVA")
	private Double fundoReserva;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE", insertable = false, updatable = false)
    private CidadeEJB cidadeEJB;

	@Column(name="ID_CODIGO_FISCAL")
	private Long idCodigoFiscal;

	@Column(name="ID_GRUPO_ECONOMICO")
	private Long idGrupoEconomico;

	@Column(name="ID_HOTEL_REFERENCIA")
	private Long idHotelReferencia;

	@Column(name="ID_PROGRAMA")
	private Long idPrograma;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_REDE_HOTEL")
    private RedeHotelEJB redeHotelEJB;
	
	@Column(name="ID_SEDE")
	private Long idSede;

	@Column(name="INSC_EMBRATUR")
	private String inscEmbratur;

	@Column(name="INSC_ESTADUAL")
	private String inscEstadual;

	@Column(name="INSC_MUNICIPAL")
	private String inscMunicipal;

	private String internet;

	@Column(name="IR_DUPLICATAS")
	private Long irDuplicatas;

	@Column(name="ISENCAO_IR_DUPLICATAS")
	private Double isencaoIrDuplicatas;

	private Double iss;
	
	@Column(name="ISS_NF")
	private Double issNf;

	@Column(name="ISS_RETENCAO")
	private Double issRetencao;

	@Column(name="JUNTA_COMERCIAL")
	private String juntaComercial;

	private String mapfre;
    
	@Column(name="MES_ANO")
	private Timestamp mesAno;

	@Column(name="MINI_PDV")
	private String miniPdv;

	private String natureza;

	@Column(name="NOME_CONTADOR")
	private String nomeContador;

	@Column(name="NOME_FANTASIA")
	private String nomeFantasia;

	@Column(name="NOTA_FISCAL")
	private String notaFiscal;

	@Column(name="NOTA_FISCAL_CODIGO")
	private String notaFiscalCodigo;

	@Column(name="NOTA_FISCAL_TIPO")
	private String notaFiscalTipo;

	@Column(name="NOTA_HOSP")
	private String notaHosp;

	@Column(name="NOTA_HOSP_TIPO")
	private String notaHospTipo;

	@Column(name="NOTA_TERMO")
	private String notaTermo;

    @Lob()
	@Column(name="NOTA_TEXTO")
	private String notaTexto;

	@Column(name="OBRIGA_DADOS_HOSP")
	private String obrigaDadosHosp;

	@Column(name="PAGINAS_NOTA")
	private Long paginasNota;

	private String pensao;

	@Column(name="PERCENTUAL_JUROS")
	private Double percentualJuros;

	private Double razao;

	@Column(name="RAZAO_SOCIAL")
	private String razaoSocial;

	@Column(name="RESUMO_FISCAL")
	private String resumoFiscal;

	private Double roomtax;

	private String rps;

	private String sede;

	private Double seguro;

	private String sigla;

	private String site;

	@Column(name="SUB_SERIE")
	private String subSerie;

	@Column(name="TAXA_CHECKOUT")
	private String taxaCheckout;

	@Column(name="TAXA_SERVICO")
	private Double taxaServico;

	private String tef;

	private String telefone;

	private String telex;

	@Column(name="TEXTO_PROMOCIONAL")
	private String textoPromocional;

	@Column(name="TIPO_HOTEL")
	private String tipoHotel;

	private String titular;

	@Column(name="TOLL_FREE")
	private String tollFree;

	@Column(name="TOTAL_APTO")
	private String totalApto;
	
	@Column(name="IMPOSTOS_MERCADORIAS")
	private String impostosMercadoria;
	
	@Transient
	private List<OcupDispVO> disponibilidade;

	@Transient
	private List<OcupDispVO> disponibilidadeHeader;

	@Transient
	private List<OcupDispVO> tarifa;

	@Transient
	private List<OcupDispVO> tarifaHeader;
	
	@Transient
	private Boolean tarifaMedia;

	@ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_HOTEL", referencedColumnName="ID_HOTEL", insertable=false, updatable=false)
    private TelefoniasConfigEJB telefoniasConfigEJB;

	@OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_HOTEL", referencedColumnName="ID_HOTEL", insertable=false, updatable=false)
    private ReservaCondicoesEJB reservaCondicoesEJB;
	
	@OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.REFRESH})
	@JoinColumns({
		@JoinColumn(name="ID_HOTEL", referencedColumnName="ID_HOTEL_SEGURADO", insertable=false, updatable=false),
		@JoinColumn(name="ID_SEGURADORA", referencedColumnName="ID_SEGURADORA", insertable=false, updatable=false)
	})
    private EmpresaSeguradoraEJB empresaSeguradoraEJB;

	@Column(name="ID_SEGURADORA")
	private Long idSeguradora;
	
	@Column(name="COD_LOJA")
	private String codLoja;
	
    public HotelEJB() {
    }

    public boolean equals(Object obj){
    	if (obj == null)
    		return false;
    	return ((HotelEJB)obj).getIdHotel().equals( idHotel );
    }
	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	@SuppressWarnings("rawtypes")
	public static Comparator getComparator(){
        return new Comparator(){
            public int compare(Object o1, Object o2) {
                HotelEJB primeiro = (HotelEJB)o1;
                HotelEJB segundo = (HotelEJB)o2;
                
                String valorPrimeiro = primeiro.getNomeFantasia();                       

                String valorSegundo = segundo.getNomeFantasia();
                    
                return valorPrimeiro.compareTo( valorSegundo );
            }
        };
    }

	public List<OcupDispVO> getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(List<OcupDispVO> disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public List<OcupDispVO> getDisponibilidadeHeader() {
		String data = null;
		disponibilidadeHeader = new  ArrayList<OcupDispVO>();
		for (OcupDispVO linha: disponibilidade){
			if (data == null || data.equals( linha.getData())){
				disponibilidadeHeader.add( linha );
			}else{
				break;
			}
			data = linha.getData();
		}
		return disponibilidadeHeader;
	}

	public void setDisponibilidadeHeader(List<OcupDispVO> disponibilidadeHeader) {
		this.disponibilidadeHeader = disponibilidadeHeader;
	}

	public List<OcupDispVO> getTarifa() {
		if (tarifaMedia){
			List<OcupDispVO> tarifaMedia = new  ArrayList<OcupDispVO>();
			OcupDispVO linhaAnterior = null;
			Double media = 0d;
			int x = 0;
			for (OcupDispVO linha: tarifa){
				x++;
				media += (Double)(linha.getPercentual());
				if ((linhaAnterior != null && !linhaAnterior.getFantasia().equals( linha.getFantasia())) || x == tarifa.size()){
					if (linhaAnterior == null){
						linhaAnterior = linha;
					}
					linhaAnterior.setPercentual( (Double)media/x );
					tarifaMedia.add( linhaAnterior );
					media = 0d;
					x=0;
				}
				linhaAnterior = linha;
			}
			
			return tarifaMedia;
		}else{
			return tarifa;
		}
	}

	public void setTarifa(List<OcupDispVO> tarifa) {
		this.tarifa = tarifa;
	}

	public List<OcupDispVO> getTarifaHeader() {
		String data = null;
		tarifaHeader = new  ArrayList<OcupDispVO>();
		if (tarifaMedia ){
			OcupDispVO linha = tarifa.get(0);
			linha.setData("Média");
			linha.setDiaSemana("");
			tarifaHeader.add( linha );
			
		}else{
			for (OcupDispVO linha: tarifa){
				if (data == null || data.equals( linha.getFantasia())){
					tarifaHeader.add( linha );
				}else{
					break;
				}
				data = linha.getFantasia();
			}
		}
		
		return tarifaHeader;
	}

	public void setTarifaHeader(List<OcupDispVO> tarifaHeader) {
		this.tarifaHeader = tarifaHeader;
	}

	public Boolean getTarifaMedia() {
		return tarifaMedia;
	}

	public void setTarifaMedia(Boolean tarifaMedia) {
		this.tarifaMedia = tarifaMedia;
	}

	public CidadeEJB getCidadeEJB() {
		return cidadeEJB;
	}

	public void setCidadeEJB(CidadeEJB cidadeEJB) {
		this.cidadeEJB = cidadeEJB;
	}

	public RedeHotelEJB getRedeHotelEJB() {
		return redeHotelEJB;
	}

	public void setRedeHotelEJB(RedeHotelEJB redeHotelEJB) {
		this.redeHotelEJB = redeHotelEJB;
	}

	public TelefoniasConfigEJB getTelefoniasConfigEJB() {
		return telefoniasConfigEJB;
	}

	public void setTelefoniasConfigEJB(TelefoniasConfigEJB telefoniasConfigEJB) {
		this.telefoniasConfigEJB = telefoniasConfigEJB;
	}

	public ReservaCondicoesEJB getReservaCondicoesEJB() {
		return reservaCondicoesEJB;
	}

	public void setReservaCondicoesEJB(ReservaCondicoesEJB reservaCondicoesEJB) {
		this.reservaCondicoesEJB = reservaCondicoesEJB;
	}

	public EmpresaSeguradoraEJB getEmpresaSeguradoraEJB() {
		return empresaSeguradoraEJB;
	}

	public void setEmpresaSeguradoraEJB(EmpresaSeguradoraEJB empresaSeguradoraEJB) {
		this.empresaSeguradoraEJB = empresaSeguradoraEJB;
	}

	public Long getIdSeguradora() {
		return idSeguradora;
	}

	public void setIdSeguradora(Long idSeguradora) {
		this.idSeguradora = idSeguradora;
	}

	public Long getControleAtivoFixo() {
		return controleAtivoFixo;
	}

	public void setControleAtivoFixo(Long controleAtivoFixo) {
		this.controleAtivoFixo = controleAtivoFixo;
	}

	public String getAtivoWeb() {
		return ativoWeb;
	}

	public void setAtivoWeb(String ativoWeb) {
		this.ativoWeb = ativoWeb;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return MozartUtil.formatCEP(cep);
	}

	public void setCep(String cep) {
		cep = MozartUtil.removerNaoNumericos(cep);
		if (!MozartUtil.validarCEP(cep))
			throw new IllegalArgumentException("CEP informado está em formato inválido.");
		this.cep = cep;
	}

	public String getCgc() {
		return cgc;
	}

	public void setCgc(String cgc) {
		this.cgc = cgc;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getBeliever() {
		return believer;
	}

	public void setBeliever(String believer) {
		this.believer = believer;
	}

	public Long getContaCorrenteDuplicatas() {
		return contaCorrenteDuplicatas;
	}

	public void setContaCorrenteDuplicatas(Long contaCorrenteDuplicatas) {
		this.contaCorrenteDuplicatas = contaCorrenteDuplicatas;
	}

	public String getCpfContador() {
		return cpfContador;
	}

	public void setCpfContador(String cpfContador) {
		this.cpfContador = cpfContador;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public String getCrcContador() {
		return crcContador;
	}

	public void setCrcContador(String crcContador) {
		this.crcContador = crcContador;
	}

	public String getCupomfiscal() {
		return cupomfiscal;
	}

	public void setCupomfiscal(String cupomfiscal) {
		this.cupomfiscal = cupomfiscal;
	}

	public Timestamp getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Timestamp dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public Long getDiario() {
		return diario;
	}

	public void setDiario(Long diario) {
		this.diario = diario;
	}

	public String getEReserva() {
		return eReserva;
	}

	public void setEReserva(String eReserva) {
		this.eReserva = eReserva;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEnderecoLogotipo() {
		return enderecoLogotipo;
	}

	public void setEnderecoLogotipo(String enderecoLogotipo) {
		this.enderecoLogotipo = enderecoLogotipo;
	}

	public String getEnderecoRelatorio() {
		return enderecoRelatorio;
	}

	public void setEnderecoRelatorio(String enderecoRelatorio) {
		this.enderecoRelatorio = enderecoRelatorio;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFnrh() {
		return fnrh;
	}

	public void setFnrh(String fnrh) {
		this.fnrh = fnrh;
	}

	public String getFonteNota() {
		return fonteNota;
	}

	public void setFonteNota(String fonteNota) {
		this.fonteNota = fonteNota;
	}

	public String getFormatoconta() {
		return formatoconta;
	}

	public void setFormatoconta(String formatoconta) {
		this.formatoconta = formatoconta;
	}

	public Double getFundoReserva() {
		return fundoReserva;
	}

	public void setFundoReserva(Double fundoReserva) {
		this.fundoReserva = fundoReserva;
	}

	public Long getIdCodigoFiscal() {
		return idCodigoFiscal;
	}

	public void setIdCodigoFiscal(Long idCodigoFiscal) {
		this.idCodigoFiscal = idCodigoFiscal;
	}

	public Long getIdGrupoEconomico() {
		return idGrupoEconomico;
	}

	public void setIdGrupoEconomico(Long idGrupoEconomico) {
		this.idGrupoEconomico = idGrupoEconomico;
	}

	public Long getIdHotelReferencia() {
		return idHotelReferencia;
	}

	public void setIdHotelReferencia(Long idHotelReferencia) {
		this.idHotelReferencia = idHotelReferencia;
	}

	public Long getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}

	public String getInscEmbratur() {
		return inscEmbratur;
	}

	public void setInscEmbratur(String inscEmbratur) {
		this.inscEmbratur = inscEmbratur;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public Long getIrDuplicatas() {
		return irDuplicatas;
	}

	public void setIrDuplicatas(Long irDuplicatas) {
		this.irDuplicatas = irDuplicatas;
	}

	public Double getIsencaoIrDuplicatas() {
		return isencaoIrDuplicatas;
	}

	public void setIsencaoIrDuplicatas(Double isencaoIrDuplicatas) {
		this.isencaoIrDuplicatas = isencaoIrDuplicatas;
	}

	public Double getIss() {
		return iss;
	}

	public void setIss(Double iss) {
		this.iss = iss;
	}

	public Double getIssRetencao() {
		return issRetencao;
	}

	public void setIssRetencao(Double issRetencao) {
		this.issRetencao = issRetencao;
	}

	public String getJuntaComercial() {
		return juntaComercial;
	}

	public void setJuntaComercial(String juntaComercial) {
		this.juntaComercial = juntaComercial;
	}

	public String getMapfre() {
		return mapfre;
	}

	public void setMapfre(String mapfre) {
		this.mapfre = mapfre;
	}

	public Timestamp getMesAno() {
		return mesAno;
	}

	public void setMesAno(Timestamp mesAno) {
		this.mesAno = mesAno;
	}

	public String getMiniPdv() {
		return miniPdv;
	}

	public void setMiniPdv(String miniPdv) {
		this.miniPdv = miniPdv;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getNomeContador() {
		return nomeContador;
	}

	public void setNomeContador(String nomeContador) {
		this.nomeContador = nomeContador;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getNotaFiscalCodigo() {
		return notaFiscalCodigo;
	}

	public void setNotaFiscalCodigo(String notaFiscalCodigo) {
		this.notaFiscalCodigo = notaFiscalCodigo;
	}

	public String getNotaFiscalTipo() {
		return notaFiscalTipo;
	}

	public void setNotaFiscalTipo(String notaFiscalTipo) {
		this.notaFiscalTipo = notaFiscalTipo;
	}

	public String getNotaHosp() {
		return notaHosp;
	}

	public void setNotaHosp(String notaHosp) {
		this.notaHosp = notaHosp;
	}

	public String getNotaHospTipo() {
		return notaHospTipo;
	}

	public void setNotaHospTipo(String notaHospTipo) {
		this.notaHospTipo = notaHospTipo;
	}

	public String getNotaTermo() {
		return notaTermo;
	}

	public void setNotaTermo(String notaTermo) {
		this.notaTermo = notaTermo;
	}

	public String getNotaTexto() {
		return notaTexto;
	}

	public void setNotaTexto(String notaTexto) {
		this.notaTexto = notaTexto;
	}

	public String getObrigaDadosHosp() {
		return obrigaDadosHosp;
	}

	public void setObrigaDadosHosp(String obrigaDadosHosp) {
		this.obrigaDadosHosp = obrigaDadosHosp;
	}

	public Long getPaginasNota() {
		return paginasNota;
	}

	public void setPaginasNota(Long paginasNota) {
		this.paginasNota = paginasNota;
	}

	public String getPensao() {
		return pensao;
	}

	public void setPensao(String pensao) {
		this.pensao = pensao;
	}

	public Double getPercentualJuros() {
		return percentualJuros;
	}

	public void setPercentualJuros(Double percentualJuros) {
		this.percentualJuros = percentualJuros;
	}

	public Double getRazao() {
		return razao;
	}

	public void setRazao(Double razao) {
		this.razao = razao;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getResumoFiscal() {
		return resumoFiscal;
	}

	public void setResumoFiscal(String resumoFiscal) {
		this.resumoFiscal = resumoFiscal;
	}

	public Double getRoomtax() {
		return roomtax;
	}

	public void setRoomtax(Double roomtax) {
		this.roomtax = roomtax;
	}

	public String getRps() {
		return rps;
	}

	public void setRps(String rps) {
		this.rps = rps;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Double getSeguro() {
		return seguro;
	}

	public void setSeguro(Double seguro) {
		this.seguro = seguro;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getSubSerie() {
		return subSerie;
	}

	public void setSubSerie(String subSerie) {
		this.subSerie = subSerie;
	}

	public String getTaxaCheckout() {
		return taxaCheckout;
	}

	public void setTaxaCheckout(String taxaCheckout) {
		this.taxaCheckout = taxaCheckout;
	}

	public Double getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(Double taxaServico) {
		this.taxaServico = taxaServico;
	}

	public String getTef() {
		return tef;
	}

	public void setTef(String tef) {
		this.tef = tef;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelex() {
		return telex;
	}

	public void setTelex(String telex) {
		this.telex = telex;
	}

	public String getTextoPromocional() {
		return textoPromocional;
	}

	public void setTextoPromocional(String textoPromocional) {
		this.textoPromocional = textoPromocional;
	}

	public String getTipoHotel() {
		return tipoHotel;
	}

	public void setTipoHotel(String tipoHotel) {
		this.tipoHotel = tipoHotel;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTollFree() {
		return tollFree;
	}

	public void setTollFree(String tollFree) {
		this.tollFree = tollFree;
	}

	public String getTotalApto() {
		return totalApto;
	}

	public void setTotalApto(String totalApto) {
		this.totalApto = totalApto;
	}

	public Double getIssNf() {
		return issNf;
	}

	public void setIssNf(Double issNf) {
		this.issNf = issNf;
	}

	public String getCodLoja() {
		return codLoja;
	}

	public void setCodLoja(String codLoja) {
		this.codLoja = codLoja;
	}

	public String getImpostosMercadoria() {
		return impostosMercadoria;
	}

	public void setImpostosMercadoria(String impostosMercadoria) {
		this.impostosMercadoria = impostosMercadoria;
	}
}